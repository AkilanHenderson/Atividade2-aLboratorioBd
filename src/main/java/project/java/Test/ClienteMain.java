package project.java.Test;

import project.java.Classes.Cliente;
import project.java.Service.ClienteService;


public class ClienteMain {
    public static void main(String[] args) {

        ClienteService clienteService = new ClienteService();

        //criando um cliente sem estar associado a um frete
        Cliente cliente = Cliente.builder()
                .id(null)
                .nome("Gloria da Silva")
                .email("Gloria.silva@example.com")
                .telefone("1234567612")
                .cpf("98765435147")
                .contato("9876543210")
                .ativo(true)
                .listfrete(null)
                .build();

        clienteService.salvar(cliente);

        System.out.println("Cliente salvo com sucesso: " + cliente);

        System.out.println("Cliente salvo com sucesso. ID: " + cliente.getId());


    }
}
