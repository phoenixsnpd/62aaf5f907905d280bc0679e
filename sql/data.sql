INSERT INTO mainland(name) VALUES ('Europe'), ('Africa'), ('North America'), ('Pangea');

INSERT INTO country(name, mainland_id) VALUES ('Ukraine', 1), ('England', 1),
                                              ('Egypt', 2), ('Tanzania', 2),
                                              ('United States', 3), ('Canada', 3),
                                              ('Pangea country 1', 4), ('Pangea country 2', 4);

INSERT INTO city(name, population, county_id)
VALUES ('Kyiv', 2.8, 1), ('Dnipro', 0.9, 1), ('Lviv', 0.6, 1),
       ('London', 9, 2), ('Manchester', 0.5, 2), ('Cambridge', 0.1, 2),
       ('Cairo', 9.6, 3), ('Luxor', 1.3, 3), ('Alexandria', 5.2, 3),
       ('Zanzibar', 1.5, 4), ('Tanga', 0.2, 4), ('Dodoma', 2, 4),
       ('New York', 8.4, 5), ('Los Angeles', 3.8, 5), ('Washington', 0.7, 5),
       ('Toronto', 2.9, 6), ('Winnipeg', 0.7, 6), ('Quebec', 8.4, 6),
       ('Pangea sity 1', 0, 7), ('Pangea sity 2', 0, 7), ('Pangea sity 3', 0, 7),
       ('Pangea sity 4', 0, 7), ('Pangea sity 5', 0, 7), ('Pangea sity 6', 0, 7);

ALTER TABLE mainland
    ADD existing BOOLEAN DEFAULT (true);

UPDATE mainland
SET existing = false WHERE name = 'Pangea';

INSERT INTO city(name, population, county_id)
VALUES ('new city', -6, 4);