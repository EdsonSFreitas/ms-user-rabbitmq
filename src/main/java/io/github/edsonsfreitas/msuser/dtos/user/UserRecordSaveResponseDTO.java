package io.github.edsonsfreitas.msuser.dtos.user;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Edson da Silva Freitas
 * {@code @created} 30/10/2023
 * {@code @project} msuser-rabbitmq
 */

public record UserRecordSaveResponseDTO(UUID id,
                                        String firstName,
                                        String lastName,
                                        String email,
                                        LocalDateTime createdAt) {
}