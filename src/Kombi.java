public class Kombi extends Carro{
    public Kombi(String cor, int ano, double valor) {
        super(3, cor, 78, ano, 4, valor);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Kombi: " + getCor() + ", ano " + getAno());
    }

    @Override
    public String fichaTecnica() {
        return "Kombi: " + getCor() + ", " + getPortas() + " portas, " + getCavalos() + " cavalos, ano " + getAno() + ", cilindros: " + getCilindros() + ", valor: R$" + getValor();    }
    @Override
    public String toString() {
        return "Kombi: " + cor + ", " + portas + " portas, " + cavalos + " cavalos, " + "ano " + ano + ", cilindros: " + cilindros + ", valor: R$" + valor;
    }
}

