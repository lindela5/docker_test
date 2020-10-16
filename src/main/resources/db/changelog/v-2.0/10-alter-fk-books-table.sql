ALTER TABLE books
   ADD CONSTRAINT FK_books_publishing_house_id
   FOREIGN KEY (publishing_house_id)
   REFERENCES publishing_house
GO