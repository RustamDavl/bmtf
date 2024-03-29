--liquibase formatted sql

--changeset rudv:1
create table customer_address
(
    id             bigserial primary key,
    customer_id    bigint references customer (id) on delete cascade,
    city           varchar(32) not null,
    street         varchar(32) not null,
    street_number  smallint    not null,
    doorway_number smallint    not null,
    floor_number   smallint    not null,
    flat_number    smallint    not null
);