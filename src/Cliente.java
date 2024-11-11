import java.io.Serializable;

public class Cliente implements Serializable {
    private String nome;
    private int idade;
    private double saldo;
    private String cpf;

    public Cliente(String nome, int idade, double saldo, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.saldo = saldo;
        this.cpf = cpf;
    }

    // GETs e SETs
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public double getSaldo() { return saldo; }
    public String getCpf() { return cpf; }

    public void setNome(String nome) { this.nome = nome; }
    public void setIdade(int idade) { this.idade = idade; }
    public void setSaldo(double saldo) { this.saldo = saldo; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public void verificarSaldo() {
        System.out.println("Seu saldo é: " + saldo);
    }
}