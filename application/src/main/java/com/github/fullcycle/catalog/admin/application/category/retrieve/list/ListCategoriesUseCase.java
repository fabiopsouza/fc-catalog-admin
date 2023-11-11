package com.github.fullcycle.catalog.admin.application.category.retrieve.list;

import com.github.fullcycle.catalog.admin.application.UseCase;
import com.github.fullcycle.catalog.admin.domain.pagination.Pagination;
import com.github.fullcycle.catalog.admin.domain.pagination.SearchQuery;

public abstract class ListCategoriesUseCase
        extends UseCase<SearchQuery, Pagination<CategoryListOutput>> {
}