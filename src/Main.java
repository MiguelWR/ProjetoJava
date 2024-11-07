import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Ana", 30, 20000, "123.456.789-00");
        Concessionaria concessionaria = new Concessionaria("AutoLux", 500000, "12.345.678/0001-99", 20);
        ArrayList<Carro> carros = new ArrayList<>();

        Carro fusca = new Fusca("Azul", 1970, 12000);
        Carro chevette = new Chevette("Bege", 1978, 22000);
        Carro celta = new Celta("Preto", 2005, 20000);
        Carro focus = new Focus("Preto", 2010, 35000);
        Carro hb20 = new HB20("Branco", 2018, 40000);
        Carro kombi = new Kombi("Branco", 1980, 38000);
        Carro kwid = new Kwid("Laranja", 2023, 80000);
        Carro sandero = new Sandero("Prata", 2012, 33000);

        carros.add(fusca);
        carros.add(chevette);
        carros.add(celta);
        carros.add(focus);
        carros.add(hb20);
        carros.add(kombi);
        carros.add(kwid);
        carros.add(sandero);

        for (Carro carro : carros) {
            carro.exibirDetalhes();
        }
        System.out.println("=============================================================");
        for (Carro carro : carros) {
            carro.fichaTecnica();
        }
    }
}
