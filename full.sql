BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (product_id BIGSERIAL PRIMARY KEY, title VARCHAR (255), price INT);
INSERT INTO products (title, price) VALUES
                                           ('Авокадо', 70),
                                           ('Хлеб', 1),
                                           ('Рыба', 50),
                                           ('Яблоко', 15),
                                           ('Макароны', 10);

COMMIT;