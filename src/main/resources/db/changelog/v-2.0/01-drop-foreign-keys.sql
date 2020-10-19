ALTER TABLE supply
   DROP CONSTRAINT FK_supply_supplier_id
GO

ALTER TABLE books
   DROP CONSTRAINT FK_books_sections_id
GO

ALTER TABLE publishing_house
   DROP CONSTRAINT FK_books_publishing_house_id
GO

ALTER TABLE books
   DROP CONSTRAINT FK_books_publishing_house_id
GO










