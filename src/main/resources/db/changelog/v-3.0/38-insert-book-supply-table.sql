--liquibase formatted sql
--changeset sinitsa:38-insert-book-supply-table

INSERT INTO book_supply (supply_id, book_id, quantity) VALUES
    (1, 5, 2),
    (2, 8, 1),
    (2, 9, 1);
GO

--rollback DELETE FROM book_supply;