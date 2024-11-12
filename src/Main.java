import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static Concessionaria concessionaria;
    private static ArrayList<Carro> carros = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDados();

        clientes = Persistencia.carregarClientes("clientes.dat");

        exibirMenu();
    }

    private static void inicializarDados() {
        concessionaria = new Concessionaria("AutoLux", "12.345.678/0001-99");

        carros.add(new Fusca("Azul", 1970, 12000));
        carros.add(new Chevette("Bege", 1978, 22000));
        carros.add(new Celta("Preto", 2005, 20000));
        carros.add(new Focus("Preto", 2010, 35000));
        carros.add(new HB20("Branco", 2018, 40000));
        carros.add(new Kombi("Branco", 1980, 38000));
        carros.add(new Kwid("Laranja", 2023, 80000));
        carros.add(new Sandero("Prata", 2012, 33000));
    }

    private static void exibirMenu() {
        int escolha;
        do {
            System.out.println("\n========= Menu de Funcionalidades =========");
            System.out.println("1. Cadastrar novo cliente");
            System.out.println("2. Exibir todos os clientes");
            System.out.println("3. Realizar compra de carro");
            System.out.println("4. Exibir carros disponíveis");
            System.out.println("5. Exibir ficha técnica dos carros");
            System.out.println("6. Leitor de arquivo");
            System.out.println("7. Verificar saldo do cliente");
            System.out.println("8. Exibir dados da concessionária");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1:
                    cadastrarNovoCliente();
                    break;
                case 2:
                    exibirClientes();
                    break;
                case 3:
                    realizarCompra();
                    break;
                case 4:
                    exibirCarros();
                    break;
                case 5:
                    exibirFichaTecnica();
                    break;
                case 6:
                    leitorArquivo();
                    break;
                case 7:
                    saldoCliente();
                    break;
                case 8:
                    exibirConcessionaria();
                    break;
                case 9:
                    System.out.println("Fechando programa");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolha != 9);
    }


    private static void cadastrarNovoCliente() {
        System.out.print("Nome do cliente: ");
        String nome = input.nextLine();
        System.out.print("Idade do cliente: ");
        int idade = input.nextInt();
        System.out.print("Saldo do cliente: ");
        double saldo = input.nextDouble();
        input.nextLine();
        System.out.print("CPF do cliente: ");
        String cpf = input.nextLine();

        Cliente cliente = new Cliente(nome, idade, saldo, cpf);
        clientes.add(cliente);
        salvarClientes();
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void realizarCompra() {
        exibirClientes();
        System.out.print("Escolha o índice do cliente que deseja realizar a compra: ");
        int clienteIndex = input.nextInt();

        exibirCarros();
        System.out.print("Escolha o índice do carro para compra: ");
        int carroIndex = input.nextInt();

        Cliente cliente = clientes.get(clienteIndex);
        Carro carro = carros.get(carroIndex);
        CompraCartao compra = new CompraCartao();

        try {
            concessionaria.realizarTransferencia(cliente, carro, compra);
            salvarClientes();
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void exibirClientes() {
        System.out.println("\nClientes cadastrados:\n");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            System.out.println("[" + i + "] . Nome: " + cliente.getNome() + ", Idade: " + cliente.getIdade() + ", CPF: " + cliente.getCpf() + ", Saldo: R$ " + cliente.getSaldo());
        }
    }

    private static void exibirCarros() {
        System.out.println("\nCarros disponíveis na concessionária " + concessionaria.getNome() + ":\n");
        for (int i = 0; i < carros.size(); i++) {
            Carro carro = carros.get(i);
            System.out.println("[" + i + "] . " + carro.getClass().getSimpleName() + " - Cor: " + carro.getCor() + ", Ano: " + carro.getAno() + ", Valor: R$ " + carro.getValor());
        }
    }

    private static void exibirFichaTecnica() {
        System.out.println("\nFicha técnica dos carros da concessionária " + concessionaria.getNome() + ":\n");
        for (Carro carro : carros) {
            System.out.println(carro.fichaTecnica());
        }
    }

    private static void salvarClientes() {
        Persistencia.salvarClientes(clientes, "clientes.dat");
        System.out.println("\nLista de clientes salva com sucesso!");
    }

    private static void leitorArquivo() {
        String caminhoArquivo = "C:/Users/leand/Documents/GitHub/ProjetoJava/arquivo.txt";

        try {
            File arquivo = new File(caminhoArquivo);
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                System.out.println(linha);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }

    private static void saldoCliente() {
        exibirClientes();
        System.out.print("Escolha o índice do cliente para verificar o saldo: ");
        int clienteIndex = input.nextInt();

        if (clienteIndex >= 0 && clienteIndex < clientes.size()) {
            Cliente cliente = clientes.get(clienteIndex);
            cliente.verificarSaldo();
        } else {
            System.out.println("Índice inválido.");
        }
    }
    private static void exibirConcessionaria() {
        System.out.println("Nome da Concessionária: " + concessionaria.getNome());
        System.out.println("CNPJ: " + concessionaria.getCnpj());
    }
}


