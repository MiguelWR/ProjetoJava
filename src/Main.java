public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Ana", 30, 15000, "123.456.789-00");
        Concessionaria concessionaria = new Concessionaria("AutoLux", 500000, "12.345.678/0001-99", 20);

        Carro fusca = new Fusca("Azul", 1970, 12000);
        Compra compra = new CompraCartao();

        concessionaria.realizarCompra(cliente, fusca, compra);
        concessionaria.finalizarCompra(compra);
    }
}