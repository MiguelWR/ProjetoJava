public class Carro {
    protected int portas;
    protected String cor;
    protected int cavalos;
    protected int ano;
    protected int cilindros;
    protected double valor;

    public Carro(int portas, String cor, int cavalos, int ano, int cilindros, double valor) {
        this.portas = portas;
        this.cor = cor;
        this.cavalos = cavalos;
        this.ano = ano;
        this.cilindros = cilindros;
        this.valor = valor;
    }

    // GETs e SETs
    public int getPortas() { return portas; }
    public String getCor() { return cor; }
    public int getCavalos() { return cavalos; }
    public int getAno() { return ano; }
    public int getCilindros() { return cilindros; }
    public double getValor() { return valor; }

    public void setPortas(int portas) { this.portas = portas; }
    public void setCor(String cor) { this.cor = cor; }
    public void setCavalos(int cavalos) { this.cavalos = cavalos; }
    public void setAno(int ano) { this.ano = ano; }
    public void setCilindros(int cilindros) { this.cilindros = cilindros; }
    public void setValor(double valor) { this.valor = valor; }

    public void exibirDetalhes() {
        System.out.println("Carro: " + cor + ", " + portas + " portas, " + cavalos + " cavalos, ano " + ano);
    }
}