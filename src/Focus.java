public class Focus extends Carro{
    public Focus(String cor, int ano, double valor) {
        super(4, cor, 175, ano, 3, valor);
    }
    public void exibirDetalhes() {
        System.out.println("Focus: " + cor + ", ano " + ano);
    }

    @Override
    public void fichaTecnica() {
        System.out.println("Focus: " + cor + ", " + portas + " portas, " + cavalos + " cavalos, ano " + ano + ", cilindros: " + cilindros + ", valor: R$" + valor);
    }
}
