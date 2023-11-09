package com.github.fullcycle.catalog.admin.domain.exceptions;

public class NoStacktraceException extends RuntimeException {
    public NoStacktraceException(String message) {
        super(message, null);
    }

    public NoStacktraceException(final String message, final Throwable cause) {
        super(message, cause, true, false);
    }
}
