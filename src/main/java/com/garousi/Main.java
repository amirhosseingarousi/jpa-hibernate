package com.garousi;

import com.garousi.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate-mysql")) {

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Person p = new Person();
            p.setFirstName("Amir");
            p.setLastName("Garousi");
            p.setEmail("a.garousi@tosan.com");
            p.setDob(LocalDate.of(2000, 4, 16));
            p.setTemp(0);

            em.persist(p);
            em.getTransaction().commit();

            em.close();

        }
    }
}