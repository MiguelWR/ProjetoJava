import java.util.ArrayList;
public class Concessionaria {
    private String nome;
    private String cnpj;


    public Concessionaria(String nome, String cnpj) {
            this.nome = nome;
            this.cnpj = cnpj;
        }

        // GETs e SETs
        public String getNome() { return nome; }
        public String getCnpj() { return cnpj; }

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