package com.github.fullcycle.catalog.admin.domain.category;

import com.github.fullcycle.catalog.admin.domain.Identifier;
import com.github.fullcycle.catalog.admin.domain.utils.IdUtils;

import java.security.PublicKey;
import java.util.Objects;
import java.util.UUID;

public class CategoryID extends Identifier {
    private final String value;

    private CategoryID(final String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public static CategoryID unique() {
        return CategoryID.from(IdUtils.uuid());
    }

    public static CategoryID from(final String anID) {
        return new CategoryID(anID);
    }

    public static CategoryID from(final UUID anID) {
        return new CategoryID(anID.toString().toLowerCase());
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryID that = (CategoryID) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
