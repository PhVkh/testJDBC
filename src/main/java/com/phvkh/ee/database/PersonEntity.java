package com.phvkh.ee.database;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "people")
public class PersonEntity {
    private String name;
    private String lastName;
    private String patronymic;
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    @Column(name = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    @Column(name = "date_of_birth")
    public LocalDate getDate() {
        return date;
    }
}
