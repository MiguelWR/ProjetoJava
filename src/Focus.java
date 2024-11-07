public class Focus extends Carro{
    public Focus(String cor, int ano, double valor) {
        super(4, cor, 175, ano, 3, valor);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Focus: " + getCor() + ", ano " + getAno());
    }

    @Override
    public String fichaTecnica() {
        return "Focus: " + getCor() + ", " + getPortas() + " portas, " + getCavalos() + " cavalos, ano " + getAno() + ", cilindros: " + getCilindros() + ", valor: R$" + getValor();
    }
}
