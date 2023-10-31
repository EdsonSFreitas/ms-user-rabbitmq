package io.github.edsonsfreitas.msuser.services.user.impl;

import io.github.edsonsfreitas.msuser.dtos.user.UserRecordPageResponseDTO;
import io.github.edsonsfreitas.msuser.models.user.UserModel;
import io.github.edsonsfreitas.msuser.repository.user.UserRepository;
import io.github.edsonsfreitas.msuser.services.user.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Edson da Silva Freitas
 * {@code @created} 30/10/2023
 * {@code @project} msuser-rabbitmq
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<UserModel> findByUUID(UUID id) {
        final UserModel userNotFound = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return Optional.of(userNotFound);
    }

    @Override
    public Page<UserRecordPageResponseDTO> findAll(Pageable pageable) {
        final Page<UserModel> pageResult = userRepository.findAll(pageable);
        List<UserRecordPageResponseDTO> response = pageResult.getContent()
                .stream()
                .map(user -> new UserRecordPageResponseDTO(
                        user.getUserId(),
                        user.getEmail(),
                        user.getCreatedAt()
                ))
                .toList();
        return new PageImpl<>(response, pageable, pageResult.getTotalElements());
    }

    @Override
    public UserModel saveUser(UserModel userToSave) {
        userToSave.setCreatedAt(LocalDateTime.now());
        final UserModel userModel = userRepository.save(userToSave);
        return userModel;
    }
}