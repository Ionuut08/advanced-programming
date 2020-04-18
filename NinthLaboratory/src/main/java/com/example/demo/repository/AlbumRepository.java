package com.example.demo.repository;

import com.example.demo.entities.Album;
import com.example.demo.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumRepository {

    public void createAlbum(Album album) {
        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        assert persistenceUtil != null;
        EntityManager entityManager = persistenceUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();

        album.setId(2);
        album.setName("Hamburgerrrrrrr");

        entityManager.persist(album);
        entityManager.getTransaction().commit();

        entityManager.close();
        persistenceUtil.getEntityManagerFactory().close();
    }

    public List<Album> findByName(String name) {
        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        assert persistenceUtil != null;
        EntityManager entityManager = persistenceUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();

        TypedQuery query = entityManager.createNamedQuery("Album.findByName", Album.class).setParameter("name", name);
        List<Album> results = query.getResultList();
        return results;
    }

    public List<Album> findByArtist(int artistId) {
        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
        assert persistenceUtil != null;
        EntityManager entityManager = persistenceUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();

        TypedQuery query = entityManager.createNamedQuery("Album.findByArtist", Album.class);
        query.setParameter("artist_id", artistId);
        List<Album> results = query.getResultList();
        return results;
    }

    public void delete(int id) {
//        PersistenceUtil persistenceUtil = PersistenceUtil.getInstance();
//        assert persistenceUtil != null;
//        EntityManager entityManager = persistenceUtil.getEntityManagerFactory().createEntityManager();
//
//        entityManager.getTransaction().begin();
//
//        Album album = entityManager.find(Album.class, 35);
//        entityManager.remove(album);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        persistenceUtil.getEntityManagerFactory().close();
    }

}

