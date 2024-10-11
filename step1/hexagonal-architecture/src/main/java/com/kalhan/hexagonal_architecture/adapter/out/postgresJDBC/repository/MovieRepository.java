package com.kalhan.hexagonal_architecture.adapter.out.postgresJDBC.repository;


import com.kalhan.hexagonal_architecture.adapter.out.postgresJDBC.entity.MovieEntity;
import com.kalhan.hexagonal_architecture.domain.Movie;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity,Long> {

    @Query("select * from movies where title =: title")
    Optional<Movie> findMovieByTitle(@Param("title") String title);
}
