CREATE TABLE room_user(
    id SERIAL not null,
    room_id integer not null references rooms(id),
    user_id integer not null references users(id),
    PRIMARY KEY(id)
);
