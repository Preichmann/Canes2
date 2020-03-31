/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author nik_r
 */
public class Funcionario {

    private String usuario;
    private String senha;
    private String tipo;
    private String nome;
    private String email;
    private boolean status;

    public Funcionario(String usuario, String senha, String tipo, String nome, String email, boolean status) {
        this.usuario = usuario;
        this.senha = senha;
        this.tipo = tipo;
        this.nome = nome;
        this.email = email;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public final void setSenhaHash(String senha) {
        this.senha = BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public boolean getSenhaHash(String senhaUsuario) {
        return BCrypt.checkpw(senhaUsuario, senha);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
