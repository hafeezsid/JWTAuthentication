package com.microservice.movieCatalog.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.movieCatalog.models.MovieRatings;
import com.microservice.movieCatalog.models.UserRatings;

@Service
public class RatingInfoService {
	@Autowired
	private RestTemplate restTemplate;

	//@HystrixCommand(fallbackMethod = "getMovieRatingsFallback")
	public UserRatings getMovieRatings(String userId) {
		return restTemplate.getForObject("http://MOVIE-RATING-SERVICE/ratings/user/" + userId, UserRatings.class);
	}

	public UserRatings getMovieRatingsFallback(String userId) {
		return new UserRatings(Arrays.asList(new MovieRatings("No ID", 0)));
	}

}
