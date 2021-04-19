CREATE TABLE rooms(
    id SERIAL not null,
    hash text not null,
    password text,
    PRIMARY KEY(id)
);
