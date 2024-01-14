--liquibase formatter sql

--changeset rudv:1
create table owner
(
    id       bigserial primary key,
    name     varchar(32)  not null,
    email    varchar(128) not null unique,
    phone    varchar(11)  not null unique,
    password varchar(256) not null
);

--changeset rudv:2
create table restaurant
(
    id             bigserial primary key,
    name           varchar(64) not null,
    payment_method varchar(15) not null,
    email          varchar(64) not null unique,
    title_photo    bytea,
    status         varchar(15) not null,
    owner_id       bigint      not null references owner (id) on delete cascade

);

--changeset rudv:3
create table restaurant_schedule
(
    id             bigserial primary key,
    beginning_time time   not null,
    ending_time    time   not null,
    mon            boolean,
    tue            boolean,
    wed            boolean,
    thur           boolean,
    sat            boolean,
    sun            boolean,
    restaurant_id  bigint not null references restaurant (id) on delete cascade
);

--changeset rudv:4
create table address
(
    id            bigserial primary key,
    restaurant_id bigint unique not null references restaurant (id) on delete cascade,
    city          varchar(64)   not null,
    street        varchar(64)   not null,
    house_number  smallint      not null
);

--changeset rudv:5
create table contact
(
    id            bigserial primary key,
    restaurant_id bigint      not null unique references restaurant (id) on delete cascade,
    boss          varchar(11) not null,
    common        varchar(11) not null,
    additional    varchar(11)

);

--changeset rudv:6
create table menu_category
(
    id      bigserial primary key,
    name    varchar(64) not null unique,
    restaurant_id bigint      not null references menu (id) on delete cascade

);

--changeset rudv:7
create table position
(
    id          bigserial primary key,
    name        varchar(128) not null,
    price       int          not null,
    image       bytea,
    description varchar(256),
    weigh       int          not null,
    category_id bigint       not null references category (id)
);

-- add review later

-- --changeset rudv:9
-- create table review
-- (
--     id            bigserial primary key,
--     rate          smallint,
--     comment       varchar(256),
--     created_at    timestamp not null,
--     restaurant_id bigint    not null references restaurant (id) on delete cascade
-- );
