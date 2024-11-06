public class Kombi extends Carro{
    public Kombi(String cor, int ano, double valor) {
        super(3, cor, 78, ano, 4, valor);
    }
    @Override
    public void exibirDetalhes() {
        System.out.println("Kombi: " + cor + ", ano " + ano);
    }

    @Override
    public void fichaTecnica() {
        System.out.println("Kombi: " + cor + ", " + portas + " portas, " + cavalos + " cavalos, ano " + ano + ", cilindros: " + cilindros + ", valor: R$" + valor);
    }
}
