create table if not exists name (
     id serial primary key,
     name varchar2(64) not null unique
);
comment on table name is 'Unique names';
