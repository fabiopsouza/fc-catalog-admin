package com.github.fullcycle.catalog.admin.domain.category;

import com.github.fullcycle.catalog.admin.domain.category.Category;
import com.github.fullcycle.catalog.admin.domain.exceptions.DomainException;
import com.github.fullcycle.catalog.admin.domain.validation.handler.ThrowsValidationHandler;
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

    @Test
    public void givenAnInvalidNullName_whenCallNewCategory_thanShouldReceiveError() {
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' should not be null";
        final String expectedName = null;
        final var expectedDescription = "A categoria mais assistida";
        final var expectIsActive = true;

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectIsActive);

        final var actualException = Assertions.assertThrows(DomainException.class,
                () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    public void givenAnInvalidEmptyName_whenCallNewCategory_thanShouldReceiveError() {
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' should not be empty";
        final var expectedName = "  ";
        final var expectedDescription = "A categoria mais assistida";
        final var expectIsActive = true;

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectIsActive);

        final var actualException = Assertions.assertThrows(DomainException.class,
                () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    public void givenAnInvalidNameLengthLessThan3_whenCallNewCategory_thanShouldReceiveError() {
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' must be between 3 and 255 characters";
        final var expectedName = "Fi ";
        final var expectedDescription = "A categoria mais assistida";
        final var expectIsActive = true;

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectIsActive);

        final var actualException = Assertions.assertThrows(DomainException.class,
                () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    public void givenAnInvalidNameLengthMoreThan3_whenCallNewCategory_thanShouldReceiveError() {
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' must be between 3 and 255 characters";
        final var expectedName = """
                A prática cotidiana prova que o desenvolvimento contínuo de distintas formas de atuação aponta para a 
                melhoria de todos os recursos funcionais envolvidos. Por outro lado, a constante divulgação das
                informações auxilia a preparação e a composição do investimento em reciclagem técnica.
                """;

        final var expectedDescription = "A categoria mais assistida";
        final var expectIsActive = true;

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectIsActive);

        final var actualException = Assertions.assertThrows(DomainException.class,
                () -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    public void givenAValidEmptyDescription_whenCallNewCategory_thanShouldReceiveOK() {
        final var expectedName = "Filmes";
        final var expectedDescription = "";
        final var expectIsActive = true;

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectIsActive);

        Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertNotNull(actualCategory);
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectIsActive, actualCategory.isActive());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdatedAt());
        Assertions.assertNull(actualCategory.getDeletedAt());
    }

    @Test
    public void givenAValidFalseIsActive_whenCallNewCategory_thanShouldReceiveOK() {final var expectedErrorCount = 1;
        final var expectedName = "Filmes";
        final var expectedDescription = "O filme mais assistido";
        final var expectIsActive = false;

        final var actualCategory = Category.newCategory(expectedName, expectedDescription, expectIsActive);

        Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidationHandler()));

        Assertions.assertNotNull(actualCategory);
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectIsActive, actualCategory.isActive());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdatedAt());
        Assertions.assertNotNull(actualCategory.getDeletedAt());
    }
}
