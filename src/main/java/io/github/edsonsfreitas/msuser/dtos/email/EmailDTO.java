package io.github.edsonsfreitas.msuser.dtos.email;

import java.util.UUID;

/**
 * @author Edson da Silva Freitas
 * {@code @created} 31/10/2023
 * {@code @project} msuser-rabbitmq
 */

public record EmailDTO(UUID userId, String emailTo, String subject, String emailBody) {
}