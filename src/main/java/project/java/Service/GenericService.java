package project.java.Service;

import jakarta.persistence.EntityManager;
import project.java.Repository.GenericDAO;

import java.util.List;

public class GenericService <T>{

    private final GenericDAO<T> dao;

    public GenericService(Class<T> entityClass) {
        this.dao = new GenericDAO<>(entityClass);
    }

    public void salvar(T entidade) {
        dao.salvar(entidade);
    }

    public void atualizar(T entidade) {
        dao.atualizar(entidade);
    }

    public T buscarPorId(Integer id) {
        return dao.buscarPorId(id);
    }

    public List<T> buscarTodos() {
        return dao.buscarTodos();
    }

    public void remover(Integer id) {
        dao.remover(id);
    }

    protected EntityManager getEntityManager() {
        return dao.getEntityManager();
    }
}
