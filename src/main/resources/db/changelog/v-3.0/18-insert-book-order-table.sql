--liquibase formatted sql
--changeset sinitsa:18-insert-book-order-table


INSERT INTO book_order (order_id, book_id, quantity) VALUES
    (1, 5, 2),
    (2, 8, 1),
    (2, 9, 1);
GO



--rollback DELETE FROM book-order;