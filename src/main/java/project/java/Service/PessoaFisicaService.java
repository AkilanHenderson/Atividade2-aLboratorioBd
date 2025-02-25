package project.java.Service;

import project.java.Classes.PessoaFisica;
import project.java.Repository.PessoaFisicaDAO;

import java.util.List;

public class PessoaFisicaService extends GenericService<PessoaFisica>{

    private final PessoaFisicaDAO pessoaFisicaDAO;

    public PessoaFisicaService(){
        super(PessoaFisica.class);
     this.pessoaFisicaDAO = new PessoaFisicaDAO();
    }

    // Métodos específicos para PessoaFisica (se necessário)
    public List<PessoaFisica> buscarPorNome(String nome) {
        return pessoaFisicaDAO.buscarPorNome(nome);
    }

    public PessoaFisica buscarPorCpf(String cpf) {
        return pessoaFisicaDAO.buscarPorCpf(cpf);
    }


}
