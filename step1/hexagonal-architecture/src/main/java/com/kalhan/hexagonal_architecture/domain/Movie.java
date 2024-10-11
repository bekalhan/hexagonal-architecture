package com.kalhan.hexagonal_architecture.domain;

import java.time.LocalDate;

public record Movie(
        Long id,
        String title,
        String description,
        LocalDate releaseDate,
        String directorName
) {
}
