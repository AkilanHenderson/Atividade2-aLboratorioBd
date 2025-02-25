package project.java.Service;

import project.java.Classes.Cliente;
import project.java.Repository.ClienteDAO;

 public class ClienteService extends GenericService<Cliente> {

    private final ClienteDAO clienteDAO;

    public ClienteService(){
        super(Cliente.class);
        this.clienteDAO = new ClienteDAO();
    }


}
