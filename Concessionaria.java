import java.util.ArrayList;

public class Concessionaria {
    public ArrayList<Veiculo> veiculos;
    public ArrayList<Cliente> clientes;
    public ArrayList<Venda> vendas;
    public int totalVeiculos;
    public int totalClientes;
    public int totalVendas;

    public Concessionaria(){
        this.veiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.vendas = new ArrayList<>();
        this.totalVeiculos = 0;
        this.totalClientes = 0;
        this.totalVendas = 0;
    }


    public boolean adicionarVeiculo(Veiculo veiculo){
        for (int i = 0; i < this.totalVeiculos; i++){
            if (this.veiculos.get(i).getPlaca().equals(veiculo.getPlaca())){
                return false;
            }
        }
        boolean statusInserido = this.veiculos.add(veiculo);
        if(statusInserido){
            this.totalVeiculos++;
        }
        return statusInserido;
    }

    public boolean removerVeiculo(String placa) {
        for (int i = 0; i < this.totalVeiculos; i++){
            if (this.veiculos.get(i).getPlaca().equals(placa)){
                this.veiculos.remove(i);
                this.totalVeiculos--;
                return true;
            }
        }
        return false;
    }

    public ArrayList<Veiculo> buscarVeiculoPorMarca(String marca){
        ArrayList<Veiculo> veiculosBuscados = new ArrayList<>();
        for (int i = 0; i < this.totalVeiculos; i++){
            if (this.veiculos.get(i).getMarca().toLowerCase().contains(marca.toLowerCase())){
                veiculosBuscados.add(this.veiculos.get(i));
            }
        }
        return veiculosBuscados;
    }

    public ArrayList<Veiculo> buscarVeiculoPorModelo(String modelo){
        ArrayList<Veiculo> veiculosBuscados = new ArrayList<>();
        for (int i = 0; i < this.totalVeiculos; i++){
            if (this.veiculos.get(i).getModelo().toLowerCase().contains(modelo.toLowerCase())){
                veiculosBuscados.add(this.veiculos.get(i));
            }
        }
        return veiculosBuscados;
    }

    public ArrayList<Veiculo> listarVeiculosDisponiveis(){
        ArrayList<Veiculo> disponiveis = new ArrayList<>();
        for (int i = 0; i < this.totalVeiculos; i++){
            if (this.veiculos.get(i).isDisponivel()){
                disponiveis.add(this.veiculos.get(i));
            }
        }
        return disponiveis;
    }


    public boolean cadastrarCliente(Cliente cliente){
        for (int i = 0; i < this.totalClientes; i++){
            if (this.clientes.get(i).getId().equals(cliente.getId())){
                return false;
            }
        }
        boolean statusInserido = this.clientes.add(cliente);
        if(statusInserido){
            this.totalClientes++;
        }
        return statusInserido;
    }
    public boolean removerCliente(String id) {
        for (Cliente c : clientes) {
            if (c.getId().equalsIgnoreCase(id)) {
                clientes.remove(c);
                return true;
            }
        }
        return false;
    }

    public Cliente buscarClientePorId(String id){
        for (int i = 0; i < this.totalClientes; i++){
            if (this.clientes.get(i).getId().equals(id)){
                return this.clientes.get(i);
            }
        }
        return null;
    }

    public boolean realizarVenda(Veiculo veiculo, Cliente cliente, String dataVenda,
                                 double valorVenda, String formaPagamento){

        if (!veiculo.isDisponivel()) {
            return false;
        }

        boolean clienteCadastrado = false;
        for (int i = 0; i < this.totalClientes; i++){
            if (this.clientes.get(i).getId().equals(cliente.getId())){
                clienteCadastrado = true;
                break;
            }
        }
        if (!clienteCadastrado) {
            return false;
        }

        Venda venda = new Venda(veiculo, cliente, dataVenda, valorVenda, formaPagamento);
        boolean statusVenda = this.vendas.add(venda);
        if (statusVenda) {
            veiculo.setDisponivel(false);
            this.totalVendas++;
        }
        return statusVenda;
    }

    public ArrayList<Venda> listarTodasVendas(){
        return new ArrayList<>(this.vendas);
    }

    public String gerarRelatorioVeiculos(){
        String relatorio = String.format(
                "=== RELATÓRIO DE VEÍCULOS ===%n" +
                        "Total de veículos: %d%n" +
                        "Veículos disponíveis: %d%n" +
                        "--------------------------------%n",
                this.totalVeiculos, this.listarVeiculosDisponiveis().size()
        );

        for (int i = 0; i < this.totalVeiculos; i++){
            relatorio += this.veiculos.get(i).toString() + "\n";
        }
        return relatorio;
    }

    public String gerarRelatorioClientes(){
        String relatorio = String.format(
                "=== RELATÓRIO DE CLIENTES ===%n" +
                        "Total de clientes: %d%n" +
                        "--------------------------------%n",
                this.totalClientes
        );

        for (int i = 0; i < this.totalClientes; i++){
            relatorio += this.clientes.get(i).toString() + "\n";
        }
        return relatorio;
    }

    public String gerarRelatorioVendas(){
        String relatorio = String.format(
                "=== RELATÓRIO DE VENDAS ===%n" +
                        "Total de vendas: %d%n" +
                        "--------------------------------%n",
                this.totalVendas
        );

        for (int i = 0; i < this.totalVendas; i++){
            relatorio += this.vendas.get(i).toString() + "\n";
        }
        return relatorio;
    }
}