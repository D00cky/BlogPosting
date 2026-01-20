CREATE TABLE roles (
    id BIGSERIAL primary key,
    role_name varchar(255) NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);