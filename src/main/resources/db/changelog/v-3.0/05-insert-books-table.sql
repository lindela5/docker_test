--liquibase formatted sql
--changeset sinitsa:02-insert-books-table


INSERT INTO books (book_id, title, isbn, year_of_issue,publishing_house_id,price,stock_balances) VALUES
    (1, 'The Adventures of Sherlock Holmes', '9780241347782', 2018,1,23,2),
    (2, 'Good Omens', '9781910281918', 2015,2,23.16,1);
GO


--rollback DELETE FROM books;