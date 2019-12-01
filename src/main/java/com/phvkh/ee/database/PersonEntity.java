package com.phvkh.ee.database;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "people")
public class PersonEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    private String name;
    public String getName() {
        return name;
    }

    @Column(name = "last_name")
    private String lastName;
    public String getLastName() {
        return lastName;
    }

    @Column(name = "patronymic")
    private String patronymic;
    public String getPatronymic() {
        return patronymic;
    }

    @Column(name = "date_of_birth")
    private LocalDate date;
    public LocalDate getDate() {
        return date;
    }

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
}
