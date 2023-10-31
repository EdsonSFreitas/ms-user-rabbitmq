package io.github.edsonsfreitas.msuser.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * @author Edson da Silva Freitas
 * {@code @created} 30/10/2023
 * {@code @project} msuser-rabbitmq
 */

public record UserRecordDTO(@NotBlank String firstName,
                            @NotBlank String lastName,
                            @NotBlank @Email String email) {
}