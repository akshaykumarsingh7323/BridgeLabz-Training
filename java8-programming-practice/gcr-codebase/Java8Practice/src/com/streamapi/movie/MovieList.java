package com.streamapi.movie;

import java.util.List;

public class MovieList {
	public static void main(String[] args) {
		List<Movie> movies = List.of(
			    new Movie("Inception", 2010, 8.8),
			    new Movie("Avengers", 2019, 8.4),
			    new Movie("Joker", 2019, 8.5),
			    new Movie("Dune", 2021, 8.2),
			    new Movie("Oppenheimer", 2023, 8.9),
			    new Movie("Tenet", 2020, 7.9),
			    new Movie("Interstellar", 2014, 8.6),
			    new Movie("Batman", 2022, 8.3)
			);
		StreamAPI service = new StreamAPI();

        List<Movie> topMovies = service.getTop5TrendingMovies(movies);

        topMovies.forEach(System.out::println);
	}
}
