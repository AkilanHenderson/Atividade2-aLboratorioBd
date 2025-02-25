package project.java.Test;

import project.java.Classes.Filial;
import project.java.Classes.Funcionario;
import project.java.Service.FilialService;
import project.java.Service.FuncionarioService;

public class FilialMain {

    public static void main(String[] args) {

        //antes de rodar a classe filial main, rode primeiro a classe funcionario
        FilialService filialService = new FilialService();
        FuncionarioService funcionarioService = new FuncionarioService();

        try{

        Funcionario funcionario = funcionarioService.buscarPorId(1);

            if (funcionario == null) {
                throw new RuntimeException("Dependente não encontrado!");
            }

        //Criando uma filial, sem estar associada a um veiculo
        Filial filial = Filial.builder()
                .id(null)
                .nome("Filial São Paulo")
                .endereco("Av. Paulista, 1000")
                .telefone("11987654321")
                .listfuncionarios(funcionario)
                .listveiculos(null)
                .build();

        filialService.salvar(filial);

        System.out.println("Filial salva com sucesso: " + filial); //ainda falta atualizar a tabela funcionario

        //associando o funcionario a filial após ter sido criado a filial
        funcionario.setFilial(filial); // Associa o Funcionario a filial
        funcionarioService.atualizar(funcionario); // Atualiza o funcionario no banco de dados

        System.out.println("Funcionario atualizado com sucesso: " +funcionario);

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
