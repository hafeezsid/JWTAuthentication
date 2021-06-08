package com.microservice.movieCatalog.models;

public class MovieRatings {
	
	private String movieId;
	private int ratings;
	public MovieRatings() {
		// TODO Auto-generated constructor stub
	}
	public MovieRatings(String movieId, int ratings) {
		super();
		this.movieId = movieId;
		this.ratings = ratings;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
	

}
