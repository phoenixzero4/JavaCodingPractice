-- POPULATE DOGS TABLE
INSERT INTO dogs (dogname, color)
VALUES ('Brodi', 'black'),
       ('Kira', 'blue merle'),
       ('Leroy', 'black and white'),
       ('Clyde', 'black'),
       ('Nico', 'black'),
       ('Lael', 'blue merle');

-- POPULATE OWNERS TABLE
INSERT INTO owners (ownerName)
VALUES ('Phoenix'),
       ('William'),
       ('Gloria');

-- POPULATE OWNERSDOGS (JUNCTION) TABLE
INSERT INTO ownersDogs(ownerId, dogId)
VALUES (1, 1),
       (1, 3),
       (1, 6),
       (2, 4),
       (3, 5),
       (3, 2);