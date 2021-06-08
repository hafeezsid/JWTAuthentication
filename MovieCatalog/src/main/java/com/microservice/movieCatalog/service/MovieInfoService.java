package com.microservice.movieCatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.movieCatalog.models.CatalogItem;
import com.microservice.movieCatalog.models.Movie;
import com.microservice.movieCatalog.models.MovieRatings;

@Service
public class MovieInfoService {

	@Autowired
	private RestTemplate restTemplate;

	//@HystrixCommand(fallbackMethod = "getMovieInfoFallback")
	public CatalogItem getMovieInfo(MovieRatings r) {
		Movie obj = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movieInfo/" + r.getMovieId(), Movie.class);
		return new CatalogItem(obj.getName(), obj.getOverview(), r.getRatings());
	}

	public CatalogItem getMovieInfoFallback(MovieRatings r) {
		return new CatalogItem("No Movie with this name", "no desc", r.getRatings());
	}
}
