/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nik_r
 */
public class Conexao {
    
    public Connection obterConexao() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexao = DriverManager.getConnection("jdbc:mysql://35.199.76.91:3306/SUPLEMENTOS?useTimezone=true&serverTimezone=UTC", "root", "Canes@123");
        return conexao;
    }
}
