package project.java.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class GenericDAO<T> {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("transportadoraPu");
    protected EntityManager em;
    private final Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
        this.em = emf.createEntityManager();
    }

    public void salvar(T entidade) {
        em.getTransaction().begin();
        em.persist(entidade);
        em.getTransaction().commit();
    }

    public void atualizar(T entidade) {
        em.getTransaction().begin();
        em.merge(entidade);
        em.getTransaction().commit();
    }

    public T buscarPorId(Integer id) {
        return em.find(entityClass, id);
    }

    public List<T> buscarTodos() {
        return em.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
    }

    public void remover(Integer id) {
        em.getTransaction().begin();
        T entidade = em.find(entityClass, id);
        if (entidade != null) {
            em.remove(entidade);
        }
        em.getTransaction().commit();
    }

    public void fechar() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    public EntityManager getEntityManager() {
        return em;
    }

}
