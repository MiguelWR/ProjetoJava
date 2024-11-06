public class Kwid extends Carro{
    public Kwid(String cor, int ano, double valor) {
        super(4, cor, 65, ano, 3, valor);
    }
    @Override
    public void exibirDetalhes() {
        System.out.println("Kwid: " + cor + ", ano " + ano);
    }
}
