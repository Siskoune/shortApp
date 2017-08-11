package com.zsoft.restfulAppMango.domaine;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.annotation.Generated;
import java.util.Collection;

/**
 * Created by Syphax on 07/08/2017.
 */
@Document(collection = "Les_eleves")
public class Student {

    @Id
    String id;

    @Indexed
    @Field("la9ab")
    String nom;

    @Indexed
    @Field("issm")
    String prenom;
    @DBRef(lazy = true)
    Collection<Teacher> teachers;

    public Student() {
    }

    public Collection<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Collection<Teacher> teachers) {
        this.teachers = teachers;
    }

    @PersistenceConstructor
    public Student(@Value("#root.la9ab?: 'elLa9ab'")String nom, @Value("#root.issm?: 'mohoMoho'") String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        //this.teachers = teachers;
    }

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

    @Override
    public String toString() {
    /*    return String.format(
                "Student[id=%s, nom='%s', prenom='%s']:teacher: '%s'",
                id, nom, prenom, teachers.iterator().next().toString());*/
        return String.format(
                "\n\t\tStudent[id=%s, nom='%s', prenom='%s'] '%s'",
                id, nom, prenom,teachers.iterator().next().toString());

    }
}
