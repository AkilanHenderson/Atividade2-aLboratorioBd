package project.java.Service;

import project.java.Classes.Cidade;
import project.java.Repository.CidadeDAO;


public class CidadeService extends GenericService<Cidade> {

    private final CidadeDAO cidadeDAO;

    public CidadeService(){
        super(Cidade.class);
        this.cidadeDAO = new CidadeDAO();
    }
}
