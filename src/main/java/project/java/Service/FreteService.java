package project.java.Service;

import project.java.Classes.Frete;
import project.java.Repository.FreteDAO;

import java.math.BigDecimal;
import java.util.List;

public class FreteService extends GenericService<Frete>{

    private final FreteDAO freteDAO;

    public FreteService(){
        super(Frete.class);
        this.freteDAO = new FreteDAO();
    }

    // Método para calcular o valor do frete
    public BigDecimal calcularValorFrete(Integer freteId) {
        return freteDAO.calcularValorFrete(freteId);
    }

    public List<Frete> buscarFretesPorCliente(Integer clienteId) {
        return freteDAO.buscarFretesPorCliente(clienteId);
    }
}
