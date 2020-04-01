/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author nik_r
 */
public class Controller_Funcionario {

    public boolean cadastrarFuncionario(Funcionario f) {
        return new DAO.DAO_Funcionario().CadastrarFuncionario(f);
    }

    public ArrayList<Funcionario> getFuncionario() {
        return new DAO.DAO_Funcionario().getFuncionario();
    }

    public Funcionario getFuncionarioId(int id) {
        return new DAO.DAO_Funcionario().getFuncionarioId(id);
    }
    
    public Boolean alterarFuncionario(Funcionario f){
        return new DAO.DAO_Funcionario().AlterarFuncionario(f);
    }
}
