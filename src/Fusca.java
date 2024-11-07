public class Fusca extends Carro {
    public Fusca(String cor, int ano, double valor) {
        super(2, cor, 60, ano, 4, valor);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Fusca: " + getCor() + ", ano " + getAno());
    }

    @Override
    public String fichaTecnica() {
        return "Fusca: " + getCor() + ", " + getPortas() + " portas, " + getCavalos() + " cavalos, ano " + getAno() + ", cilindros: " + getCilindros() + ", valor: R$" + getValor();    }
}

