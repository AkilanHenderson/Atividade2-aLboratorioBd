package project.java.Test;

import project.java.Classes.ItemFrete;
import project.java.Service.ItemFreteService;

public class ItemFreteMain {
    public static void main(String[] args) {

        ItemFreteService itemFreteService = new ItemFreteService();

        //Criando um item frete sem estar associado a um frete

        ItemFrete itemFrete = ItemFrete.builder()
                .id(null)
                .descricao("item caro")
                .peso(100.00f)
                .frete(null)
                .build();

        itemFreteService.salvar(itemFrete);

        System.out.println("itemFrete salva com sucesso: " + itemFrete);
        System.out.println("ItemFrete salvo no id: " + itemFrete.getId());

    }
}

