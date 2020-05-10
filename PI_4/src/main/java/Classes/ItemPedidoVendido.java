package Classes;

/**
 *
 * @author Gabriel Ribeiro Vital
 */
public class ItemPedidoVendido {
    private int idItemPedido;
    private int idProduto;
    private int quantidade;
    private double valorUnitario;
    private double valorTotal;
    private String nomeProduto;
    private int idCliente;
    private int idPedido;

    public ItemPedidoVendido() {
    }

    public ItemPedidoVendido(int idItemPedido, int idProduto, int quantidade, double valorUnitario, double valorTotal, String nomeProduto, int idCliente, int idPedido) {
        this.idItemPedido = idItemPedido;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.nomeProduto = nomeProduto;
        this.idCliente = idCliente;
        this.idPedido = idPedido;
    }

    public int getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(int idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    
}
