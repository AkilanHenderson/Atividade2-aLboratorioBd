package project.java.Service;

import project.java.Classes.ItemFrete;
import project.java.Repository.ItemFreteDAO;

public class ItemFreteService extends GenericService<ItemFrete> {

    private final ItemFreteDAO itemFreteDAO;

    public ItemFreteService(){
        super(ItemFrete.class);
        this.itemFreteDAO = new ItemFreteDAO();
    }
}
