package com.egg.repositories;

import com.egg.entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class LibroDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();

    public void buscarLibro(Long isbn) {
        Libro libro = em.find(Libro.class, isbn);
    }

    public void modificarLibro(Libro libro) throws Exception {
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
    }

    public void eliminarLibro(Long isbn) throws Exception {
        Libro libro = em.find(Libro.class, isbn);
        em.getTransaction().begin();
        em.remove(libro);
        em.getTransaction().commit();
    }

    public void guardarLibro(Libro libro) throws Exception {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }

    public List<Libro> buscarLibros() {
        return em.createQuery("SELECT l FROM Libro l").getResultList();
    }

}
