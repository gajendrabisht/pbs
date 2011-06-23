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