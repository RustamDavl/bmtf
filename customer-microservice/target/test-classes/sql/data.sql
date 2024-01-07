insert into customer (id, first_name, email, phone, password)
values (1, 'Rust', 'rust@gmail.com', '9179209061', 'pass'),
       (2, 'Anna', 'anna@gmail.com', '9179275668', 'passanna'),
       (3, 'Arina', 'arina@gmail.com', '9179209880', 'passgw'),
       (4, 'Anton', 'anton@gmail.com', '9179669264', 'passga'),
       (5, 'Nikolay', 'nik@gmail.com', '9179209432', 'passaf');
select setval('customer_id_seq', (select max(id) from customer));

insert into customer_address (id, customer_id, city, street, street_number, doorway_number, floor_number, flat_number)
values (1, 1, 'kazan', 'ametevo', 16, 4, 5, 384),
       (2, 1, 'kazan', 'mavlutova', 18, 1, 2, 532),
       (3, 1, 'leninogorsk', 'lenina', 3, 2, 2, 38),
       (4, 2, 'almetevsk', 'krupskoy', 24, 4, 3, 8),
       (5, 3, 'chelny', 'lenina', 14, 2, 5, 84),
       (6, 3, 'moscow', 'test', 32, 6, 5, 63),
       (7, 4, 'kazan', 'ametevo', 5, 4, 19, 436),
       (8, 5, 'kazan', 'ametevo', 24, 4, 4, 456),
       (9, 5, 'kazan', 'ametevo', 18, 7, 14, 23);
select setval('customer_address_id_seq', (select max(id) from customer_address));