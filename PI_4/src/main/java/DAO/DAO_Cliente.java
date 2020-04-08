package DAO;

import Classes.Cliente;
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
                    + "SUPLEMENTOS.CLIENTE WHERE EMAIL = ?");

            comandoSQL.setString(1, login);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId_cliente(rs.getInt("ID_CLIENTE"));
                    cliente.setNome(rs.getString("NOME_CLIENTE"));
                    cliente.setCPF(rs.getString("CPF"));
                    cliente.setEmail(rs.getString("EMAIL"));
                    cliente.setSenha(rs.getString("SENHA"));
                    cliente.setId_end_entrega(rs.getInt("ID_ENDERECO_ENTREGA"));
                    cliente.setId_end_fatura(rs.getInt("ID_ENDERECO_FATURA"));
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
                    + "SUPLEMENTOS.CLIENTE WHERE EMAIL = ?");

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

    public boolean cadastrarEnderecoEntrega(int idCliente, String clienteCEP, String clienteRua, String clienteNum, String clienteBairro, String clienteCidade, String clienteEstado) {

        Conexao conec = new Conexao();
        boolean retorno;
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.FUNCIONARIO(NOME, EMAIL,USUARIO,SENHA,STATUS,TIPO)\n"
                    + "VALUES (?,?,?,?,?,?)");

            comandoSQL.setString(1, f.getNome());
            comandoSQL.setString(2, f.getEmail());
            comandoSQL.setString(3, f.getUsuario());
            comandoSQL.setString(4, f.getSenha());
            comandoSQL.setBoolean(5, f.isStatus());
            comandoSQL.setString(6, f.getTipo());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }
}
