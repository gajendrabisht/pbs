package com.pbs.domain.imdb;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pbs.domain.User;

@Entity(name="movie_rating")
public class MovieRating {
	
	@EmbeddedId
	private MovieRatingId movieRatingId = new MovieRatingId();
	
	@ManyToOne
	@JoinColumn(name="movie_id", insertable=false, updatable= false)
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name="user_id", insertable=false, updatable= false)
	private User user;
	
	@Column
	private Integer rating;

	public MovieRating() { /* For Hibernate */ }

	public MovieRating(Movie movie, User user, Integer rating) {
		this.movie = movie;
		this.user = user;
		this.rating = rating;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
}
