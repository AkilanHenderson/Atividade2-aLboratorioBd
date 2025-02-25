package project.java.Test;

import project.java.Classes.Cidade;
import project.java.Service.CidadeService;


public class CidadeMain {
    public static void main(String[] args) {

        CidadeService cidadeService = new CidadeService();

        //criando a cidade origem e destino sem estar associada a um frete, e a uma distancia
        Cidade cidadeOrigem = Cidade.builder()
                .id(null)
                .uf("SP")
                .nome("São Paulo")
                .estado("São Paulo")
                .listfreteorigem(null)
                .listdistanciaorigem(null)
                .build();

        Cidade cidadeDestino = Cidade.builder()
                .id(null)
                .uf("RJ")
                .nome("Rio de Janeiro")
                .estado("Rio de Janeiro")
                .listfretedestino(null)
                .listdistanciadestino(null)
                .build();

        cidadeService.salvar(cidadeOrigem);
        cidadeService.salvar(cidadeDestino);

        System.out.println("CidadeOrigem salva com sucesso: " + cidadeOrigem);
        System.out.println("CidadeOrigem salvo no id: " + cidadeOrigem.getId());

        System.out.println("CidadeDestino salva com sucesso: " + cidadeDestino);
        System.out.println("CidadeDestino salvo no id: " + cidadeDestino.getId());

    }
}
