CREATE TABLE chats(
    id SERIAL not null,
    content text not null,
    room_id integer not null references rooms(id),
    user_id integer not null references users(id),
    PRIMARY KEY(id)
);
