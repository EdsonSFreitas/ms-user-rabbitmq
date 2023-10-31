 -- drop table if exists tb_users;
 create table if not exists tb_users (
        created_at timestamp(6),
        user_id uuid not null,
        email varchar(255) not null unique,
        first_name varchar(255) not null,
        last_name varchar(255) not null,
        primary key (user_id)
    );