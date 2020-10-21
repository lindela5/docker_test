--liquibase formatted sql
--changeset sinitsa:01-insert-order-table

INSERT INTO orders (order_id, customer_id, order_date, amount) VALUES
    (1, 2, '2008-07-14 00:00:00',28 ),
    (2, 1,'2008-07-14 00:00:00', 28.3);
GO



--rollback DELETE FROM orders;

