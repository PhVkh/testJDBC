package com.phvkh.ee.database;

import com.phvkh.ee.dto.PersonDTO;
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

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressEntity address;
    public AddressEntity getAddress() {
        return address;
    }
    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public PersonEntity(PersonDTO person) {
        this.name = person.getName();
        this.lastName = person.getLastName();
        this.patronymic = person.getPatronymic();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("d.MM.yyyy"));
        LocalDate dateOfBirth = LocalDate.parse(person.getDateOfBirth(), formatter);
        this.date = dateOfBirth;
    }

    public PersonEntity() {
    }
}
