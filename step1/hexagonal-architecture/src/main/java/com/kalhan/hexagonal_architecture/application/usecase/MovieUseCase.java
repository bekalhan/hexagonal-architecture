package com.kalhan.hexagonal_architecture.application.usecase;

import com.kalhan.hexagonal_architecture.application.dao.MovieDao;
import com.kalhan.hexagonal_architecture.application.dto.NewMovieDto;
import com.kalhan.hexagonal_architecture.domain.Movie;
import com.kalhan.hexagonal_architecture.infrastructure.exception.MovieAlreadyExistException;
import com.kalhan.hexagonal_architecture.infrastructure.exception.MovieNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieUseCase {
    private final MovieDao movieDao;

    public String saveMovie(NewMovieDto newMovieDto){
        var isPresent = movieDao.findMovieByTitle(newMovieDto.title()).isPresent();

        if(isPresent) throw new MovieAlreadyExistException("Movie already exist");

        movieDao.saveMovie(newMovieDto);

        return "Movie saved successfully";
    }

    public List<Movie> getAllMovies(){
        return movieDao.findAllMovies();
    }

    public String updateMovie(Movie movie){
        var isPresent = movieDao.findMovieByTitle(movie.title()).isPresent();

        if(!isPresent) throw new MovieNotFoundException("Movie not found");

        movieDao.updateMovie(movie);

        return "Movie update successfully";
    }

    public Movie getMovieByTitle(String movieTitle){
        return movieDao.findMovieByTitle(movieTitle).orElseThrow(
                () ->  new MovieNotFoundException("Movie not found")
        );
    }
}
