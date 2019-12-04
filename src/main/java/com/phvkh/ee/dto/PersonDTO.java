package com.phvkh.ee.dto;

import com.phvkh.ee.database.PersonEntity;

public class PersonDTO {
    private String name;
    private String lastName;
    private String patronymic;
    private String dateOfBirth;

    public PersonDTO(String name, String lastName, String patronymic, String dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
    }

    public PersonDTO(PersonEntity personEntity) {
        this.name = personEntity.getName();
        this.lastName = personEntity.getLastName();
        this.patronymic = personEntity.getPatronymic();
        this.dateOfBirth = personEntity.getDate().toString();
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
