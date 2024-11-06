public class Fusca extends Carro {
    public Fusca(String cor, int ano, double valor) {
        super(2, cor, 60, ano, 4, valor);
    }

    public void exibirDetalhes() {
        System.out.println("Fusca Clássico: " + cor + ", ano " + ano);
    }
}
