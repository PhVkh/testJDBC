package com.phvkh.ee.database;
import com.fasterxml.classmate.AnnotationConfiguration;
import com.phvkh.ee.dto.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeopleRepository {
    private static PeopleRepository instance;
    private SessionFactory sessionFactory;
    private String url = "jdbc:postgresql://localhost:5432/test";
    private String user = "postgres";
    private String password = "asdqwe123";

    private PeopleRepository() {
        sessionFactory = new  Configuration().configure().buildSessionFactory();
    }

    public static PeopleRepository getInstance() {
        if (instance == null) {
            instance = new PeopleRepository();
        }
        return instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void addPerson(Person person) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        PersonEntity personEntity = new PersonEntity(person.getName(), person.getLastName(), person.getPatronymic(), person.getDateOfBirth());
        session.save(personEntity);
        session.getTransaction().commit();
        session.close();
    }

    public List<Person> showAll() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        List people = session.createQuery("FROM PersonEntity").list();
        session.close();
        return people;
    }
}

