package com.phvkh.ee.database;

import org.hibernate.Session;

public class PeopleRepository extends Repository {
    private static PeopleRepository instance;

    public static PeopleRepository getInstance() {
        if (instance == null) {
            instance = new PeopleRepository();
        }
        return instance;
    }
//    public void addPerson(PersonEntity person, AddressEntity address) {
//        Session session = getSessionFactory().openSession();
//        AddressEntity addressEntity = AddressRepository.getInstance().getAddress(address);
//        session.beginTransaction();
//        person.setAddress(addressEntity);
//        session.save(person);
//        session.getTransaction().commit();
//        session.close();
//    }
}

