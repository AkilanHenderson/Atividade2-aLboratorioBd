package project.java.Test;

import project.java.Classes.TipoVeiculo;
import project.java.Classes.Veiculo;
import project.java.Service.TipoVeiculoService;
import project.java.Service.VeiculoService;

public class TipoVeiculoMain {
    public static void main(String[] args) {

        TipoVeiculoService tipoVeiculoService = new TipoVeiculoService();
        VeiculoService veiculoService = new VeiculoService();

        //antes de rodar tipoveiculo, rode veiculo primeiro
        try{
        Veiculo veiculo1 = veiculoService.buscarPorId(1);
        Veiculo veiculo2 = veiculoService.buscarPorId(2);

            if (veiculo1 == null && veiculo2 == null) {
                throw new RuntimeException("Dependentes não encontrados!");
            }
        TipoVeiculo tipoVeiculo = TipoVeiculo.builder()
                .id(null)
                .descricao("Caminhão")
                .pesoMaximo(5000.0f)
                .listveiculo(veiculo1)
                .listveiculo(veiculo2)
                .build();

         tipoVeiculoService.salvar(tipoVeiculo);

        System.out.println("Tipo de Veículo salvo com sucesso: " + tipoVeiculo);

        // Adiciona os tipoveiculo a veiculo
        veiculo1.setTipoVeiculo(tipoVeiculo);
        veiculo2.setTipoVeiculo(tipoVeiculo);

        veiculoService.atualizar(veiculo1);
        veiculoService.atualizar(veiculo2);

        System.out.println("Veiculo1 atualizado com sucesso: " + veiculo1);
        System.out.println("Veiculo2 atualizado com sucesso: " + veiculo2);

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
