package com.ionut.project.jdbc;

import com.ionut.project.jdbc.util.DataTransferObject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PostLoad;

@Entity
public class Artist implements DataTransferObject {

    @Id
    private int id;
    private String name;
    private String country;

    @Override
    public int getId() {
        return id;
    }

    public void setId(long id) {
        this.id = (int) id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
