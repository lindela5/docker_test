--liquibase formatted sql
--changeset sinitsa:20-insert-publishing-house-table

INSERT INTO books (publishing_house_id, name_publisher, address) VALUES
    (1, 'Penguin Clothbound Classics', ''),
    (2, ' BBC Books', 'Westminster, London, England');
GO




--rollback DELETE FROM author;



