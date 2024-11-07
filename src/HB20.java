public class HB20 extends Carro{
    public HB20(String cor, int ano, double valor) {
        super(4, cor, 80, ano, 3, valor);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("HB20: " + getCor() + ", ano " + getAno());
    }

    @Override
    public String fichaTecnica() {
        return "HB20: " + getCor() + ", " + getPortas() + " portas, " + getCavalos() + " cavalos, ano " + getAno() + ", cilindros: " + getCilindros() + ", valor: R$" + getValor();    }
}
