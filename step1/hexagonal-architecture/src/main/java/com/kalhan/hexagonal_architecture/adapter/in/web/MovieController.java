package com.kalhan.hexagonal_architecture.adapter.in.web;

import com.kalhan.hexagonal_architecture.application.dto.NewMovieDto;
import com.kalhan.hexagonal_architecture.application.usecase.MovieUseCase;
import com.kalhan.hexagonal_architecture.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieUseCase movieUseCase;

    @GetMapping
    public ResponseEntity<?> getAllMovies() {
        return ResponseEntity.ok(movieUseCase.getAllMovies());
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> getMovieByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(movieUseCase.getMovieByTitle(title));
    }

    @PostMapping
    public ResponseEntity<?> saveMovie(@RequestBody NewMovieDto newMovieDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieUseCase.saveMovie(newMovieDto));
    }

    @PutMapping
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieUseCase.updateMovie(movie));
    }

}
