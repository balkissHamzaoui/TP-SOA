package com.tp.crud.models;

import javax.persistence.*;


@Entity
@Table
public class Person {

    //Attributes
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private String email;

    //Constructors
    public Person(long id, String name, String prenom String email) {
        this.id = id;
        this.name = name;
        this.prenom=prenom
        this.email=email;
    }

    public Person() {
    }

    public Person(Person person) {
        this.id= person.getId();
        this.name=person.getName();
        this.email= person.getEmail();
    }

    //getters and setters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrenom() {
        return prenom;
    }


    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
