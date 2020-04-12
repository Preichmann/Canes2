package Classes;

import org.mindrot.jbcrypt.BCrypt;

public class Cliente {

    private int id_cliente;
    private String senha;
    private String nome;
    private String email;
    private String cpf;

    public Cliente() {

    }

    public Cliente(String senha, String nome, String email, String cpf) {
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public Cliente(int id_cliente, String senha, String nome) {
        this.id_cliente = id_cliente;
        this.senha = senha;
        this.nome = nome;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public boolean validarSenha(String usuarioSenha) {
        return BCrypt.checkpw(usuarioSenha, senha);
    }

    public final void setSenhaHash(String senha) {
        this.senha = BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public boolean getSenhaHash(String senhaUsuario) {
        return BCrypt.checkpw(senhaUsuario, senha);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

}
