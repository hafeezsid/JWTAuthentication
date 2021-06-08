package com.microservice.movieInfo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.movieInfo.models.Movie;
import com.microservice.movieInfo.models.MovieSummary;


@RestController
@RequestMapping("/movieInfo")
public class MovieInfoResources {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${api.key}")
	private String apiKey;
	
	@GetMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId)
	{
		MovieSummary summary=restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey, MovieSummary.class);
		return new Movie(movieId,summary.getTitle(),summary.getOverview());
	}

}
