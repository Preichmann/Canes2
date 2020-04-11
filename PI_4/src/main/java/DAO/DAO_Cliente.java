package DAO;

import Classes.Cliente;
import Classes.Endereco_Entrega;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_Cliente {

    public int CadastrarCliente(Cliente c) {
        int idCliente = 0;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.CLIENTE (NOME_CLIENTE,CPF,EMAIL,SENHA) \n"
                    + "VALUES (?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            comandoSQL.setString(1, c.getNome());
            comandoSQL.setString(2, c.getCPF());
            comandoSQL.setString(3, c.getEmail());
            comandoSQL.setString(4, c.getSenha());

            comandoSQL.executeUpdate();
            ResultSet getId = comandoSQL.getGeneratedKeys();
            while (getId.next()) {
                idCliente = Integer.parseInt(getId.getString(1));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            idCliente = 0;
        }
        return idCliente;
    }

    public Cliente getClienteLogin(String login) {

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM "
                    + "SUPLEMENTOS.CLIENTE WHERE CLIENTE.EMAIL LIKE '"+login+"';");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId_cliente(rs.getInt("ID_CLIENTE"));
                    cliente.setNome(rs.getString("NOME_CLIENTE"));
                    cliente.setCPF(rs.getString("CPF"));
                    cliente.setEmail(rs.getString("EMAIL"));
                    cliente.setSenha(rs.getString("SENHA"));
                    return cliente;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int validarEmail(String clienteEmail) {
        Conexao conec = new Conexao();
        int idCliente = 0;

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT ID_CLIENTE FROM "
                    + "SUPLEMENTOS.CLIENTE WHERE CLIENTE.EMAIL LIKE '?';");

            comandoSQL.setString(1, clienteEmail);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    idCliente = (rs.getInt("ID_CLIENTE"));
                    return idCliente;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return idCliente;
    }

    public int validarCPF(String clienteCPF) {
        Conexao conec = new Conexao();
        int idCliente = 0;

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT ID_CLIENTE FROM "
                    + "SUPLEMENTOS.CLIENTE WHERE CPF = ?");

            comandoSQL.setString(1, clienteCPF);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    idCliente = (rs.getInt("ID_CLIENTE"));
                    return idCliente;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return idCliente;
    }

    public boolean cadastrarEnderecoEntregaNoComplemento(Endereco_Entrega endereco) {

        Conexao conec = new Conexao();
        boolean retorno;
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.ENDERECO_ENTREGA(ID_CLIENTE,RUA,CEP,NUMERO,BAIRRO,CIDADE,ESTADO)\n"
                    + "VALUES (?,?,?,?,?,?);");

            comandoSQL.setInt(1, endereco.getId_cliente());
            comandoSQL.setString(1, endereco.getRua());
            comandoSQL.setString(2, endereco.getCep());
            comandoSQL.setString(3, endereco.getNumero());
            comandoSQL.setString(4, endereco.getBairro());
            comandoSQL.setString(5, endereco.getCidade());
            comandoSQL.setString(6, endereco.getEstado());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public boolean cadastrarEnderecoEntrega(Endereco_Entrega endereco) {

        Conexao conec = new Conexao();
        boolean retorno;
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.ENDERECO_ENTREGA(ID_CLIENTE,RUA,CEP,NUMERO,COMPLEMENTO,BAIRRO,CIDADE,ESTADO)\n"
                    + " VALUES (?,?,?,?,?,?,?);");

            comandoSQL.setInt(1, endereco.getId_cliente());
            comandoSQL.setString(1, endereco.getRua());
            comandoSQL.setString(2, endereco.getCep());
            comandoSQL.setString(3, endereco.getNumero());
            comandoSQL.setString(4, endereco.getComplemento());
            comandoSQL.setString(5, endereco.getBairro());
            comandoSQL.setString(6, endereco.getCidade());
            comandoSQL.setString(7, endereco.getEstado());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }
}
