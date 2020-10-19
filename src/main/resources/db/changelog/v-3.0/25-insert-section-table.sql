--liquibase formatted sql
--changeset sinitsa:25-insert-sections-table


INSERT INTO author (id, name_section) VALUES
    (1, 'Detective' ),
    (2, 'Fantasy'),
    (3, ''),
    (4, 'United Kingdom'),
    (5, 'United Kingdom'),
    (6, 'United Kingdom'),
    (7, 'Russia'),
    (8, 'United Kingdom'),
    (9, 'United Kingdom');
GO


--rollback DELETE FROM author;