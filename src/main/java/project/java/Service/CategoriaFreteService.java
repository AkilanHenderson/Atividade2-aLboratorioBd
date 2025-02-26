package project.java.Service;

import jakarta.persistence.NoResultException;
import project.java.Classes.CategoriaFrete;
import project.java.Repository.CategoriaFreteDAO;

public class CategoriaFreteService extends GenericService<CategoriaFrete>{

    private final CategoriaFreteDAO categoriaFreteDAO;

    public CategoriaFreteService(){
        super(CategoriaFrete.class);
        this.categoriaFreteDAO = new CategoriaFreteDAO();
    }

    // Método para buscar uma categoria de frete pelo nome
    public CategoriaFrete buscarPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da categoria não pode ser nulo ou vazio.");
        }

        String jpql = "SELECT c FROM CategoriaFrete c WHERE c.nome = :nome";

        try {
            return categoriaFreteDAO.getEntityManager()
                    .createQuery(jpql, CategoriaFrete.class)
                    .setParameter("nome", nome)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Retorna null se não encontrar a categoria
        }
    }
}

