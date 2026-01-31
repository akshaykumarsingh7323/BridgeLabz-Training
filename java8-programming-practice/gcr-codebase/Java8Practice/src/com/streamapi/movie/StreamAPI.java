package com.streamapi.movie;

import java.util.List;

import java.util.List;
import java.util.Comparator;

public class StreamAPI {

    public List<Movie> getTop5TrendingMovies(List<Movie> movies) {

        return movies.stream()

                .filter(movie -> movie.getReleaseYear() >= 2018)

                .sorted(Comparator.comparing(Movie::getRating).reversed())

                .limit(5)

                .toList();
    }
}
