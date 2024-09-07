package com.latin_hoteles.repositories;

import com.latin_hoteles.entities.Registro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RegistroRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("latin_hoteles_PU");

    public void crearRegistro(Registro registro) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(registro);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Registro obtenerRegistroPorId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Registro.class, id);
        } finally {
            em.close();
        }
    }

    public List<Registro> obtenerTodosLosRegistros() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("from registro_estadia", Registro.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void actualizarRegistro(Registro registro) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(registro);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminarRegistro(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Registro registro = em.find(Registro.class, id);
            if (registro != null) {
                em.remove(registro);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
