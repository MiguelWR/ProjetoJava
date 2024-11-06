public class Focus extends Carro{
    public Focus(String cor, int ano, double valor) {
        super(4, cor, 175, ano, 3, valor);
    }
    public void exibirDetalhes() {
        System.out.println("Focus: " + cor + ", ano " + ano);
    }
}
