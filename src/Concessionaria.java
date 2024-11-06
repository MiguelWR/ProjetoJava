import java.util.ArrayList;

public class Concessionaria {
    private String nome;
    private double lucro;
    private String cnpj;
    private int estoque;
    private ArrayList<Carro> carros;

    public Concessionaria(String nome, double lucro, String cnpj, int estoque) {
        this.nome = nome;
        this.lucro = lucro;
        this.cnpj = cnpj;
        this.estoque = estoque;
        this.carros = new ArrayList<>();
    }

    public void adicionarCarro(Carro carro) {
        this.carros.add(carro);
        this.estoque++;
    }

    // GETs e SETs
    public String getNome() { return nome; }
    public double getLucro() { return lucro; }
    public String getCnpj() { return cnpj; }
    public int getEstoque() { return estoque; }
    public ArrayList<Carro> getCarros() { return carros; }

    public void setNome(String nome) { this.nome = nome; }
    public void setLucro(double lucro) { this.lucro = lucro; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public void setEstoque(int estoque) { this.estoque = estoque; }

    public void realizarCompra(Cliente cliente, Carro carro, Compra compra) {
        if (cliente.getSaldo() >= carro.getValor()) {
            compra.transferencia();
            cliente.setSaldo(cliente.getSaldo() - carro.getValor());
            System.out.println("Compra realizada com sucesso.");
        } else if(cliente.getSaldo() <= carro.getValor()) {
            System.out.println("Saldo insuficiente.");
            System.out.println("Compra não concluída.");
        }
    }
}