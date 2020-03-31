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
import java.sql.Statement;

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
}
