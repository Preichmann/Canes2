
package Controller;

import Classes.Cliente;

public class Controller_Cliente {
    
    public Cliente getClienteLogin(String login){
        
        Cliente cliente = new DAO.DAO_Cliente().getClienteLogin(login);
        return cliente;        
    } 
    
}
