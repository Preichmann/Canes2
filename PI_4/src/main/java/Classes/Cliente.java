
package Classes;

public class Cliente {
    
    private int id_cliente;
    private String usuario;
    private String senha;    
    private String nome;    
    private String email;
    private int id_end_entrega;
    private int id_end_fatura;
    
    public Cliente(){
        
    }
    
    public Cliente(int id_cliente, String usuario, String senha, String nome, String email, int id_end_entrega, int id_end_fatura) {
        this.id_cliente = id_cliente;
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.id_end_entrega = id_end_entrega;
        this.id_end_fatura = id_end_fatura;
    }
    
    public Cliente(String usuario, String senha, String nome, String email, int id_end_entrega, int id_end_fatura) {
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.id_end_entrega = id_end_entrega;
        this.id_end_fatura = id_end_fatura;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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

    public int getId_end_entrega() {
        return id_end_entrega;
    }

    public void setId_end_entrega(int id_end_entrega) {
        this.id_end_entrega = id_end_entrega;
    }

    public int getId_end_fatura() {
        return id_end_fatura;
    }

    public void setId_end_fatura(int id_end_fatura) {
        this.id_end_fatura = id_end_fatura;
    }
}
