create table users (
    id bigserial,
    name varchar(255),
    primary key (id)
);
create table emails (
    id bigserial,
    address varchar(255),
    user_id bigint references users (id) on delete cascade,
    primary key (id)
);

