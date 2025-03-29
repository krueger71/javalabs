create table if not exists test (
     id serial primary key,
     name varchar2(64) not null
);
comment on table test is 'Just a table for test purposes';
