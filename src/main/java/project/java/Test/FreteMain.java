package project.java.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import project.java.Classes.*;
import project.java.Service.*;

import java.math.BigDecimal;
import java.util.List;

public class FreteMain {
    public static void main(String[] args) {

        // Antes de rodar a classe Frete, rode todas as outras classes primeiro
        CategoriaFreteService categoriaFreteService = new CategoriaFreteService();
        CidadeService cidadeService = new CidadeService();
        ClienteService clienteService = new ClienteService();
        VeiculoService veiculoService = new VeiculoService();
        DistanciaService distanciaService = new DistanciaService();
        FreteService freteService = new FreteService();
        ItemFreteService itemFreteService = new ItemFreteService();

        // Inicializa o EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("transportadoraPu");
        EntityManager entityManager = emf.createEntityManager();

        try {
            // Inicia a transação
            entityManager.getTransaction().begin();

            // Busca as entidades necessárias
            CategoriaFrete categoriaFrete = categoriaFreteService.buscarPorId(1);
            Cidade cidadeOrigem = cidadeService.buscarPorId(1);
            Cidade cidadeDestino = cidadeService.buscarPorId(2);
            Cliente cliente = clienteService.buscarPorId(4);
            Veiculo veiculo = veiculoService.buscarPorId(1);
            Distancia distancia = distanciaService.buscarPorId(1);

            // Verifica se todas as entidades foram encontradas
            if (categoriaFrete == null || cidadeOrigem == null || cidadeDestino == null ||
                    cliente == null || veiculo == null || distancia == null) {
                throw new RuntimeException("Dependente não encontrado!");
            }

            // Cria o Frete e associa as entidades
            Frete frete = Frete.builder()
                    .id(null)
                    .numeroNotaFiscal(12345)
                    .valorKmRodado(new BigDecimal("100.50"))
                    .veiculo(veiculo)
                    .cliente(cliente)
                    .categoriaFrete(categoriaFrete)
                    .cidadeOrigem(cidadeOrigem)
                    .cidadeDestino(cidadeDestino)
                    .build();

            // Salva o Frete no banco de dados primeiro
            freteService.salvar(frete);

            // Agora busca o ItemFrete e associa ao Frete
            ItemFrete itemFrete = itemFreteService.buscarPorId(1);
            if (itemFrete == null) {
                throw new RuntimeException("ItemFrete não encontrado!");
            }
            itemFrete.setFrete(frete);
            itemFreteService.atualizar(itemFrete);

            System.out.println("Frete salvo com sucesso: " + frete);
            System.out.println("Frete salvo no id: " + frete.getId());


            // Associa o Frete às outras entidades e atualiza-as
            veiculo.getFrete().add(frete);
            veiculoService.atualizar(veiculo);

            cliente.getFrete().add(frete);
            clienteService.atualizar(cliente);

            categoriaFrete.getFrete().add(frete);
            categoriaFreteService.atualizar(categoriaFrete);

            cidadeOrigem.getFretesOrigem().add(frete);
            cidadeService.atualizar(cidadeOrigem);

            cidadeDestino.getFretesDestino().add(frete);
            cidadeService.atualizar(cidadeDestino);

            // Commit da transação
            entityManager.getTransaction().commit();

            System.out.println("Frete salvo com sucesso: " + frete);

            // Testa o método buscarPorId
            Frete freteEncontrado = freteService.buscarPorId(frete.getId());
            System.out.println("Frete encontrado: " + freteEncontrado);

            // Testa o método buscarFretesPorCliente
            List<Frete> fretesDoCliente = freteService.buscarFretesPorCliente(cliente.getId());
            System.out.println("Fretes encontrados para o cliente: " + fretesDoCliente.size());

        } catch (Exception e) {
            // Rollback se ocorrer erro
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            System.err.println("Erro: " + e.getMessage());
        } finally {
            // Fecha o EntityManager e a EntityManagerFactory
            entityManager.close();
            emf.close();
        }
    }
}

