package com.github.fullcycle.catalog.admin.application;

import com.github.fullcycle.catalog.admin.domain.category.Category;

public class UseCase {
    public Category execute() {
        return new Category();
    }
}