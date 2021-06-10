package com.microservice.ratingsData.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.ratingsData.models.MovieRatings;
import com.microservice.ratingsData.models.UserRatings;


@RestController
@RequestMapping("/ratings")
public class RatingsResources {
	
	@GetMapping("/{movieId}")
	public MovieRatings getRating(@PathVariable("movieId") String movieId)
	{
		return new MovieRatings(movieId, 4);
	}
	
	@GetMapping("/user/{userId}")
	public UserRatings getRatingList(@PathVariable("userId") String movieId)
	{
		List<MovieRatings> list=Arrays.asList(new MovieRatings("550", 2),new MovieRatings("200", 4),new MovieRatings("100", 5));
		UserRatings usrRatings=new UserRatings();
		usrRatings.setUserRatingList(list);
		return usrRatings;
	}

}
