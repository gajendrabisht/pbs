package com.pbs.domain.imdb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MovieRatingId implements Serializable {
	
	private static final long serialVersionUID = -4366135917063967564L;

	@Column(name="movie_id")
	private Long movieId;
	
	@Column(name="user_id")
	private Long userId;
	
	public MovieRatingId() {}

	public MovieRatingId(Long movieId, Long userId) {
		this.movieId = movieId;
		this.userId = userId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
