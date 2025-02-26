package project.java.Test;

import project.java.Classes.Filial;
import project.java.Classes.Veiculo;
import project.java.Service.FilialService;

import project.java.Service.VeiculoService;

public class VeiculoMain {

    public static void main(String[] args) {

        VeiculoService veiculoService = new VeiculoService();
        FilialService filialService = new FilialService();

        //antes de roda veiculo, rode filial primeiro
        try {
            Filial filial = filialService.buscarPorId(1);
            if (filial == null) {
                throw new RuntimeException("Dependente não encontrado!");
            }

            //Criando um veiculo sem estar associado a uma filial e a um frete
            Veiculo veiculo1 = Veiculo.builder()
                    .id(null)
                    .numeroPlaca("ABC-1234")
                    .filial(filial)
                    .tipoVeiculo(null)
                    .listfrete(null)
                    .build();

            veiculoService.salvar(veiculo1);

            System.out.println("Veículo salvo com sucesso: " + veiculo1);
            System.out.println("veiculo  salvo no id: " + veiculo1.getId());

            Veiculo veiculo2 = Veiculo.builder()
                    .id(null)
                    .numeroPlaca("DFG-1234")
                    .filial(filial)
                    .tipoVeiculo(null)
                    .listfrete(null)
                    .build();

            veiculoService.salvar(veiculo2);

            System.out.println("Veículo salvo com sucesso: " + veiculo2);
            System.out.println("veiculo  salvo no id: " + veiculo2.getId());

            // Adiciona os veículos à lista de veículos da filial
            filial.getVeiculos().add(veiculo1);
            filial.getVeiculos().add(veiculo2);

            filialService.atualizar(filial);

            System.out.println("Filial atualizado com sucesso: " + filial);

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
