package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "albums")
@NamedQueries({
        @NamedQuery(name = "Album.findByName", query = "SELECT a FROM Album a WHERE a.name LIKE :name"),
        @NamedQuery(name = "Album.findByArtist", query = "SELECT a FROM Album a WHERE a.artistId = :artist_id")
})
public class Album implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Id
    @Column(name = "artist_id")
    private int artistId;

    @Id
    @Column(name = "release_year")
    private int releaseYear;

    @Id
    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", artistId=" + artistId +
                ", releaseYear=" + releaseYear +
                ", name='" + name + '\'' +
                '}';
    }
}
