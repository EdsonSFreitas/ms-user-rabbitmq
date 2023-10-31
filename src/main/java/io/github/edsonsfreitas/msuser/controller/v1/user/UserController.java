package io.github.edsonsfreitas.msuser.controller.v1.user;

import io.github.edsonsfreitas.msuser.dtos.user.UserRecordDTO;
import io.github.edsonsfreitas.msuser.dtos.user.UserRecordFindResponseDTO;
import io.github.edsonsfreitas.msuser.dtos.user.UserRecordPageResponseDTO;
import io.github.edsonsfreitas.msuser.dtos.user.UserRecordSaveResponseDTO;
import io.github.edsonsfreitas.msuser.models.user.UserModel;
import io.github.edsonsfreitas.msuser.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

/**
 * @author Edson da Silva Freitas
 * {@code @created} 30/10/2023
 * {@code @project} msuser-rabbitmq
 */
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/v1/users")
    @Transactional
    public ResponseEntity<UserRecordSaveResponseDTO> saveUser(@RequestBody @Valid UserRecordDTO userRecordDTO,
                                                              UriComponentsBuilder uriBuilder) {
        UserModel newUser = new UserModel();
        BeanUtils.copyProperties(userRecordDTO, newUser);
        final UserModel response = userService.saveUser(newUser);
        var uri = uriBuilder.path("/api/v1/users/{id}").buildAndExpand(response.getUserId()).toUri();
        return ResponseEntity.created(uri).body(
                new UserRecordSaveResponseDTO(
                        response.getUserId(),
                        response.getFirstName(),
                        response.getLastName(),
                        response.getEmail(),
                        response.getCreatedAt()));

    }

    @GetMapping("/v1/users/{id}")
    public ResponseEntity<UserRecordFindResponseDTO> findUser(@PathVariable("id") UUID id) {
        final UserModel response = userService.findByUUID(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        UserRecordFindResponseDTO responseDTO = new UserRecordFindResponseDTO(
                response.getUserId(),
                response.getEmail(),
                response.getFirstName(),
                response.getLastName(),
                response.getCreatedAt()
        );

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/v1/users")
    public ResponseEntity<Page<UserRecordPageResponseDTO>> findAllUsers(Pageable pageable) {
        final Page<UserRecordPageResponseDTO> all = userService.findAll(pageable);
        return ResponseEntity.ok(all);
    }

}