   ALTER TABLE books
   ADD CONSTRAINT FK_books_publishing_house_id
   FOREIGN KEY (publishing_house_id)
   REFERENCES publishing_house
GO


ALTER TABLE publishing_house
   ADD CONSTRAINT FK_books_publishing_house_id unique (name_publisher)
GO


ALTER TABLE books
   ADD CONSTRAINT FK_books_sections_id
   FOREIGN KEY (section_id)
   REFERENCES sections
GO



ALTER TABLE supply
    ADD CONSTRAINT FK_supply_supplier_id
        FOREIGN KEY (supplier_id) REFERENCES supplier(id);
GO


