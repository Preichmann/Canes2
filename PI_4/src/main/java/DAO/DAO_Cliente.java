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

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.CLIENTE(NOME_CLIENTE,CPF,EMAIL,SENHA) \n"
                    + "VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

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

}
