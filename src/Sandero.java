public class Sandero extends Carro{
    public Sandero(String cor, int ano, double valor) {
        super(4, cor, 110, ano, 3, valor);
    }
    @Override
    public void exibirDetalhes() {
        System.out.println("Sandero: " + cor + ", ano " + ano);
    }
}
