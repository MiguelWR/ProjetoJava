public class Celta extends Carro {
    public Celta(String cor, int ano, double valor) {
        super(2, cor, 77, ano, 4, valor);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Celta: " + getCor() + ", ano " + getAno());
    }

    @Override
    public String fichaTecnica() {
        return "Celta: " + getCor() + ", " + getPortas() + " portas, " + getCavalos() + " cavalos, ano " + getAno() + ", cilindros: " + getCilindros() + ", valor: R$" + getValor();
    }
    @Override
    public String toString() {
        return "Celta: " + cor + ", " + portas + " portas, " + cavalos + " cavalos, " + "ano " + ano + ", cilindros: " + cilindros + ", valor: R$" + valor;
    }
}

