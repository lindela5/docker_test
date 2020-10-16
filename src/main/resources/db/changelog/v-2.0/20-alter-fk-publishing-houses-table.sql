ALTER TABLE publishing_house
   ADD CONSTRAINT FK_books_publishing_house_id unique (name_publisher)
GO