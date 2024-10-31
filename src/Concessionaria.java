public class Concessionaria {
    private String nome;
    private double lucro;
    private String cnpj;
    private int estoque;

    public Concessionaria(String nome, double lucro, int cnpj, int estoque){
        this.nome = nome;
        this.lucro = lucro;
        this.cnpj = cnpj;
        this.estoque = estoque;
    }
//GETs e SETs 
    
public String getNome(){
        return nome;
    }
    public double getLucro(){
        return lucro;
    }
    public String getCnpj(){
        return cnpj;
    }
    public int getEstoque(){
        return estoque;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setLucro(double Lucro){
        this.lucro = lucro;
    }
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
    public void setEstoque(int estoque){
        this.estoque = estoque;
    }
}

