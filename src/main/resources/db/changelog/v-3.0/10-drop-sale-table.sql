ALTER TABLE sales
   DROP CONSTRAINT FK_sales_customer_id
GO

ALTER TABLE sales
   DROP CONSTRAINT FK_sales_books_id
GO

DROP TABLE IF EXISTS sales CASCADE;
GO