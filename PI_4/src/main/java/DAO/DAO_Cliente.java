package DAO;

import Classes.Cliente;
import Classes.Endereco_Entrega;
import Classes.Endereco_Fatura;
import Classes.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public boolean alterarCliente(Cliente c) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE SUPLEMENTOS.CLIENTE\n"
                    + "SET NOME_CLIENTE = ?, SENHA = ? \n"
                    + "WHERE ID_CLIENTE = ?;");

            comandoSQL.setString(1, c.getNome());
            comandoSQL.setString(2, c.getSenha());
            comandoSQL.setInt(3, c.getId_cliente());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public Cliente getClienteLogin(String login) {

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM "
                    + "SUPLEMENTOS.CLIENTE WHERE CLIENTE.EMAIL LIKE '" + login + "';");

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

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.ENDERECO_ENTREGA (ID_CLIENTE, RUA, CEP, NUMERO, BAIRRO, CIDADE, ESTADO)\n"
                    + "VALUES (?,?,?,?,?,?,?)");

            comandoSQL.setInt(1, endereco.getId_cliente());
            comandoSQL.setString(2, endereco.getRua());
            comandoSQL.setString(3, endereco.getCep());
            comandoSQL.setString(4, endereco.getNumero());
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

    public boolean cadastrarEnderecoEntrega(Endereco_Entrega endereco) {

        Conexao conec = new Conexao();
        boolean retorno;
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.ENDERECO_ENTREGA (ID_CLIENTE, RUA, CEP, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, ESTADO) \n"
                    + "VALUES (?,?,?,?,?,?,?,?)");

            comandoSQL.setInt(1, endereco.getId_cliente());
            comandoSQL.setString(2, endereco.getRua());
            comandoSQL.setString(3, endereco.getCep());
            comandoSQL.setString(4, endereco.getNumero());
            comandoSQL.setString(5, endereco.getComplemento());
            comandoSQL.setString(6, endereco.getBairro());
            comandoSQL.setString(7, endereco.getCidade());
            comandoSQL.setString(8, endereco.getEstado());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public boolean cadastrarEnderecoFaturamento(Endereco_Fatura endereco) {

        Conexao conec = new Conexao();
        boolean retorno;
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.ENDERECO_FATURAMENTO(ID_CLIENTE,RUA,CEP,NUMERO,COMPLEMENTO,BAIRRO,CIDADE,ESTADO)\n"
                    + " VALUES (?,?,?,?,?,?,?,?);");

            comandoSQL.setInt(1, endereco.getId_cliente());
            comandoSQL.setString(2, endereco.getRua());
            comandoSQL.setString(3, endereco.getCep());
            comandoSQL.setString(4, endereco.getNumero());
            comandoSQL.setString(5, endereco.getComplemento());
            comandoSQL.setString(6, endereco.getBairro());
            comandoSQL.setString(7, endereco.getCidade());
            comandoSQL.setString(8, endereco.getEstado());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            retorno = false;
        }
        return retorno;
    }

    public boolean cadastrarEnderecoFaturamentoNoComplemento(Endereco_Fatura endereco) {

        Conexao conec = new Conexao();
        boolean retorno;
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO SUPLEMENTOS.ENDERECO_FATURAMENTO(ID_CLIENTE,RUA,CEP,NUMERO,BAIRRO,CIDADE,ESTADO)\n"
                    + "VALUES (?,?,?,?,?,?,?);");

            comandoSQL.setInt(1, endereco.getId_cliente());
            comandoSQL.setString(2, endereco.getRua());
            comandoSQL.setString(3, endereco.getCep());
            comandoSQL.setString(4, endereco.getNumero());
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

    public ArrayList<Endereco_Entrega> ListarEntrega(int id_cliente) {
        ArrayList<Endereco_Entrega> listaEntrega = new ArrayList<>();
        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM "
                    + "SUPLEMENTOS.ENDERECO_ENTREGA WHERE ID_CLIENTE = ?");

            comandoSQL.setInt(1, id_cliente);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Endereco_Entrega entrega = new Endereco_Entrega();
                    entrega.setCep(rs.getString("CEP"));
                    entrega.setRua(rs.getString("RUA"));
                    entrega.setNumero(rs.getString("NUMERO"));
                    entrega.setComplemento(rs.getString("COMPLEMENTO"));
                    entrega.setBairro(rs.getString("BAIRRO"));
                    entrega.setCidade(rs.getString("CIDADE"));
                    entrega.setEstado(rs.getString("ESTADO"));
                    entrega.setId_entrega(rs.getInt("ID_ENDERECO_ENT"));
                    listaEntrega.add(entrega);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return listaEntrega;
    }

    public ArrayList<Endereco_Fatura> ListarFatura(int id_cliente) {
        ArrayList<Endereco_Fatura> listaFatura = new ArrayList<>();
        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM "
                    + "SUPLEMENTOS.ENDERECO_FATURAMENTO WHERE ID_CLIENTE = ?");

            comandoSQL.setInt(1, id_cliente);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Endereco_Fatura entrega = new Endereco_Fatura();
                    entrega.setCep(rs.getString("CEP"));
                    entrega.setRua(rs.getString("RUA"));
                    entrega.setNumero(rs.getString("NUMERO"));
                    entrega.setComplemento(rs.getString("COMPLEMENTO"));
                    entrega.setBairro(rs.getString("BAIRRO"));
                    entrega.setCidade(rs.getString("CIDADE"));
                    entrega.setEstado(rs.getString("ESTADO"));
                    entrega.setId_faturamento(rs.getInt("ID_ENDERECO_FAT"));
                    listaFatura.add(entrega);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return listaFatura;
    }

    public Endereco_Entrega getEntrega(int idEntrega) {
        Conexao conec = new Conexao();
        Endereco_Entrega entrega = new Endereco_Entrega();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM "
                    + "SUPLEMENTOS.ENDERECO_ENTREGA WHERE ID_ENDERECO_ENT = ?");

            comandoSQL.setInt(1, idEntrega);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    entrega.setCep(rs.getString("CEP"));
                    entrega.setRua(rs.getString("RUA"));
                    entrega.setNumero(rs.getString("NUMERO"));
                    entrega.setComplemento(rs.getString("COMPLEMENTO"));
                    entrega.setBairro(rs.getString("BAIRRO"));
                    entrega.setCidade(rs.getString("CIDADE"));
                    entrega.setEstado(rs.getString("ESTADO"));
                    entrega.setId_entrega(rs.getInt("ID_ENDERECO_ENT"));
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return entrega;
    }

    public Endereco_Fatura getFaturamento(int idFatura) {
        Conexao conec = new Conexao();
        Endereco_Fatura fatura = new Endereco_Fatura();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM "
                    + "SUPLEMENTOS.ENDERECO_FATURAMENTO WHERE ID_ENDERECO_FAT = ?");

            comandoSQL.setInt(1, idFatura);

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    fatura.setCep(rs.getString("CEP"));
                    fatura.setRua(rs.getString("RUA"));
                    fatura.setNumero(rs.getString("NUMERO"));
                    fatura.setComplemento(rs.getString("COMPLEMENTO"));
                    fatura.setBairro(rs.getString("BAIRRO"));
                    fatura.setCidade(rs.getString("CIDADE"));
                    fatura.setEstado(rs.getString("ESTADO"));
                    fatura.setId_faturamento(rs.getInt("ID_ENDERECO_FAT"));
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return fatura;
    }

    public boolean alterarEnderecoEntregaNoComplemento(Endereco_Entrega entrega) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE SUPLEMENTOS.ENDERECO_ENTREGA \n"
                    + "SET CEP = ?, RUA = ?, NUMERO = ?, COMPLEMENTO = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ? \n"
                    + "WHERE ID_ENDERECO_ENT = ?;");

            comandoSQL.setString(1, entrega.getCep());
            comandoSQL.setString(2, entrega.getRua());
            comandoSQL.setString(3, entrega.getNumero());
            comandoSQL.setString(4, "");
            comandoSQL.setString(5, entrega.getBairro());
            comandoSQL.setString(6, entrega.getCidade());
            comandoSQL.setString(7, entrega.getEstado());
            comandoSQL.setInt(8, entrega.getId_entrega());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public boolean alterarEnderecoFaturaNoComplemento(Endereco_Fatura fatura) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE SUPLEMENTOS.ENDERECO_FATURAMENTO \n"
                    + "SET CEP = ?, RUA = ?, NUMERO = ?, COMPLEMENTO = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ? \n"
                    + "WHERE ID_ENDERECO_FAT = ?;");

            comandoSQL.setString(1, fatura.getCep());
            comandoSQL.setString(2, fatura.getRua());
            comandoSQL.setString(3, fatura.getNumero());
            comandoSQL.setString(4, "");
            comandoSQL.setString(5, fatura.getBairro());
            comandoSQL.setString(6, fatura.getCidade());
            comandoSQL.setString(7, fatura.getEstado());
            comandoSQL.setInt(8, fatura.getId_faturamento());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public boolean alterarEnderecoEntrega(Endereco_Entrega entrega) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE SUPLEMENTOS.ENDERECO_ENTREGA \n"
                    + "SET CEP = ?, RUA = ?, NUMERO = ?, COMPLEMENTO = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ? \n"
                    + "WHERE ID_ENDERECO_ENT = ?;");

            comandoSQL.setString(1, entrega.getCep());
            comandoSQL.setString(2, entrega.getRua());
            comandoSQL.setString(3, entrega.getNumero());
            comandoSQL.setString(4, entrega.getComplemento());
            comandoSQL.setString(5, entrega.getBairro());
            comandoSQL.setString(6, entrega.getCidade());
            comandoSQL.setString(7, entrega.getEstado());
            comandoSQL.setInt(8, entrega.getId_entrega());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public boolean alterarEnderecoFatura(Endereco_Fatura fatura) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE SUPLEMENTOS.ENDERECO_FATURAMENTO \n"
                    + "SET CEP = ?, RUA = ?, NUMERO = ?, COMPLEMENTO = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ? \n"
                    + "WHERE ID_ENDERECO_FAT = ?;");

            comandoSQL.setString(1, fatura.getCep());
            comandoSQL.setString(2, fatura.getRua());
            comandoSQL.setString(3, fatura.getNumero());
            comandoSQL.setString(4, fatura.getComplemento());
            comandoSQL.setString(5, fatura.getBairro());
            comandoSQL.setString(6, fatura.getCidade());
            comandoSQL.setString(7, fatura.getEstado());
            comandoSQL.setInt(8, fatura.getId_faturamento());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

}
