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

    public boolean validarEmail(String clienteEmail) {
        int idCliente = new DAO.DAO_Cliente().validarEmail(clienteEmail);
        if (idCliente == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarCPF(String clienteCPF) {
        int cpfcliente = new DAO.DAO_Cliente().validarCPF(clienteCPF);
        if (cpfcliente == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cadastrarEndereco(int idCliente, String clienteCEP, String clienteRua, String clienteNum, String clienteBairro, String clienteCidade, String clienteEstado) {
        return new DAO.DAO_Cliente().cadastrarEnderecoEntrega(idCliente,clienteCEP, clienteRua, clienteNum, clienteBairro, clienteCidade, clienteEstado);
    }
}
