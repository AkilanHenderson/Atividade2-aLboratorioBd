package project.java.Test;

import project.java.Classes.Dependente;
import project.java.Service.DependenteService;

import java.time.LocalDate;

public class DependenteMain {

    public static void main(String[] args) {

        DependenteService dependenteService = new DependenteService();

        //criando primeiro um dependente sem estar associado a um funcionario
        Dependente dependente = Dependente.builder()
                .id(null)
                .nome("Maria da Silva")
                .dataNascimento(LocalDate.of(2010, 5, 15))
                .funcionario(null)
                .build();

        dependenteService.salvar(dependente);

        System.out.println("Dependente salvo com sucesso: " + dependente);
        System.out.println("Dependente salvo no id: " + dependente.getId());

    }
}
