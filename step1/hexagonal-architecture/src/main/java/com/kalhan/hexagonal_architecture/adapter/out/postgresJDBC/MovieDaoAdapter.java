package com.kalhan.hexagonal_architecture.adapter.out.postgresJDBC;

import com.kalhan.hexagonal_architecture.adapter.out.postgresJDBC.entity.MovieEntity;
import com.kalhan.hexagonal_architecture.adapter.out.postgresJDBC.repository.MovieRepository;
import com.kalhan.hexagonal_architecture.application.dao.MovieDao;
import com.kalhan.hexagonal_architecture.application.dto.NewMovieDto;
import com.kalhan.hexagonal_architecture.domain.Movie;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MovieDaoAdapter implements MovieDao {

    private final MovieRepository movieRepository;

    @Override
    public Optional<Movie> findMovieByTitle(String title) {
        return movieRepository.findMovieByTitle(title);
    }

    @Override
    public List<Movie> findAllMovies() {
        return ((List<MovieEntity>) movieRepository.findAll())
                .stream()
                .map(movieEntity -> {
                    return new Movie(
                            movieEntity.id(),
                            movieEntity.title(),
                            movieEntity.description(),
                            movieEntity.releaseDate(),
                            movieEntity.directorName()
                    );
                }).toList();
    }

    @Override
    public void saveMovie(NewMovieDto newMovieDto) {
         movieRepository.save(new MovieEntity(
                null,
                newMovieDto.title(),
                newMovieDto.description(),
                newMovieDto.releaseDate(),
                newMovieDto.directorName(),
                null
        ));
    }

    @Override
    public void updateMovie(Movie newMovie) {
        movieRepository.save(new MovieEntity(
                newMovie.id(),
                newMovie.title(),
                newMovie.description(),
                newMovie.releaseDate(),
                newMovie.directorName(),
                null
        ));
    }

    @Override
    public void deleteMovie(Movie oldMovie) {

    }
}
