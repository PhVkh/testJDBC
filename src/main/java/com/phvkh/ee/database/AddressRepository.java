package com.phvkh.ee.database;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class AddressRepository extends Repository {
    private static AddressRepository instance;

    public static AddressRepository getInstance() {
        if (instance == null) {
            instance = new AddressRepository();
        }
        return instance;
    }

    public AddressEntity getAddress(AddressEntity address, Session session) {
        Criteria criteria = session.createCriteria(AddressEntity.class);
        criteria.add(Restrictions.eq("street", address.getStreet()));
        criteria.add(Restrictions.eq("house", address.getHouse()));
        criteria.add(Restrictions.eq("flat", address.getFlat()));
        List<AddressEntity> result = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        if (result.size() == 1) {
            return result.get(0);
        } else if (result.size() > 1) {
            System.out.println("ОШИБКА. В таблице содержатся два одинаковых адреса!");
        }
        return null;
    }

    public void addAddress(AddressEntity address, Session session) {
        session.save(address);
    }

    public void addPersonToAddress(AddressEntity address, PersonEntity person, Session session) {
        person.setAddress(address);
        session.save(person);
    }

    public List<AddressEntity> getAllAddressesWithPeople() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        List<AddressEntity> addresses = session.createQuery("SELECT DISTINCT a FROM AddressEntity a left join fetch a.occupants").list();
        session.close();
        return addresses;
    }
}
