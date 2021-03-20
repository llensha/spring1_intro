CREATE TABLE products (
    id              BIGSERIAL PRIMARY KEY,
    title           VARCHAR(255) NOT NULL,
    cost            DECIMAL NOT NULL,
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                      );

INSERT INTO products (title, cost) VALUES
('Авокадо', 70),
('Хлеб', 1),
('Лосось', 50),
('Яблоко', 15),
('Макароны', 10),
('Говядина', 90),
('Пирожок с вишней', 10),
('Торт', 30),
('Тунец', 35),
('Свинина', 55),
('Банан', 20),
('Печенье', 25),
('Вермишель', 12),
('Грейпфрут', 35),
('Огурец', 10),
('Помидор', 7),
('Мороженое', 25),
('Шоколад', 13),
('Лимон', 5),
('Варенье', 15);