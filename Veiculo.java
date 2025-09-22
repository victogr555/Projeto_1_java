public class Veiculo {
    public String marca;
    public String modelo;
    public String placa;
    public int ano;
    public boolean disponivel;
    public double preco;

    public Veiculo(String marca,  String modelo, String placa, int ano, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.preco = preco;
        this.disponivel = true;
    }

    public String getPlaca(){return placa;}
    public boolean isDisponivel(){return disponivel;}
    public void setDisponivel(boolean disponivel){this.disponivel = disponivel;}
    public double getPreco(){return preco;}
    public String getMarca(){return marca;}
    public String getModelo(){return modelo;}

    @Override
    public String toString(){
        return String.format("Marca do veículo: %s | Modelo: %s | Placa: %s | Ano: %d | Preço: R$ %.2f",
                marca, modelo, placa, ano, preco);
    }
}
