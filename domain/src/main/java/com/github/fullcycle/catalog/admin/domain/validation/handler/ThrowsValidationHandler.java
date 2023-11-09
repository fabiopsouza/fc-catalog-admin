package com.github.fullcycle.catalog.admin.domain.validation.handler;

import com.github.fullcycle.catalog.admin.domain.exceptions.DomainException;
import com.github.fullcycle.catalog.admin.domain.validation.Error;
import com.github.fullcycle.catalog.admin.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
    @Override
    public ValidationHandler append(final Error anError) {
        throw DomainException.with(List.of(anError));
    }

    @Override
    public ValidationHandler append(ValidationHandler anHandler) {
        throw DomainException.with(anHandler.getErrors());
    }

    @Override
    public ValidationHandler validate(Validation anValidation) {
        try {
            anValidation.validate();
        } catch (final Exception ex) {
            throw DomainException.with(List.of(new Error(ex.getMessage())));
        }

        return this;
    }

    @Override
    public List<Error> getErrors() {
        return List.of();
    }
}
