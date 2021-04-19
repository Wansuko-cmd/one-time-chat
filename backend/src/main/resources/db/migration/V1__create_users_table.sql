CREATE TABLE users(
    id SERIAL not null,
    name text not null,
    image_path text,
    email text,
    password text,
    PRIMARY KEY(id)
);
