package project.java.Service;

import project.java.Classes.CategoriaFrete;
import project.java.Repository.CategoriaFreteDAO;

public class CategoriaFreteService extends GenericService<CategoriaFrete>{

    private final CategoriaFreteDAO categoriaFreteDAO;

    public CategoriaFreteService(){
        super(CategoriaFrete.class);
        this.categoriaFreteDAO = new CategoriaFreteDAO();
    }
}

