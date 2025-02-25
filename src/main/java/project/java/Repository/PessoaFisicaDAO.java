package project.java.Repository;

import project.java.Classes.PessoaFisica;

import java.util.List;

public class PessoaFisicaDAO extends GenericDAO<PessoaFisica> {

    public PessoaFisicaDAO(){
        super(PessoaFisica.class);
    }

    // Métodos específicos para PessoaFisica
    public List<PessoaFisica> buscarPorNome(String nome) {
        String jpql = "SELECT p FROM PessoaFisica p WHERE p.nome LIKE :nome";
        return getEntityManager()
                .createQuery(jpql, PessoaFisica.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }

    public PessoaFisica buscarPorCpf(String cpf) {
        String jpql = "SELECT p FROM PessoaFisica p WHERE p.cpf = :cpf";
        return getEntityManager()
                .createQuery(jpql, PessoaFisica.class)
                .setParameter("cpf", cpf)
                .getSingleResult();
    }

}
