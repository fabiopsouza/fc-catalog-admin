package com.github.fullcycle.catalog.admin.application;

import com.github.fullcycle.catalog.admin.domain.category.Category;

public abstract class UseCase<IN, OUT> {
    public abstract OUT execute(IN anIn);
}
