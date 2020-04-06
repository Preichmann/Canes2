
package DAO;

import Classes.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO_Cliente {
    
        public Cliente getClienteLogin(String login){
        
        Conexao conec = new Conexao();
        
        try(Connection conexao = conec.obterConexao()){
            
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM "
                    + "SUPLEMENTOS.CLIENTE WHERE EMAIL = ?");
            
            comandoSQL.setString(1, login);
            
            ResultSet rs = comandoSQL.executeQuery();
            
            if(rs != null){                
                while(rs.next()){                    
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
