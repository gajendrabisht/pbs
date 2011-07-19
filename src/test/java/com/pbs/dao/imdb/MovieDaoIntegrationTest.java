package com.pbs.dao.imdb;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.pbs.dao.UserDao;
import com.pbs.domain.User;
import com.pbs.domain.imdb.Movie;
import com.pbs.domain.imdb.MovieRating;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/daoTestContext.xml")
@Transactional
public class MovieDaoIntegrationTest {
	
	@Resource MovieDao movieDao;
	@Resource UserDao userDao;
	
	@Test
	public void shouldAddAndGetMovie() {
		// given user
		User user = new User(1L, "name", "email@pbs.com", "password", "country");
		userDao.save(user);
		// and movie
		MovieRating rating = new MovieRating();
		List<MovieRating> ratings = Arrays.asList(rating);
		Movie movie = new Movie(2L, "someMovie", 2011, ratings); 
		rating.setMovie(movie);
		rating.setUser(user);
		rating.setRating(10);
		
		// when we save the movie with the user rating
		movieDao.save(movie);
		
		// then the movie is successfully saved
		Movie movieReturned = movieDao.get(2L);
	}
	
	@Test
	public void shouldReturnAllMovies() {
		// given user
		User user = new User(1L, "name", "email@pbs.com", "password", "country");
		userDao.save(user);
		// and movie
		MovieRating rating = new MovieRating();
		List<MovieRating> ratings = Arrays.asList(rating);
		Movie movie = new Movie(2L, "someMovie", 2011, ratings); 
		rating.setMovie(movie);
		rating.setUser(user);
		rating.setRating(10);
		movieDao.save(movie);
		// and another movie
		MovieRating rating2 = new MovieRating();
		List<MovieRating> ratings2 = Arrays.asList(rating2);
		Movie movie2 = new Movie(3L, "someMovie", 2011, ratings2); 
		rating2.setMovie(movie2);
		rating2.setUser(user);
		rating2.setRating(10);
		movieDao.save(movie2);
		
		// when we get all movies
		List<Movie> allMovies = movieDao.getAllMovies();
		
		// then
		assertThat(allMovies.size(), is(2));
	}
	
}
