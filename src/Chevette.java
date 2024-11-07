public class Chevette extends Carro {
    public Chevette(String cor, int ano, double valor) {
        super(2, cor, 60, ano, 4, valor);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Chevette: " + getCor() + ", ano " + getAno());
    }

    @Override
    public String fichaTecnica() {
        return "Chevette: " + getCor() + ", " + getPortas() + " portas, " + getCavalos() + " cavalos, ano " + getAno() + ", cilindros: " + getCilindros() + ", valor: R$" + getValor();
    }
}
