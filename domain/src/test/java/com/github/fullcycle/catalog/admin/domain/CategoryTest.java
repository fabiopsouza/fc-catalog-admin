package com.github.fullcycle.catalog.admin.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {
    @Test
    public void newCategoryTest() {
        Assertions.assertNotNull(new Category());
    }
}
