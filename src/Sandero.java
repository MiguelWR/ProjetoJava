public class Sandero extends Carro{
    public Sandero(String cor, int ano, double valor) {
        super(4, cor, 110, ano, 3, valor);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Sandero: " + getCor() + ", ano " + getAno());
    }

    @Override
    public String fichaTecnica() {
        return "Sandero: " + getCor() + ", " + getPortas() + " portas, " + getCavalos() + " cavalos, ano " + getAno() + ", cilindros: " + getCilindros() + ", valor: R$" + getValor();    }
    @Override
    public String toString() {
        return "Fusca: " + cor + ", " + portas + " portas, " + cavalos + " cavalos, " + "ano " + ano + ", cilindros: " + cilindros + ", valor: R$" + valor;
    }
}

