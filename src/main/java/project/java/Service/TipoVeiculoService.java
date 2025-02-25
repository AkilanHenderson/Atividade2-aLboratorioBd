package project.java.Service;

import project.java.Classes.TipoVeiculo;
import project.java.Repository.TipoVeiculoDAO;

public class TipoVeiculoService extends GenericService<TipoVeiculo> {

    private final TipoVeiculoDAO tipoVeiculoDAO;

    public TipoVeiculoService(){
        super(TipoVeiculo.class);
        this.tipoVeiculoDAO = new TipoVeiculoDAO();
    }
}
