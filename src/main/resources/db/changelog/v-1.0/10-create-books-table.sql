CREATE TABLE books (
    book_id         int ,
    title       VARCHAR(100),
    isbn   VARCHAR(100),
    year_of_issue int ,
    publisher_id int,
    price     int,
    stock_balances int,
    PRIMARY KEY (book_id)
);
GO

CREATE TABLE author_book(
	book_id int,
    author_id int
);
GO

ALTER TABLE     author_book
    ADD CONSTRAINT  FK_author_books_author_id
    FOREIGN KEY (author_id) REFERENCES author
GO

ALTER TABLE  author_book
    ADD CONSTRAINT FK_author_books_books_id
    FOREIGN KEY (book_id) REFERENCES books
GO

