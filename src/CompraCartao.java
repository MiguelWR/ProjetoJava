public class CompraCartao extends Compra {
    @Override
    public void transferencia() {
        System.out.println("\nPagamento realizado por transferência bancária.");
    }
    @Override
    public void debito() {
        System.out.println("Pagamento realizado no débito.");
    }
    @Override
    public void situacao() { System.out.println("Compra aprovada."); }
}