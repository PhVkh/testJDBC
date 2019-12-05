package com.phvkh.ee.service;

import com.phvkh.ee.database.AddressEntity;
import com.phvkh.ee.database.AddressRepository;
import com.phvkh.ee.database.PersonEntity;
import com.phvkh.ee.dto.AddressDTO;
import com.phvkh.ee.dto.PersonDTO;
import org.hibernate.Session;

import java.util.*;


public class AddressPersonService {
    private static AddressPersonService instance;

    public static AddressPersonService getInstance() {
            if (instance == null) {
                instance = new AddressPersonService();
            }
            return instance;
        }

    public void addAddressAndPerson(AddressDTO addr, PersonDTO pers) {
        PersonEntity person = new PersonEntity(pers);
        AddressEntity address = new AddressEntity(addr);
        Session session = AddressRepository.getInstance().getSessionFactory().openSession();
        session.beginTransaction();
        AddressEntity addressEntity = AddressRepository.getInstance().getAddress(address, session);
        if (addressEntity == null) {
            AddressRepository.getInstance().addAddress(address, session);
            addressEntity = address;
        }
        AddressRepository.getInstance().addPersonToAddress(addressEntity, person, session);
        session.getTransaction().commit();
        session.close();
    }

    public Map<AddressDTO, Set<PersonDTO>> getAllAddressesWithPeople() {
        List<AddressEntity> resultSet = AddressRepository.getInstance().getAllAddressesWithPeople();
        Map<AddressDTO, Set<PersonDTO>> resultMap = new HashMap<>();
        for (AddressEntity address: resultSet) {
            Set<PersonDTO> occupants = new HashSet<>();
            for (PersonEntity person: address.getOccupants()) {
                occupants.add(new PersonDTO(person));
            }
            resultMap.put(new AddressDTO(address), occupants);
        }
        return resultMap;
    }
}
