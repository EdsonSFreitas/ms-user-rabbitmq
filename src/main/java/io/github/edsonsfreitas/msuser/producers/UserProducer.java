package io.github.edsonsfreitas.msuser.producers;

import io.github.edsonsfreitas.msuser.dtos.email.EmailDTO;
import io.github.edsonsfreitas.msuser.models.user.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Edson da Silva Freitas
 * {@code @created} 31/10/2023
 * {@code @project} msuser-rabbitmq
 */

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingkey;

    public void publishMessageEmail(UserModel userModel){
        var emailDto = new EmailDTO(
                userModel.getUserId(),
                userModel.getEmail(),
                userModel.getFirstName() + " - Cadastro realizado com sucesso",
                userModel.getFirstName()+ ", seja bem vindo! \nSeu cadastro foi realizado com sucesso."
                );

        //Adicionei uma string vazia como exchange para usar o exchange default, portanto, a routing key será o nome da queue
        rabbitTemplate.convertAndSend("", routingkey, emailDto);

    }

}