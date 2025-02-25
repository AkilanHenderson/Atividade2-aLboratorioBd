package project.java.Service;

import project.java.Classes.Filial;
import project.java.Repository.FilialDAO;

public class FilialService extends GenericService<Filial>{

    private final FilialDAO filialDAO;

    public FilialService(){
        super(Filial.class);
        this.filialDAO = new FilialDAO();
    }
}
