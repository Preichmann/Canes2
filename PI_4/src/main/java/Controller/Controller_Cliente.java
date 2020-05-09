package Controller;

import Classes.Cliente;
import Classes.Endereco_Entrega;
import Classes.Endereco_Fatura;
import java.util.ArrayList;

public class Controller_Cliente {

    public int cadastrarCliente(Cliente C) {
        return new DAO.DAO_Cliente().CadastrarCliente(C);
    }

    public boolean AlterarCliente(Cliente c) {
        return new DAO.DAO_Cliente().alterarCliente(c);
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

    public ArrayList<Endereco_Entrega> ListarEntrega(int id_cliente) {
        return new DAO.DAO_Cliente().ListarEntrega(id_cliente);
    }
    

    public ArrayList<Endereco_Fatura> ListarFatura(int id_cliente) {
        return new DAO.DAO_Cliente().ListarFatura(id_cliente);
    }

    public Endereco_Entrega getEntrega(int idEntrega) {
        return new DAO.DAO_Cliente().getEntrega(idEntrega);
    }

    public Endereco_Fatura getFatura(int idFatura) {
        return new DAO.DAO_Cliente().getFaturamento(idFatura);
    }

    public boolean alterarEnderecoEntregaNoComplemento(int idEntrega, String clienteCEP, String clienteRua, String clienteNum, String clienteBairro, String clienteCidade, String clienteEstado) {
        Endereco_Entrega endereco = new Endereco_Entrega(clienteRua, clienteCEP, clienteNum, clienteBairro, clienteCidade, clienteEstado, idEntrega);
        return new DAO.DAO_Cliente().alterarEnderecoEntregaNoComplemento(endereco);
    }

    public boolean alterarEnderecoEntrega(int idEntrega, String clienteCEP, String clienteRua, String clienteNum, String clienteComplemento, String clienteBairro, String clienteCidade, String clienteEstado) {
        Endereco_Entrega endereco = new Endereco_Entrega(clienteRua, clienteCEP, clienteNum, clienteComplemento, clienteBairro, clienteCidade, clienteEstado, idEntrega);
        return new DAO.DAO_Cliente().alterarEnderecoEntrega(endereco);
    }

    public boolean alterarEnderecoFaturaNoComplemento(int idFatura, String clienteCEP, String clienteRua, String clienteNum, String clienteBairro, String clienteCidade, String clienteEstado) {
        Endereco_Fatura endereco = new Endereco_Fatura(clienteRua, clienteCEP, clienteNum, clienteBairro, clienteCidade, clienteEstado, idFatura);
        return new DAO.DAO_Cliente().alterarEnderecoFaturaNoComplemento(endereco);
    }

    public boolean alterarEnderecoFatura(int idFatura, String clienteCEP, String clienteRua, String clienteNum, String clienteComplemento, String clienteBairro, String clienteCidade, String clienteEstado) {
        Endereco_Fatura endereco = new Endereco_Fatura(clienteRua, clienteCEP, clienteNum, clienteComplemento, clienteBairro, clienteCidade, clienteEstado, idFatura);
        return new DAO.DAO_Cliente().alterarEnderecoFatura(endereco);
    }
}
