package com.zsoft.restfulAppMango.domaine;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import java.util.Collection;

/**
 * Created by Syphax on 07/08/2017.
 */
@Document
public class Teacher {

    @Id
    String id;

    String nom;
    String prenom;

    @DBRef(lazy = true)
    Collection<Student> students;


    /*
    public Teacher() {
    }

    public Teacher(String nom, String prenom, Collection<Student> students) {
        this.nom = nom;
        this.prenom = prenom;
        this.students = students;
    }*/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }
    @Override
    public String toString() {
        return String.format(
                "Teacher[id=%s, nom='%s', prenom='%s']",
                id, nom, prenom);
    }
}
