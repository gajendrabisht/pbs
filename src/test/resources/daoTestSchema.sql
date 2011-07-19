-- Create tables for spring security --
create table User (
	id int primary key auto_increment,
	name varchar(100),
	email varchar(50),
	password varchar(50),
	country varchar(50)
);

create table country_option (
	name varchar(100) primary key
);

create table movie (
	id int primary key auto_increment,
	name varchar(100),
	year int
);

create table movie_rating (
	movie_id int not null,
	user_id int not null,
	rating int not null,
	primary key (movie_id, user_id),
	foreign key (movie_id) references movie(id),
	foreign key (user_id) references User(id)
);