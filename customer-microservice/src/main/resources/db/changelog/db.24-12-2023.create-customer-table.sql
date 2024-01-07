--liquibase formatted sql

--changeset rudv:1
create table customer
(
    id         bigserial primary key,
    first_name varchar(32)  not null,
    email      varchar(64)  not null unique,
    phone      varchar(10)  not null unique,
    password   varchar(256) not null

);