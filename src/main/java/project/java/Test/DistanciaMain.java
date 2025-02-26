package project.java.Test;

import project.java.Classes.Cidade;
import project.java.Classes.Distancia;
import project.java.Service.CidadeService;
import project.java.Service.DistanciaService;

import java.math.BigDecimal;

public class DistanciaMain {
    public static void main(String[] args) {

        DistanciaService distanciaService = new DistanciaService();
        CidadeService cidadeService = new CidadeService();

        //Criando a distancia para associar a cidade, rode primeiro cidade antes de rodar distancia

        try {

            Cidade cidade1 = cidadeService.buscarPorId(1);
            Cidade cidade2 = cidadeService.buscarPorId(2);

            if (cidade1 == null && cidade2 == null) {
                throw new RuntimeException("Dependentes não encontrados!");
            }

            Distancia distancia = Distancia.builder()
                    .id(null)
                    .quilometros(new BigDecimal("300.50"))
                    .origem(cidade1)
                    .destino(cidade2)
                    .build();

            distanciaService.salvar(distancia);

            System.out.println("Distância salva com sucesso: " + distancia);
            System.out.println("Distancia salvo no id: " + distancia.getId());

            cidade1.getDistanciasDestino().add(distancia);
            cidadeService.atualizar(cidade1);

            cidade2.getDistanciasOrigem().add(distancia);
            cidadeService.atualizar(cidade2);

            System.out.println("Cidade1 atualizada com sucesso: " + cidade1);

            System.out.println("Cidade2 atualizada com sucesso: " + cidade2);

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
