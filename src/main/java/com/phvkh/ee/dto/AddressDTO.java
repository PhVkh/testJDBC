package com.phvkh.ee.dto;

import com.phvkh.ee.database.AddressEntity;

public class AddressDTO {
    private String street;
    private String house;
    private String flat;

    public AddressDTO(String street, String house, String flat) {
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public AddressDTO(AddressEntity addressEntity) {
        this.street = addressEntity.getStreet();
        this.house = addressEntity.getHouse();
        this.flat = addressEntity.getFlat();
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getFlat() {
        return flat;
    }
}
