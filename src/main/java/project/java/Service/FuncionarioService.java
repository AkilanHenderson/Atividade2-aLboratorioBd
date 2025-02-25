package project.java.Service;

import project.java.Classes.Funcionario;
import project.java.Repository.FuncionarioDAO;

public class FuncionarioService extends GenericService<Funcionario> {

    private final FuncionarioDAO funcionarioDAO;

    public FuncionarioService(){
        super(Funcionario.class);
        this.funcionarioDAO = new FuncionarioDAO();
    }
}
