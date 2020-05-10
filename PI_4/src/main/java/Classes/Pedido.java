package Classes;

/**
 *
 * @author Gabriel Ribeiro Vital
 */
public class Pedido {

    private int idPedido;
    private int idCliente;
    private int idEntrega;
    private String metodoPagamento;
    private String status;

    public Pedido() {
    }

    public Pedido(int idCliente, int idEntrega, String metodoPagamento, String status) {
        this.idCliente = idCliente;
        this.idEntrega = idEntrega;
        this.metodoPagamento = metodoPagamento;
        this.status = status;
    }

    public Pedido(int idPedido, int idCliente, int idEntrega, String metodoPagamento, String status) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.idEntrega = idEntrega;
        this.metodoPagamento = metodoPagamento;
        this.status = status;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
