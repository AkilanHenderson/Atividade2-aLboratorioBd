package project.java.Repository;

import jakarta.persistence.NoResultException;
import project.java.Classes.Cidade;
import project.java.Classes.Distancia;
import project.java.Classes.Frete;

import java.math.BigDecimal;
import java.util.List;

public class FreteDAO extends GenericDAO<Frete> {

    public FreteDAO(){
        super(Frete.class);
    }

    // Método para calcular o valor do frete
    public BigDecimal calcularValorFrete(Integer freteId) {
        // Busca o frete pelo ID
        Frete frete = buscarPorId(freteId);
        if (frete == null) {
            throw new IllegalArgumentException("Frete não encontrado com o ID: " + freteId);
        }

        // Obtém as cidades de origem e destino do frete
        Cidade origem = frete.getCidadeOrigem();
        Cidade destino = frete.getCidadeDestino();

        // Busca a distância entre as cidades de origem e destino
        BigDecimal distancia = buscarDistanciaEntreCidades(origem.getId(), destino.getId());
        if (distancia == null) {
            throw new IllegalArgumentException("Distância não encontrada entre as cidades.");
        }

        // Calcula o valor base do frete (distância * valor por km rodado)
        BigDecimal valorBase = frete.getValorKmRodado().multiply(distancia);

        // Aplica o percentual adicional da categoria de frete
        BigDecimal percentualAdicional = BigDecimal.valueOf(frete.getCategoriaFrete().getPercentualAdicional() / 100);
        BigDecimal valorAdicional = valorBase.multiply(percentualAdicional);

        // Retorna o valor total do frete (valor base + valor adicional)
        return valorBase.add(valorAdicional);
    }

    // Método para buscar a distância entre duas cidades
    public BigDecimal buscarDistanciaEntreCidades(Integer origemId, Integer destinoId) {
        if (origemId == null || destinoId == null) {
            throw new IllegalArgumentException("IDs de origem e destino não podem ser nulos.");
        }

        String jpql = "SELECT d FROM Distancia d WHERE d.origem.id = :origemId AND d.destino.id = :destinoId";

        try {
            Distancia distancia = getEntityManager()
                    .createQuery(jpql, Distancia.class)
                    .setParameter("origemId", origemId)
                    .setParameter("destinoId", destinoId)
                    .getSingleResult();

            // Retorna a distância em BigDecimal
            return distancia.getQuilometros();
        } catch (NoResultException e) {
            return null;
        }
    }

    //Método para buscar fretes por cliente
    public List<Frete> buscarFretesPorCliente(Integer clienteId) {
        String jpql = "SELECT f FROM Frete f WHERE f.cliente.id = :clienteId";
        return getEntityManager()
                .createQuery(jpql, Frete.class)
                .setParameter("clienteId", clienteId)
                .getResultList();
    }
}

