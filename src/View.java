import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class View extends JFrame {
    private ArrayList<Cliente> clientes;
    private Concessionaria concessionaria;
    private ArrayList<Carro> carros;
    private JTextArea displayArea;

    public View() {
        clientes = Persistencia.carregarClientes("clientes.dat");
        inicializarDados();
        setTitle("AutoLux Automóveis");
        setSize(1370, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(52, 52, 59));
        JLabel concessionariaLabel = new JLabel("AutoLux Automóveis", JLabel.CENTER);
        concessionariaLabel.setFont(new Font("Arial", Font.BOLD, 24));
        concessionariaLabel.setForeground(Color.WHITE);
        headerPanel.add(concessionariaLabel);

        add(headerPanel, BorderLayout.NORTH);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(1, 9));
        menuPanel.setBackground(new Color(52, 52, 59));

        JButton[] buttons = {
                new JButton("Cadastrar Cliente"),
                new JButton("Exibir Clientes"),
                new JButton("Realizar Compra"),
                new JButton("Exibir Carros"),
                new JButton("Ficha Técnica"),
                new JButton("Leitor de Arquivo"),
                new JButton("Saldo Cliente"),
                new JButton("Dados da Concessionária"),
                new JButton("Sair")
        };

        Dimension buttonSize = new Dimension(150, 40);
        for (JButton button : buttons) {
            button.setPreferredSize(buttonSize);
            button.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    button.setBackground(new Color(100, 100, 100));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    button.setBackground(new Color(238, 238, 238));
                }
            });
        }

        ActionListener[] actions = {
                e -> cadastrarNovoCliente(),
                e -> exibirClientes(),
                e -> realizarCompra(),
                e -> exibirCarros(),
                e -> exibirFichaTecnica(),
                e -> leitorArquivo(),
                e -> saldoCliente(),
                e -> exibirConcessionaria(),
                e -> System.exit(0)
        };

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(actions[i]);
            buttons[i].setBackground(new Color(238, 238, 238));
            buttons[i].setFocusPainted(false);
            menuPanel.add(buttons[i]);
        }

        add(menuPanel, BorderLayout.CENTER);

        displayArea = new JTextArea();
        displayArea.setFont(new Font("Arial", Font.PLAIN, 16));
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void inicializarDados() {
        concessionaria = new Concessionaria("AutoLux", "12.345.678/0001-99");
        carros = new ArrayList<>();
        carros.add(new Fusca("Azul", 1970, 12000));
        carros.add(new Chevette("Bege", 1978, 22000));
        carros.add(new Celta("Preto", 2005, 20000));
        carros.add(new Focus("Preto", 2010, 35000));
        carros.add(new HB20("Branco", 2018, 40000));
        carros.add(new Kombi("Branco", 1980, 38000));
        carros.add(new Kwid("Laranja", 2023, 80000));
        carros.add(new Sandero("Prata", 2012, 33000));
    }

    private void cadastrarNovoCliente() {
        String nome = JOptionPane.showInputDialog("Nome do cliente:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade do cliente:"));
        double saldo = Double.parseDouble(JOptionPane.showInputDialog("Saldo do cliente:"));
        String cpf = JOptionPane.showInputDialog("CPF do cliente:");

        Cliente cliente = new Cliente(nome, idade, saldo, cpf);
        clientes.add(cliente);
        salvarClientes();
        JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
    }

    private void realizarCompra() {
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum cliente cadastrado.");
            return;
        }
        if (carros.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum carro disponível.");
            return;
        }

        String[] clienteOptions = new String[clientes.size()];
        for (int i = 0; i < clientes.size(); i++) {
            clienteOptions[i] = clientes.get(i).getNome();
        }

        String clienteNome = (String) JOptionPane.showInputDialog(
                this, "Escolha o cliente:", "Clientes",
                JOptionPane.PLAIN_MESSAGE, null, clienteOptions, clienteOptions[0]);

        Cliente cliente = clientes.get(buscarClienteIndex(clienteNome));

        String[] carroOptions = new String[carros.size()];
        for (int i = 0; i < carros.size(); i++) {
            carroOptions[i] = carros.get(i).getClass().getSimpleName();
        }

        String carroNome = (String) JOptionPane.showInputDialog(
                this, "Escolha o carro:", "Carros",
                JOptionPane.PLAIN_MESSAGE, null, carroOptions, carroOptions[0]);

        Carro carro = carros.get(buscarCarroIndex(carroNome));
        CompraCartao compra = new CompraCartao();

        try {
            concessionaria.realizarTransferencia(cliente, carro, compra);
            salvarClientes();
            JOptionPane.showMessageDialog(this, "Compra realizada com sucesso!");
        } catch (SaldoInsuficienteException e) {
            JOptionPane.showMessageDialog(this, "Erro na compra: " + e.getMessage());
        }
    }

    private int buscarClienteIndex(String nome) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNome().equals(nome)) return i;
        }
        return -1;
    }

    private int buscarCarroIndex(String nome) {
        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getClass().getSimpleName().equals(nome)) return i;
        }
        return -1;
    }

    private void exibirClientes() {
        StringBuilder sb = new StringBuilder("Clientes cadastrados:\n");
        for (Cliente cliente : clientes) {
            sb.append(cliente.toString()).append("\n");
        }
        mostrarEmNovaJanela("Clientes Cadastrados", sb.toString());
    }

    private void exibirCarros() {
        StringBuilder sb = new StringBuilder("Carros disponíveis:\n");
        for (Carro carro : carros) {
            sb.append(carro.getClass().getSimpleName()).append("\n");
        }
        mostrarEmNovaJanela("Carros Disponíveis", sb.toString());
    }

    private void exibirFichaTecnica() {
        StringBuilder sb = new StringBuilder("Ficha Técnica dos Carros:\n");
        for (Carro carro : carros) {
            sb.append(carro.fichaTecnica()).append("\n");
        }
        mostrarEmNovaJanela("Ficha Técnica dos Carros", sb.toString());
    }

    private void saldoCliente() {
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum cliente cadastrado.");
            return;
        }

        String[] clienteOptions = new String[clientes.size()];
        for (int i = 0; i < clientes.size(); i++) {
            clienteOptions[i] = clientes.get(i).getNome();
        }

        String clienteNome = (String) JOptionPane.showInputDialog(
                this, "Escolha o cliente:", "Clientes",
                JOptionPane.PLAIN_MESSAGE, null, clienteOptions, clienteOptions[0]);

        Cliente cliente = clientes.get(buscarClienteIndex(clienteNome));
        String saldoInfo = "Saldo do cliente " + cliente.getNome() + ": R$" + cliente.getSaldo();
        mostrarEmNovaJanela("Saldo do Cliente", saldoInfo);
    }

    private void exibirConcessionaria() {
        String info = "Concessionária: " + concessionaria.getNome() + "\nCNPJ: " + concessionaria.getCnpj();
        mostrarEmNovaJanela("Dados da Concessionária", info);
    }

    private void leitorArquivo() {
        String caminhoArquivo = JOptionPane.showInputDialog("Caminho do arquivo:");
        try {
            File arquivo = new File(caminhoArquivo);
            Scanner scanner = new Scanner(arquivo);
            StringBuilder conteudoArquivo = new StringBuilder();
            while (scanner.hasNextLine()) {
                conteudoArquivo.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
            mostrarEmNovaJanela("Conteúdo do Arquivo", conteudoArquivo.toString());
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Arquivo não encontrado.");
        }
    }

    private void salvarClientes() {
        Persistencia.salvarClientes(clientes, "clientes.dat");
    }

    private void mostrarEmNovaJanela(String titulo, String conteudo) {
        JFrame novaJanela = new JFrame(titulo);
        JTextArea texto = new JTextArea(conteudo);
        texto.setEditable(false);
        texto.setFont(new Font("Arial", Font.PLAIN, 16));
        novaJanela.add(new JScrollPane(texto));
        novaJanela.setSize(600, 400);
        novaJanela.setLocationRelativeTo(this);
        novaJanela.setVisible(true);
    }

    public static void main(String[] args) {
        new View();
    }
}
