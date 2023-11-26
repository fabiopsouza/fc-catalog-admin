package com.github.fullcycle.catalog.admin.application.genre.retrieve.list;

import com.github.fullcycle.catalog.admin.application.UseCase;
import com.github.fullcycle.catalog.admin.domain.pagination.Pagination;
import com.github.fullcycle.catalog.admin.domain.pagination.SearchQuery;

public abstract class ListGenreUseCase
        extends UseCase<SearchQuery, Pagination<GenreListOutput>> {
}
