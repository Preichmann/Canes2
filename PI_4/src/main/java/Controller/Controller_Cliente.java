package Controller;

import Classes.Cliente;

public class Controller_Cliente {

    public int cadastrarCliente(Cliente C) {
        return new DAO.DAO_Cliente().CadastrarCliente(C);
    }

    public Cliente getClienteLogin(String login) {

        Cliente cliente = new DAO.DAO_Cliente().getClienteLogin(login);
        return cliente;
    }

}
