package io.github.edsonsfreitas.msuser.repository.user;

import io.github.edsonsfreitas.msuser.models.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Edson da Silva Freitas
 * {@code @created} 30/10/2023
 * {@code @project} msuser-rabbitmq
 */

public interface UserRepository extends JpaRepository<UserModel, UUID> {

}