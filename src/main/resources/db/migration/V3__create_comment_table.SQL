CREATE TABLE comment (
    id BIGSERIAL primary key,
    title VARCHAR(500) not null,
    text VARCHAR(5000) not null,
    user_id BIGINT not null,
    post_id BIGINT not null,
    CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id),
    CONSTRAINT fk_post FOREIGN KEY(post_id) REFERENCES post(id)
);