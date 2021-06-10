package com.microservice.ratingsData.models;

import java.util.List;

public class UserRatings {

	private List<MovieRatings> userRatingList;

	public UserRatings() {
		// TODO Auto-generated constructor stub
	}

	public UserRatings(List<MovieRatings> userRatingList) {
		super();
		this.userRatingList = userRatingList;
	}

	public List<MovieRatings> getUserRatingList() {
		return userRatingList;
	}

	public void setUserRatingList(List<MovieRatings> userRatingList) {
		this.userRatingList = userRatingList;
	}

}
