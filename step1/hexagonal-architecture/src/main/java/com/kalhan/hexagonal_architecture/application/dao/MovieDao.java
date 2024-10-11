package com.kalhan.hexagonal_architecture.application.dao;

import com.kalhan.hexagonal_architecture.application.dto.NewMovieDto;
import com.kalhan.hexagonal_architecture.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDao {
    Optional<Movie> findMovieByTitle(String title);
    List<Movie> findAllMovies();
    void saveMovie(NewMovieDto newMovieDto);
    void updateMovie(Movie newMovie);
    void deleteMovie(Movie oldMovie);
}
