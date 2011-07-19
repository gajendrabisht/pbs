insert into movie (id, name, year) values (1, 'The Shawshank Redemption', 1994);
insert into movie (id, name, year) values (2, 'The Matrix', 1999);
insert into movie (id, name, year) values (3, 'Gattaca', 1997);

insert into movie_rating(movie_id, user_id, rating) values(1, 1, 10);
insert into movie_rating(movie_id, user_id, rating) values(1, 2, 10);
insert into movie_rating(movie_id, user_id, rating) values(1, 3, 10);
insert into movie_rating(movie_id, user_id, rating) values(2, 1, 10);
insert into movie_rating(movie_id, user_id, rating) values(2, 2, 9);
insert into movie_rating(movie_id, user_id, rating) values(2, 3, 8);
insert into movie_rating(movie_id, user_id, rating) values(3, 1, 10);
insert into movie_rating(movie_id, user_id, rating) values(3, 2, 8);
insert into movie_rating(movie_id, user_id, rating) values(3, 3, 7);