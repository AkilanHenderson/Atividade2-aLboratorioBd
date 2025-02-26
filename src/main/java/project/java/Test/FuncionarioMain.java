package project.java.Test;

import project.java.Classes.Dependente;
import project.java.Classes.Funcionario;
import project.java.Service.DependenteService;
import project.java.Service.FuncionarioService;

public class FuncionarioMain {

    public static void main(String[] args) {

        //antes de rodar o funcionario, rode primeiro o dependente
        FuncionarioService funcionarioService = new FuncionarioService();
        DependenteService dependenteService = new DependenteService();

        try {
            Dependente dependente = dependenteService.buscarPorId(1);

            if (dependente == null) {
                throw new RuntimeException("Dependente não encontrado!");
            }

            //criando um funcionario sem estar associado a uma filial, mas tendo um dependente na sua lista
            Funcionario funcionario = Funcionario.builder()
                    .id(null)
                    .nome("João da Silva")
                    .email("joao.silva@example.com")
                    .telefone("11987654321")
                    .cpf("12345678901")
                    .matricula(12345)
                    .filial(null)
                    .listdependente(dependente)
                    .build();

            funcionarioService.salvar(funcionario);

            System.out.println("Funcionário salvo com sucesso: " + funcionario);
            System.out.println("Funcionário salvo no id: " + funcionario.getId());

            // Adiciona o funcionario ao depedente
            dependente.setFuncionario(funcionario);
            // Atualiza a Filial no banco de dados
            dependenteService.atualizar(dependente);

            System.out.println("Dependente atualizado com sucesso ");

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
