public class Chevette extends Carro {
    public Chevette(String cor, int ano, double valor) {
        super(2, cor, 60, ano, 4, valor);
    }
    @Override
    public void exibirDetalhes() {
        System.out.println("Chevette: " + cor + ", ano " + ano);
    }

    @Override
    public void fichaTecnica() {
        System.out.println("Chevette: " + cor + ", " + portas + " portas, " + cavalos + " cavalos, ano " + ano + ", cilindros: " + cilindros + ", valor: R$" + valor);
    }
}
