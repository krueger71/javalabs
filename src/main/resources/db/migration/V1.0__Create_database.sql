create table if not exists account (
     number bigint primary key,
     name varchar2(64) not null,
     version bigint not null default(1)
);

create table if not exists transaction (
     id serial primary key,
     occurred timestamp with time zone not null default(now()),
     noticed timestamp with time zone not null default(now())
);

create table if not exists entry (
     id serial primary key,
     account bigint not null references account(number),
     transaction bigint not null references transaction(id),
     amount numeric(38, 2) not null
);
