package com.microservice.movieCatalog.restControllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.movieCatalog.models.CatalogItem;
import com.microservice.movieCatalog.models.UserRatings;
import com.microservice.movieCatalog.service.MovieInfoService;
import com.microservice.movieCatalog.service.RatingInfoService;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {

	@Autowired
	MovieInfoService movieInfoService;

	@Autowired
	RatingInfoService ratingInfoService;

	@GetMapping("/{userId}")
	public List<CatalogItem> getMoviesCatalog(@PathVariable("userId") String userId) {

		UserRatings userRatings = ratingInfoService.getMovieRatings(userId);
		return userRatings.getUserRatingList().stream().map(r -> {
			return movieInfoService.getMovieInfo(r);
		}).collect(Collectors.toList());
	}

}
