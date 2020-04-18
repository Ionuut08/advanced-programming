package com.example.demo.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

    private static PersistenceUtil singleInstance = null;
    EntityManagerFactory entityManagerFactory;

    private PersistenceUtil() {
        entityManagerFactory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static PersistenceUtil getInstance() {
        if (singleInstance == null) {
            singleInstance = new PersistenceUtil();
        }
        return singleInstance;
    }
}
