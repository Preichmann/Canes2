/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nik_r
 */
public class DAO_Funcionario {

    public boolean CadastrarFuncionario(Funcionario f) {

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

    public ArrayList<Funcionario> getFuncionario() {
        Conexao conec = new Conexao();
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT ID_FUNCIONARIO, NOME FROM SUPLEMENTOS.FUNCIONARIO WHERE STATUS = 1;");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Funcionario func = new Funcionario();
                    func.setIdFuncionario(rs.getInt("ID_FUNCIONARIO"));
                    func.setNome(rs.getString("NOME"));
                    listaFuncionarios.add(func);
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return listaFuncionarios;
    }

    public Funcionario getFuncionarioId(int id) {
        Conexao conec = new Conexao();
        Funcionario func = new Funcionario();
        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT FUNC.ID_FUNCIONARIO, FUNC.NOME AS NOME_FUNCIONARIO, FUNC.EMAIL, FUNC.USUARIO, FUNC.SENHA, FUNC.STATUS, FUNC.TIPO "
                    + "FROM SUPLEMENTOS.FUNCIONARIO FUNC \n"
                    + "WHERE FUNC.ID_FUNCIONARIO = " + id + ";");

            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    func.setIdFuncionario(rs.getInt("ID_FUNCIONARIO"));
                    func.setNome(rs.getString("NOME_FUNCIONARIO"));
                    func.setEmail(rs.getString("EMAIL"));
                    func.setUsuario(rs.getString("USUARIO"));
                    func.setSenha(rs.getString("SENHA"));
                    func.setStatus(rs.getBoolean("STATUS"));
                    func.setTipo(rs.getString("TIPO"));
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return func;
    }

    public boolean AlterarFuncionario(Funcionario func) {
        boolean retorno = false;

        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE SUPLEMENTOS.FUNCIONARIO\n"
                    + "SET NOME = ?, EMAIL = ?, USUARIO = ?, SENHA = ?, STATUS = ?, TIPO = ?\n"
                    + "WHERE ID_FUNCIONARIO = ?");

            comandoSQL.setString(1, func.getNome());
            comandoSQL.setString(2, func.getEmail());
            comandoSQL.setString(3, func.getUsuario());
            comandoSQL.setString(4, func.getSenha());
            comandoSQL.setBoolean(5, func.isStatus());
            comandoSQL.setString(6, func.getTipo());
            comandoSQL.setInt(7, func.getIdFuncionario());

            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public boolean excluirFuncionario(int idIFuncionario) {
        boolean retorno = false;
        Conexao conec = new Conexao();

        try (Connection conexao = conec.obterConexao()) {

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE SUPLEMENTOS.FUNCIONARIO SET STATUS = 0 WHERE ID_FUNCIONARIO = ?");

            comandoSQL.setInt(1, idIFuncionario);
            
            int linhaAfetada = comandoSQL.executeUpdate();

            retorno = linhaAfetada > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }
    
    public Funcionario getFuncionarioLogin(String login){
        
        Conexao conec = new Conexao();
        
        try(Connection conexao = conec.obterConexao()){
            
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM "
                    + "SUPLEMENTOS.FUNCIONARIO WHERE USUARIO = ?");
            
            comandoSQL.setString(1, login);
            
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs != null){                
                while(rs.next()){                    
                    Funcionario funcionario = new Funcionario();
                    funcionario.setIdFuncionario(rs.getInt("ID_FUNCIONARIO"));
                    funcionario.setNome(rs.getString("NOME"));
                    funcionario.setEmail(rs.getString("EMAIL"));
                    funcionario.setUsuario(rs.getString("USUARIO"));
                    funcionario.setSenha(rs.getString("SENHA"));
                    funcionario.setStatus(rs.getBoolean("STATUS"));
                    funcionario.setTipo(rs.getString("TIPO"));
                    return funcionario;
                }
            } 
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();                    
        }
        return null;        
    }    
}
        
        
    
    

