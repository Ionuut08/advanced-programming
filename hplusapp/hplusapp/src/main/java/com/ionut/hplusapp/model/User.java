package com.ionut.hplusapp.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class User {

    @Id
    private int id;

    @NotNull
    @Size(min = 6, message = "{username.not.enough.chars}")
    private String username;

        // The password must contain at least one capital letter
    @NotNull
    @Pattern(regexp="((?=.*[A-Z]).{8,20})", message = "Password must have one uppercase, one lowercase and should be more than 6 characters")
    private String password;

    @NotNull(message = "First name cannot be empty")
    private String firstName;

    @NotNull(message = "Last name cannot be empty")
    private String lastName;
    private String dateOfBirth;

    @NotEmpty(message = "Activity cannot be left empty")
    private String activity;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
