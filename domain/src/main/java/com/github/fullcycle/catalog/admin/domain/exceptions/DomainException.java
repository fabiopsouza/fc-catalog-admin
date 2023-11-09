package com.github.fullcycle.catalog.admin.domain.exceptions;

import java.util.List;
import com.github.fullcycle.catalog.admin.domain.validation.Error;

public class DomainException extends NoStacktraceException {

    private final List<Error> errors;

    private DomainException(final String aMessage, final List<Error> anErrors) {
        super(aMessage);
        this.errors = anErrors;
    }

    public static DomainException with(final Error aError) {
        return new DomainException(aError.message(), List.of(aError));
    }

    public static DomainException with(final List<Error> anErrors) {
        return new DomainException("", anErrors);
    }

    public List<Error> getErrors() {
        return errors;
    }
}
