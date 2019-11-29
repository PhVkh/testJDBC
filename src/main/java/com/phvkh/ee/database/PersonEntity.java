package com.phvkh.ee.database;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "people")
public class PersonEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "date_of_birth")
    private LocalDate date;

    public PersonEntity(String name, String lastName, String patronymic, String date) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("d.MM.yyyy"));
        LocalDate dateOfBirth = LocalDate.parse(date, formatter);
        this.date = dateOfBirth;
    }

    public PersonEntity() {
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

    public LocalDate getDate() {
        return date;
    }
}
