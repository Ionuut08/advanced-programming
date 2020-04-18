package com.example.demo.repository;

import com.example.demo.entities.Album;
import com.example.demo.entities.Artist;
import com.example.demo.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistRepository {

    public void createArtist(Artist artist) {
        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        assert persistenceUtil != null;
        EntityManager entityManager = persistenceUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();

        artist.setId(3);
        artist.setName("Hamburger");
        artist.setCountry("Romania");

        entityManager.persist(artist);
        entityManager.getTransaction().commit();

        entityManager.close();
        persistenceUtil.getEntityManagerFactory().close();
    }

    public List<Artist> findByName(String name) {
        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        assert persistenceUtil != null;
        EntityManager entityManager = persistenceUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();

        TypedQuery query = entityManager.createNamedQuery("Artist.findByName", Artist.class);
        List<Artist> results = query.getResultList();
        return results;
    }

}
