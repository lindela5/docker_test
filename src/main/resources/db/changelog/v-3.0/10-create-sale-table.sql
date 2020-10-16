CREATE TABLE sales (
    sale_id         int NOT NULL,
    book_id      int NOT NULL,
    customer_id   int NOT NULL,
    sale_date date ,
    quantity int NOT NULL,
    amount    int NOT NULL,
    PRIMARY KEY (sale_id)
);
GO

ALTER TABLE sales
    ADD CONSTRAINT FK_sales_books_id
        FOREIGN KEY (book_id) REFERENCES books(book_id);
GO

ALTER TABLE sales
    ADD CONSTRAINT FK_sales_customer_id
        FOREIGN KEY (customer_id) REFERENCES customer(customer_id);
GO
