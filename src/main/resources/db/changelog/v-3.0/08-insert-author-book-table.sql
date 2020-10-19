--liquibase formatted sql
--changeset sinitsa:01-insert-books-table


INSERT INTO authr_book (book_id, author_id) VALUES
    (1, 5),
    (2, 8),
    (2, 9);
GO


--rollback DELETE FROM author;