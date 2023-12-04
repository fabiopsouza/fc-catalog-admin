package com.github.fullcycle.catalog.admin.infrastructure.api.controllers;

import com.github.fullcycle.catalog.admin.application.genre.create.CreateGenreCommand;
import com.github.fullcycle.catalog.admin.application.genre.create.CreateGenreUseCase;
import com.github.fullcycle.catalog.admin.application.genre.delete.DeleteGenreUseCase;
import com.github.fullcycle.catalog.admin.application.genre.retrieve.get.GetGenreByIdUseCase;
import com.github.fullcycle.catalog.admin.application.genre.retrieve.list.ListGenreUseCase;
import com.github.fullcycle.catalog.admin.application.genre.update.UpdateGenreCommand;
import com.github.fullcycle.catalog.admin.application.genre.update.UpdateGenreUseCase;
import com.github.fullcycle.catalog.admin.domain.pagination.Pagination;
import com.github.fullcycle.catalog.admin.domain.pagination.SearchQuery;
import com.github.fullcycle.catalog.admin.infrastructure.api.GenreAPI;
import com.github.fullcycle.catalog.admin.infrastructure.genre.models.CreateGenreRequest;
import com.github.fullcycle.catalog.admin.infrastructure.genre.models.GenreListResponse;
import com.github.fullcycle.catalog.admin.infrastructure.genre.models.GenreResponse;
import com.github.fullcycle.catalog.admin.infrastructure.genre.models.UpdateGenreRequest;
import com.github.fullcycle.catalog.admin.infrastructure.genre.presenters.GenreApiPresenter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class GenreController implements GenreAPI {

    private final CreateGenreUseCase createGenreUseCase;
    private final DeleteGenreUseCase deleteGenreUseCase;
    private final GetGenreByIdUseCase getGenreByIdUseCase;
    private final ListGenreUseCase listGenreUseCase;
    private final UpdateGenreUseCase updateGenreUseCase;

    public GenreController(
            final CreateGenreUseCase createGenreUseCase,
            final DeleteGenreUseCase deleteGenreUseCase,
            final GetGenreByIdUseCase getGenreByIdUseCase,
            final ListGenreUseCase listGenreUseCase,
            final UpdateGenreUseCase updateGenreUseCase
    ) {
        this.createGenreUseCase = createGenreUseCase;
        this.deleteGenreUseCase = deleteGenreUseCase;
        this.getGenreByIdUseCase = getGenreByIdUseCase;
        this.listGenreUseCase = listGenreUseCase;
        this.updateGenreUseCase = updateGenreUseCase;
    }

    @Override
    public ResponseEntity<?> create(final CreateGenreRequest input) {
        final var aCommand = CreateGenreCommand.with(
                input.name(),
                input.isActive(),
                input.categories()
        );

        final var output = this.createGenreUseCase.execute(aCommand);

        return ResponseEntity.created(URI.create("/genres/" + output.id())).body(output);
    }

    @Override
    public Pagination<GenreListResponse> list(
            final String search,
            final int page,
            final int perPage,
            final String sort,
            final String direction
    ) {
        return this.listGenreUseCase.execute(new SearchQuery(page, perPage, search, sort, direction))
                .map(GenreApiPresenter::present);
    }

    @Override
    public GenreResponse getById(final String id) {
        return GenreApiPresenter.present(this.getGenreByIdUseCase.execute(id));
    }

    @Override
    public ResponseEntity<?> updateById(final String id, final UpdateGenreRequest input) {
        final var aCommand = UpdateGenreCommand.with(
                id,
                input.name(),
                input.isActive(),
                input.categories()
        );

        final var output = this.updateGenreUseCase.execute(aCommand);

        return ResponseEntity.ok(output);
    }

    @Override
    public void deleteById(final String id) {
        this.deleteGenreUseCase.execute(id);
    }
}
