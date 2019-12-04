package com.phvkh.ee.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Repository {
    private SessionFactory sessionFactory;

    public Repository() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
