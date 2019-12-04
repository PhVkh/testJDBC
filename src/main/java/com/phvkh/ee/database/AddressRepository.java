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

    public AddressEntity getAddress(AddressEntity address) {
        Session session = getSessionFactory().openSession();
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

    public void addAddress(AddressEntity address, PersonEntity person) {
        AddressEntity addressEntity = getInstance().getAddress(address);
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        if (addressEntity == null) {
            session.save(address);
            addressEntity = address;
        }
        person.setAddress(addressEntity);
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }

    public List<AddressEntity> getAllAddressesWithPeople() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        List addresses = session.createQuery("FROM AddressEntity").list();
        session.close();
        return addresses;
    }
}
