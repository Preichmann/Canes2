package Classes;

public class Endereco_Fatura {

    private int id_faturamento;
    private int id_cliente;
    private String rua;
    private String cep;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco_Fatura() {
    }

    public Endereco_Fatura(int id_cliente, String rua, String cep, String numero, String complemento, String bairro, String cidade, String estado) {
        this.id_cliente = id_cliente;
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco_Fatura(String rua, String cep, String numero, String complemento, String bairro, String cidade, String estado, int id_Fatura) {
        this.id_faturamento = id_Fatura;
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco_Fatura(int id_cliente, String rua, String cep, String numero, String bairro, String cidade, String estado) {
        this.id_cliente = id_cliente;
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco_Fatura(String rua, String cep, String numero, String bairro, String cidade, String estado, int id_Fatura) {
        this.id_faturamento = id_Fatura;
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_faturamento() {
        return id_faturamento;
    }

    public void setId_faturamento(int id_faturamento) {
        this.id_faturamento = id_faturamento;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
