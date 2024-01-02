--liquibase formatted sql

--changeset rudv:1
alter table customer
add column password varchar(256) not null;