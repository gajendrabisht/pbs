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
	
	@Test
	public void shouldReturnAvailableMovies() {
		// given
		Movie movie1 = new Movie(1L, "Titanic", 2000, null);
		Movie movie2 = new Movie(2L, "Trainspotting", 2001, null);
		Movie movie3 = new Movie(2L, "How to Train your dragon", 2002, null);
		Movie movie4 = new Movie(2L, "Training Day", 2003, null);
		movieDao.save(movie1);
		movieDao.save(movie2);
		movieDao.save(movie3);
		movieDao.save(movie4);
		
		// when
		List<Movie> availableMovies = movieDao.getAutoCompleteSuggestedMovies("train");
		
		// then
		assertThat(availableMovies.size(), is(2));
		assertThat(availableMovies.get(0).getName(), is("Training Day"));
		assertThat(availableMovies.get(1).getName(), is("Trainspotting"));
	}
	
}
