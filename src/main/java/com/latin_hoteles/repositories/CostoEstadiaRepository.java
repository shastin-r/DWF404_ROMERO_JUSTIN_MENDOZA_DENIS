package com.latin_hoteles.repositories;

import com.latin_hoteles.entities.CostoEstadia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CostoEstadiaRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("latin_hoteles_PU");

    public void crearCostoEstadia(CostoEstadia costoEstadia) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(costoEstadia);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public CostoEstadia obtenerCostoEstadiaPorId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(CostoEstadia.class, id);
        } finally {
            em.close();
        }
    }

    public List<CostoEstadia> obtenerTodosLosCostosEstadia() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("FROM costos_estadia", CostoEstadia.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void actualizarCostoEstadia(CostoEstadia costoEstadia) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(costoEstadia);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminarCostoEstadia(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            CostoEstadia costoEstadia = em.find(CostoEstadia.class, id);
            if (costoEstadia != null) {
                em.remove(costoEstadia);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
