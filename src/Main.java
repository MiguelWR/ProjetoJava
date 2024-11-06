public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Ana", 30, 20000, "123.456.789-00");
        Concessionaria concessionaria = new Concessionaria("AutoLux", 500000, "12.345.678/0001-99", 20);

        Carro fusca = new Fusca("Azul", 1970, 12000);
        Carro chevette = new Chevette("Bege", 1978, 22000);
        Carro celta = new Celta("Preto", 2005, 20000);
        Carro focus = new Focus("Preto", 2010, 35000);
        Carro hb20 = new HB20("Branco", 2018, 40000);
        Carro kombi = new Kombi("Branco", 1980, 38000);
        Carro kwid = new Kwid("Laranja", 2023, 80000);
        Carro sandero = new Sandero("Prata", 2012, 33000);

        concessionaria.adicionarCarro(fusca);
        concessionaria.adicionarCarro(chevette);
        concessionaria.adicionarCarro(celta);
        concessionaria.adicionarCarro(focus);
        concessionaria.adicionarCarro(hb20);
        concessionaria.adicionarCarro(kombi);
        concessionaria.adicionarCarro(kwid);
        concessionaria.adicionarCarro(sandero);

        System.out.println("Carros disponíveis na concessionária " + concessionaria.getNome() + ":");
        for (Carro carro : concessionaria.getCarros()) {
            carro.exibirDetalhes();
        }
        System.out.println("================================================================");
        System.out.println("Configurações dos carros " + concessionaria.getNome() + ":");
        for (Carro carro : concessionaria.getCarros()) {
            carro.fichaTecnica();
        }
    }
}