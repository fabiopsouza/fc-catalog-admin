package com.github.fullcycle.catalog.admin.application.category.create;

import com.github.fullcycle.catalog.admin.application.UseCase;
import com.github.fullcycle.catalog.admin.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class CreateCategoryUseCase
        extends UseCase<CreateCategoryCommand, Either<Notification, CreateCategoryOutput>> {
}