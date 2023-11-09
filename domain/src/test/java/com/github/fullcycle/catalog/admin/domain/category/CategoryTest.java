package com.github.fullcycle.catalog.admin.domain.category;

import com.github.fullcycle.catalog.admin.domain.category.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {
    @Test
    public void givenAValidParams_whenCallNewCategory_thanInstantiateACategory() {
        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida";
        final var expectIsActive = true;

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectIsActive);

        Assertions.assertNotNull(actualCategory);
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectIsActive, actualCategory.isActive());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdatedAt());
        Assertions.assertNull(actualCategory.getDeletedAt());
    }
}
