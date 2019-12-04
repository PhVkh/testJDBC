package com.phvkh.ee.service;

import com.phvkh.ee.database.AddressEntity;
import com.phvkh.ee.database.AddressRepository;
import com.phvkh.ee.database.PeopleRepository;
import com.phvkh.ee.database.PersonEntity;
import com.phvkh.ee.dto.AddressDTO;
import com.phvkh.ee.dto.PersonDTO;

import java.util.*;

public class AddressPersonService {
    public static void addAddressAndPerson(AddressDTO addr, PersonDTO pers) {
        PersonEntity person = new PersonEntity(pers);
        AddressEntity address = new AddressEntity(addr);
        AddressRepository.getInstance().addAddress(address, person);
    }

    public static Map<AddressDTO, Set<PersonDTO>> getAllAddressesWithPeople() {
        List<AddressEntity> resultSet = AddressRepository.getInstance().getAllAddressesWithPeople();
        Map<AddressDTO, Set<PersonDTO>> resultMap = new HashMap<>();
        for (AddressEntity a: resultSet) {
            Set<PersonDTO> occupants = new HashSet<>();
            for (PersonEntity p: a.getOccupants()) {
                occupants.add(new PersonDTO(p));
            }
            resultMap.put(new AddressDTO(a), occupants);
        }
        return resultMap;
    }
}
