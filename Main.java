import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Concessionaria concessionaria = new Concessionaria();
        int opcao;

        do {
            System.out.println("\n===== MENU CONCESSIONÁRIA =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Remover cliente");
            System.out.println("3 - Cadastrar veículo");
            System.out.println("4 - Listar veículos disponíveis");
            System.out.println("5 - Realizar venda");
            System.out.println("6 - Listar vendas");
            System.out.println("7 - Buscar veiculo por marca");
            System.out.println("8- Buscar veiculo por modelo");
            System.out.println("9 - Remover veículo");
            System.out.println("10 - Lista relatorio de vendas");
            System.out.println("11 - Lista relatorio de clientes");
            System.out.println("12 - Lista relatorio de veiculos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    Cliente cliente = new Cliente(nome, id, telefone, email);
                    if (concessionaria.cadastrarCliente(cliente)) {
                        System.out.println("Cliente cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro: já existe cliente com esse ID!");
                    }
                    break;
                case 2:
                    System.out.print("Digite o ID do cliente para remover: ");
                    String idRemover = sc.nextLine();
                    if (concessionaria.removerCliente(idRemover)) {
                        System.out.println("Cliente removido com sucesso!");
                    } else {
                        System.out.println("Erro: cliente não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    sc.nextLine();

                    Veiculo veiculo = new Veiculo(marca, modelo, placa, ano, preco);
                    concessionaria.adicionarVeiculo(veiculo);
                    System.out.println("Veículo cadastrado com sucesso!");
                    break;

                case 4:
                    System.out.println("\n--- Veículos Disponíveis ---");
                    System.out.println(concessionaria.listarVeiculosDisponiveis());
                    break;

                case 5:
                    System.out.print("Modelo do veículo: ");
                    String modeloVenda = sc.nextLine();
                    System.out.print("ID do cliente: ");
                    String idCliente = sc.nextLine();
                    System.out.print("Data da venda (dd/mm/aaaa): ");
                    String data = sc.nextLine();
                    System.out.print("Forma de pagamento: ");
                    String formaPagamento = sc.nextLine();

                    Veiculo v = concessionaria.buscarVeiculoPorModelo(modeloVenda).get(0);
                    Cliente c = concessionaria.buscarClientePorId(idCliente);

                    if (v != null && c != null) {
                        if (concessionaria.realizarVenda(v, c, data, v.getPreco(), formaPagamento)) {
                            System.out.println("Venda realizada com sucesso!");
                        } else {
                            System.out.println("Falha ao realizar a venda!");
                        }
                    } else {
                        System.out.println("veículo ou cliente não encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("\n--- Relatório de Vendas ---");
                    System.out.println(concessionaria.listarTodasVendas());
                    break;

                case 7:
                    System.out.print("Digite a marca do veículo: ");
                    String marcaBusca = sc.nextLine();
                    System.out.println("\n--- Veículos encontrados ---");
                    System.out.println(concessionaria.buscarVeiculoPorMarca(marcaBusca));
                    break;
                case 8:
                    System.out.print("Digite o modelo do veículo: ");
                    String modeloBusca = sc.nextLine();
                    System.out.println("\n--- Veículos encontrados ---");
                    System.out.println(concessionaria.buscarVeiculoPorModelo(modeloBusca));
                    break;
                case 9:
                    System.out.print("Digite a placa do veículo para remover: ");
                    String placaRemover = sc.nextLine();
                    if (concessionaria.removerVeiculo(placaRemover)) {
                        System.out.println("Veículo removido com sucesso!");
                    } else {
                        System.out.println("Erro: veículo não encontrado ou já vendido.");
                    }
                    break;

                case 10:
                    System.out.println(concessionaria.gerarRelatorioVendas());
                    break;

                case 11:
                    System.out.println(concessionaria.gerarRelatorioClientes());
                    break;

                case 12:
                    System.out.println(concessionaria.gerarRelatorioVeiculos());
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}

