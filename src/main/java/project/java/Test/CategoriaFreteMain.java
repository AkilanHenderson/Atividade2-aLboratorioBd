package project.java.Test;

import project.java.Classes.CategoriaFrete;
import project.java.Service.CategoriaFreteService;

public class CategoriaFreteMain {
    public static void main(String[] args) {

        //criando uma categoriafrete sem estar associado a um frete
        CategoriaFreteService categoriaFreteService = new CategoriaFreteService();

        // Cria as categorias de frete (normal, rápida, super-rápida)
        CategoriaFrete normal = CategoriaFrete.builder()
                .id(null)
                .nome("Normal")
                .descricao("Entrega padrão, sem acréscimo")
                .percentualAdicional(0.0f) // 0% de acréscimo
                .listfrete(null) // Não associada a fretes no momento
                .build();

        CategoriaFrete rapida = CategoriaFrete.builder()
                .id(null)
                .nome("Rápida")
                .descricao("Entrega rápida, com acréscimo de 10%")
                .percentualAdicional(10.0f) // 10% de acréscimo
                .listfrete(null) // Não associada a fretes no momento
                .build();

        CategoriaFrete superRapida = CategoriaFrete.builder()
                .id(null)
                .nome("Super-Rápida")
                .descricao("Entrega super-rápida, com acréscimo de 30%")
                .percentualAdicional(30.0f) // 30% de acréscimo
                .listfrete(null) // Não associada a fretes no momento
                .build();

        // Salva as categorias no banco de dados (se não existirem)
        salvarCategoriaSeNaoExistir(categoriaFreteService, normal);

        salvarCategoriaSeNaoExistir(categoriaFreteService, rapida);

        salvarCategoriaSeNaoExistir(categoriaFreteService, superRapida);

     }

    // Método para salvar uma categoria de frete apenas se ela não existir no banco de dados
    private static void salvarCategoriaSeNaoExistir(CategoriaFreteService categoriaFreteService, CategoriaFrete categoriaFrete) {
        // Verifica se já existe uma categoria com o mesmo nome
        CategoriaFrete existente = categoriaFreteService.buscarPorNome(categoriaFrete.getNome());

        if (existente == null) {
            // Se não existir, salva a nova categoria
            categoriaFreteService.salvar(categoriaFrete);
            System.out.println("CategoriaFrete salva com sucesso: " + categoriaFrete);
            System.out.println("CategoriaFrete salva no id: " + categoriaFrete.getId());
        } else {
            // Se existir, exibe uma mensagem informando que a categoria já existe
            System.out.println("CategoriaFrete já existe: " + existente);
        }
    }
}
