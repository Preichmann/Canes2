package Controller;

import Classes.Cliente;
import Classes.Endereco_Entrega;
import Classes.Endereco_Fatura;

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

    public boolean cadastrarEnderecoEntregaNoComplemento(int idCliente, String clienteCEP, String clienteRua, String clienteNum, String clienteBairro, String clienteCidade, String clienteEstado) {
        Endereco_Entrega endereco = new Endereco_Entrega(idCliente, clienteRua, clienteCEP, clienteNum, clienteBairro, clienteCidade, clienteEstado);
        return new DAO.DAO_Cliente().cadastrarEnderecoEntregaNoComplemento(endereco);
    }

    public boolean cadastrarEnderecoEntrega(int idCliente, String clienteCEP, String clienteRua, String clienteNum, String clienteComplemento, String clienteBairro, String clienteCidade, String clienteEstado) {
        Endereco_Entrega endereco = new Endereco_Entrega(idCliente, clienteRua, clienteCEP, clienteNum, clienteComplemento, clienteBairro, clienteCidade, clienteEstado);
        return new DAO.DAO_Cliente().cadastrarEnderecoEntrega(endereco);
    }

    public boolean cadastrarEnderecoFaturamentoNoComplemento(int idCliente, String clienteCEP, String clienteRua, String clienteNum, String clienteBairro, String clienteCidade, String clienteEstado) {
        Endereco_Fatura endereco = new Endereco_Fatura(idCliente, clienteRua, clienteCEP, clienteNum, clienteBairro, clienteCidade, clienteEstado);
        return new DAO.DAO_Cliente().cadastrarEnderecoFaturamentoNoComplemento(endereco);
    }

    public boolean cadastrarEnderecoFaturamento(int idCliente, String clienteCEP, String clienteRua, String clienteNum, String clienteComplemento, String clienteBairro, String clienteCidade, String clienteEstado) {
        Endereco_Fatura endereco = new Endereco_Fatura(idCliente, clienteRua, clienteCEP, clienteNum, clienteComplemento, clienteBairro, clienteCidade, clienteEstado);
        return new DAO.DAO_Cliente().cadastrarEnderecoFaturamento(endereco);
    }
}
