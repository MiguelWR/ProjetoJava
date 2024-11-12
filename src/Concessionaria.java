import java.util.ArrayList;

public class Concessionaria {
    private String nome;
    private double lucro;
    private String cnpj;
    private int estoque;

    public Concessionaria(String nome, double lucro, String cnpj, int estoque) {
        this.nome = nome;
        this.lucro = lucro;
        this.cnpj = cnpj;
        this.estoque = estoque;
    }

    // GETs e SETs
    public String getNome() { return nome; }
    public double getLucro() { return lucro; }
    public String getCnpj() { return cnpj; }
    public int getEstoque() { return estoque; }

    public void setNome(String nome) { this.nome = nome; }
    public void setLucro(double lucro) { this.lucro = lucro; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public void realizarTransferencia(Cliente cliente, Carro carro, Compra compra) throws SaldoInsuficienteException {
        if (cliente.getSaldo() >= carro.getValor()) {
            compra.transferencia();
            cliente.setSaldo(cliente.getSaldo() - carro.getValor());
            System.out.println("Compra realizada com sucesso para o carro\n");
        } else {
            throw new SaldoInsuficienteException("\nSaldo insuficiente para realizar a compra do carro ");
        }
    }
}
