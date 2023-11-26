package com.github.fullcycle.catalog.admin.application.genre.update;

import com.github.fullcycle.catalog.admin.domain.genre.Genre;

public record UpdateGenreOutput(String id) {

    public static UpdateGenreOutput from(final Genre aGenre) {
        return new UpdateGenreOutput(aGenre.getId().getValue());
    }
}
