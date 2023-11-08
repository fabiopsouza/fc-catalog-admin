package com.github.fullcycle.catalog.admin.application;

import com.github.fullcycle.catalog.admin.domain.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UseCaseTest {
    @Test
    public void testExecute() {
        Assertions.assertNotNull(new UseCase().execute());
    }
}
