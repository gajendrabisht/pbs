package com.pbs.domain.imdb;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String name;
	@Column
	private Integer year;
	@OneToMany(mappedBy="movie")
	private List<MovieRating> ratings;

	public Movie() { /* For Hibernate */ }

	public Movie(Long id, String name, Integer year, List<MovieRating> ratings) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.ratings = ratings;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public List<MovieRating> getRatings() {
		return ratings;
	}

	public void setRatings(List<MovieRating> ratings) {
		this.ratings = ratings;
	}
	
	public String getAverageRating() {
		Double averageMovieRating = 0D;
		for(MovieRating rating: ratings) {
			averageMovieRating += rating.getRating();
		}
		return new BigDecimal(averageMovieRating/ratings.size()).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
	}
	
}
