--liquibase formatted sql
--changeset sinitsa:35-insert-supply-table

INSERT INTO supply (supply_id, supplier_id, supply_date, supplier_price) VALUES
    (1, 2, '2008-07-14 00:00:00',28 ),
    (2, 1,'2008-07-14 00:00:00', 28.3);
GO




--rollback DELETE FROM supply;