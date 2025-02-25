package project.java.Test;

import project.java.Classes.CategoriaFrete;
import project.java.Service.CategoriaFreteService;

public class CategoriaFreteMain {
    public static void main(String[] args) {

        CategoriaFreteService categoriaFreteService = new CategoriaFreteService();

        //criando uma categoriafrete sem estar associado a um frete
        CategoriaFrete categoriaFrete = CategoriaFrete.builder()
                .id(null)
                .nome("Harlindo cruz")
                .descricao("Veiculo caro")
                .percentualAdicional(12.50f)
                .listfrete(null)
                .build();

        categoriaFreteService.salvar(categoriaFrete);

        System.out.println("CategoriaFrete salvo com sucesso: " + categoriaFrete);
        System.out.println("Frete salvo no id: " + categoriaFrete.getId());


        //resta associar o categoriafrete ao frete não existente

    }
}
