package com.phvkh.ee.database;

import com.phvkh.ee.dto.AddressDTO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "addresses")
public class AddressEntity {
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

    @Column(name = "street")
    private String street;
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "house")
    private String house;
    public String getHouse() {
        return house;
    }
    public void setHouse(String house) {
        this.house = house;
    }

    @Column(name = "flat")
    private String flat;
    public String getFlat() {
        return flat;
    }
    public void setFlat(String flat) {
        this.flat = flat;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "address")//, cascade = CascadeType.MERGE)
    private Set<PersonEntity> occupants = new HashSet<PersonEntity>();
    public Set<PersonEntity> getOccupants() {
        return occupants;
    }
    public void setOccupants(Set<PersonEntity> occupants) {
        this.occupants = occupants;
    }

    public AddressEntity() {
    }

    public AddressEntity(AddressDTO address) {
        this.street = address.getStreet();
        this.house = address.getHouse();
        this.flat = address.getFlat();
    }
}
