package com.github.fullcycle.catalog.admin.application.category.retrieve.list;

import com.github.fullcycle.catalog.admin.domain.category.CategoryGateway;
import com.github.fullcycle.catalog.admin.domain.pagination.Pagination;
import com.github.fullcycle.catalog.admin.domain.pagination.SearchQuery;

import java.util.Objects;

public class DefaultListCategoriesUseCase extends ListCategoriesUseCase {

    private final CategoryGateway categoryGateway;

    public DefaultListCategoriesUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public Pagination<CategoryListOutput> execute(final SearchQuery aQuery) {
        return this.categoryGateway.findAll(aQuery)
                .map(CategoryListOutput::from);
    }
}
