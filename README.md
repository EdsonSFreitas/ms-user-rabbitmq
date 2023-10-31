<h1 align="center">:file_cabinet: Microservices de Producer com comunicação assíncrona e RabbitMQ</h1>

## :memo: Resumo do projeto
* Microservices user para comunicação assíncrona não bloqueante com RabbitMQ;

## :books: Objetivo do projeto
* Implementar microservices entre user e email utilizando mensageria com Spring RabbitMQ disparando e-mails via SMTP Google;

## :books: Funcionalidades implementadas
* Registro de usuário grava no banco e dispara uma mensagem para o RabbitMQ;
* Conteúdo da mensagem possui toda informação necessária para a partir dela um consumer disparar um e-mail com o conteúdo da mensagem
* Rotinas básicas de boas práticas (Organização dos pacotes, validações, uso de DTOs etc.)

## :wrench: Tecnologias utilizadas
* Spring Boot Web
* Spring RabbitMQ
* PostgreSQL Driver (Para prod)
* H2 Database (para ambiente dev)
* Lombok
* Validation
* Spring Email
* Spring Data JPA
* Java 17
* Serviço de mensageria do CloudAMPQ

## :rocket: Executando o projeto

Pré-requisitos:
1. Em andamento

## :soon: Implementação futura
* Em andamento

## :dart: Status do projeto
* Em andamento