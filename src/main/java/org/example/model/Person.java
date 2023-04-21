package org.example.model;

import lombok.Data;

@Data
public class Person {
    private Long id;
    private final String name;
    private final int age;
}
