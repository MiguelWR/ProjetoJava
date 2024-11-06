public class Celta extends Carro {
    public Celta(String cor, int ano, double valor) {
        super(2, cor, 77, ano, 4, valor);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Celta: " + cor + ", ano " + ano);
    }
}
