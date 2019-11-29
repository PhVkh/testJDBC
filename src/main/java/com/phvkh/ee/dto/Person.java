package com.phvkh.ee.dto;

public class Person {
    private String name;
    private String lastName;
    private String patronymic;
    private String dateOfBirth;

    public Person(String name, String lastName, String patronymic, String dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}