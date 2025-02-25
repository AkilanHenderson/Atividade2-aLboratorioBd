package project.java.Service;

import project.java.Classes.Dependente;
import project.java.Repository.DependenteDAO;

public class DependenteService extends GenericService<Dependente> {

    private final DependenteDAO dependenteDAO;

    public DependenteService(){
        super(Dependente.class);
        this.dependenteDAO = new DependenteDAO();
    }
}
