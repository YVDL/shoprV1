INSERT INTO book (id, type, price, supplier_id, title , author , isbn , pages, description) VALUES (6, 'FICTION', 10.99, 1, 'test', 'test', '9789012345678' , 150, 'Test')
INSERT INTO book (id, type, price, supplier_id, title , author , isbn , pages, description) VALUES (8, 'NON_FICTION', 19.99, 4, 'test', 'test', '9789012345687' , 300, 'Test')

INSERT INTO game (title, type, price, supplier_id, publisher, min_age, game_genre) VALUES ('MotoGp', 'GAME', 45.95, 'test', 'RaceGames', 12, 'RACE');
INSERT INTO game (title, type, price, supplier_id, publisher, min_age, game_genre) VALUES ('GTA', 'GAME', 45.95, 'test', 'GTA producers', 16, 'RPG');

INSERT INTO lp (price, supplier_id, title, type, lp_genre, producer, performer) VALUES ('29.95', '321', 'War', 'LP', 'ROCK', 'Test', 'U2');

INSERT INTO user (user_name, street, house_number, postal_code, city, email_address) VALUES ('Youri Vanderleyden', 'Javastraat', 55, 2000, 'Antwerpen', 'yourivanderleyden@gmail.com');

