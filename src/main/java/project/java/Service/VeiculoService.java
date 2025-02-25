package project.java.Service;

import project.java.Classes.Veiculo;
import project.java.Repository.VeiculoDAO;

public class VeiculoService extends GenericService<Veiculo>{

    private final VeiculoDAO veiculoDAO;

    public VeiculoService(){
        super(Veiculo.class);
        this.veiculoDAO = new VeiculoDAO();
    }
}
