public class Venda {
    public Veiculo veiculo;
    public Cliente cliente;
    public String dataVenda;
    public double valorVenda;
    public String formaPagamento;

    public Venda(Veiculo veiculo, Cliente cliente,  String dataVenda, Double valorVenda, String formaPagamento) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataVenda = dataVenda;
        this.valorVenda = valorVenda;
        this.formaPagamento = formaPagamento;
    }
    @Override
    public String toString() {
        return String.format("Venda: %s | Comprador: %s | Valor de venda: %.2f | Forma de pagamento: %s | Data: %s",
                veiculo.getModelo(), cliente.getId(), valorVenda, formaPagamento, dataVenda
        );
    }
}
