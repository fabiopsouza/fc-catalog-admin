package com.github.fullcycle.catalog.admin.infrastructure;

import com.github.fullcycle.catalog.admin.application.UseCase;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(new UseCase().execute());
    }
}
