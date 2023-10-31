package io.github.edsonsfreitas.msuser.services.user;

import io.github.edsonsfreitas.msuser.dtos.user.UserRecordPageResponseDTO;
import io.github.edsonsfreitas.msuser.models.user.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Edson da Silva Freitas
 * {@code @created} 30/10/2023
 * {@code @project} msuser-rabbitmq
 */

public interface UserService {

    UserModel saveUser(UserModel userToSave);

    Optional<UserModel> findByUUID(UUID id);

    Page<UserRecordPageResponseDTO> findAll(Pageable pageable);
}