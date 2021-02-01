CREATE TABLE scores (
                        score_id BIGSERIAL PRIMARY KEY,
                        value INT NOT NULL DEFAULT (0)
);

CREATE TABLE users (
    user_id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    score_id BIGINT NOT NULL DEFAULT (0),
    FOREIGN KEY (score_id) REFERENCES scores (score_id)
);

CREATE TABLE roles (
                       role_id SERIAL PRIMARY KEY,
                       name VARCHAR(50) NOT NULL
);

CREATE TABLE users_roles (
                        user_id BIGINT NOT NULL,
                        role_id INT NOT NULL,
                        PRIMARY KEY (user_id, role_id),
                        FOREIGN KEY (user_id) REFERENCES users (user_id),
                        FOREIGN KEY (role_id) REFERENCES roles (role_id)
);

INSERT INTO scores (score_id, value) VALUES
(1, 100),
(2, 200),
(3, 300);

INSERT INTO users (username, password, score_id) VALUES
                                              ('user1', '$2y$12$UOvfbfpn8qo7PAcPOC7wkOv8g4yPTWP5oa7c/5L.4zm0BLc/.OVIi', 1),
                                              ('user2', '$2y$12$19iPAx9oUDSAQwQiJkXYX.4UzsbjPidqwJIVt0ukOZ643HJBCy2CG', 2),
                                              ('user3', '$2y$12$XQ7FIEtecw/6g71aACzWaeqzPzauXnVDwic6pun/JDAsGpAK0CiKW', 3);

INSERT INTO roles (name) VALUES ('ROLE_USER');

INSERT INTO users_roles (user_id, role_id) VALUES
(1, 1),
(2, 1),
(3, 1);