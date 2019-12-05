package com.phvkh.ee.database;

public class PeopleRepository extends Repository {
    private static PeopleRepository instance;

    public static PeopleRepository getInstance() {
        if (instance == null) {
            instance = new PeopleRepository();
        }
        return instance;
    }
}

