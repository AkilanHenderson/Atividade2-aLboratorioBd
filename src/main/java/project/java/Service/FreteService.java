package project.java.Service;

import project.java.Classes.Frete;
import project.java.Repository.FreteDAO;

import java.math.BigDecimal;
import java.util.List;

public class FreteService extends GenericService<Frete> {

    private final FreteDAO freteDAO;

    public FreteService() {
        super(Frete.class);
        this.freteDAO = new FreteDAO();
    }

    // Método para calcular o valor do frete
    public BigDecimal calcularValorFrete(Integer freteId) {
        if (freteId == null) {
            throw new IllegalArgumentException("ID do frete não pode ser nulo.");
        }
        try {
            return freteDAO.calcularValorFrete(freteId);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao calcular o valor do frete: " + e.getMessage(), e);
        }
    }

    // Método para buscar fretes por cliente
    public List<Frete> buscarFretesPorCliente(Integer clienteId) {
        if (clienteId == null) {
            throw new IllegalArgumentException("ID do cliente não pode ser nulo.");
        }
        try {
            return freteDAO.buscarFretesPorCliente(clienteId);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar fretes por cliente: " + e.getMessage(), e);
        }
    }

    // Método para buscar frete por ID
    public Frete buscarFretePorId(Integer freteId) {
        if (freteId == null) {
            throw new IllegalArgumentException("ID do frete não pode ser nulo.");
        }
        try {
            return freteDAO.buscarPorId(freteId);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar frete por ID: " + e.getMessage(), e);
        }
    }
}
