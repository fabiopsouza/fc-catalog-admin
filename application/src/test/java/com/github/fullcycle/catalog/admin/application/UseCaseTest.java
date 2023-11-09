package com.github.fullcycle.catalog.admin.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UseCaseTest {
    @Test
    public void testExecute() {
        Assertions.assertNotNull(new UseCase().execute());
    }
}
