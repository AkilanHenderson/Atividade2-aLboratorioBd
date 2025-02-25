package project.java.Service;

import project.java.Classes.Distancia;
import project.java.Repository.DistanciaDAO;

public class DistanciaService extends GenericService<Distancia>{

    private final DistanciaDAO distanciaDAO;

    public DistanciaService(){
        super(Distancia.class);
        this.distanciaDAO = new DistanciaDAO();
    }
}
