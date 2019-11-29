package com.phvkh.ee.database;
import com.phvkh.ee.dto.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PeopleRepository {
    private static PeopleRepository instance;
    private SessionFactory sessionFactory;
    private String url = "jdbc:postgresql://localhost:5432/test";
    private String user = "postgres";
    private String password = "asdqwe123";

    private PeopleRepository() {
        Configuration config = new Configuration().configure("resources/hibernate.cfg.xml");
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties());
        sessionFactory = config.buildSessionFactory();
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
        try {
            try {
                Class.forName("org.postgresql.Driver");
                Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM people");
                List<Person> people = new ArrayList<>();
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String lastName = resultSet.getString("last_name");
                    String patronymic = resultSet.getString("patronymic");
                    String dateOfBirth = resultSet.getString("date_of_birth");
                    people.add(new Person(name, lastName, patronymic, dateOfBirth));
                }
                connection.close();
                return people;
            } catch (ClassNotFoundException e) {
                System.out.println("PostgreSQL JDBC driver not found.");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return null;
    }
}

