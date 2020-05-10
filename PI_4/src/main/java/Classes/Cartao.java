package Classes;

/**
 *
 * @author Gabriel Vital
 */
public class Cartao {

    private int idCartao;
    private int idPedido;
    private String nomeCartao;
    private String numeroCartao;
    private String cvv;
    private String vencimento;
    private int parcelas;

    public Cartao() {
    }

    public Cartao(String nomeCartao, String numeroCartao, String cvv, String vencimento, int parcelas) {
        this.nomeCartao = nomeCartao;
        this.numeroCartao = numeroCartao;
        this.cvv = cvv;
        this.vencimento = vencimento;
        this.parcelas = parcelas;
    }

    public Cartao(int idCartao, String nomeCartao, String numeroCartao, String cvv, String vencimento, int parcelas) {
        this.idCartao = idCartao;
        this.nomeCartao = nomeCartao;
        this.numeroCartao = numeroCartao;
        this.cvv = cvv;
        this.vencimento = vencimento;
        this.parcelas = parcelas;
    }

    public Cartao(int idCartao, int idPedido, String nomeCartao, String numeroCartao, String cvv, String vencimento, int parcelas) {
        this.idCartao = idCartao;
        this.idPedido = idPedido;
        this.nomeCartao = nomeCartao;
        this.numeroCartao = numeroCartao;
        this.cvv = cvv;
        this.vencimento = vencimento;
        this.parcelas = parcelas;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

}
