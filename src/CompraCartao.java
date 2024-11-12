public class CompraCartao extends Compra {
    @Override
    public void transferencia() {
        System.out.println("\nPagamento realizado por transferência bancária.");
    }
}