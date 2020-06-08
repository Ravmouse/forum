create table users (
	id serial primary key,
	name varchar(255),
	surname varchar(255),
	birth timestamp without time zone not null,
	email varchar(255),
	login varchar(255),
	password varchar(255)
);

create table posts (
	id serial primary key,
	name varchar(255),
	description varchar(255),
	created timestamp without time zone not null default now(),
	user_id int references users(id)
);