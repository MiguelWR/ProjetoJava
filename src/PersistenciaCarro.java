import java.io.*;

public class PersistenciaCarro {

    public static void salvarCarro(Carro carro, String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(carro);
            System.out.println("Carro salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o carro: " + e.getMessage());
        }
    }

    public static Carro carregarCarro(String carros) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(carros))) {
            return (Carro) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar o carro: " + e.getMessage());
            return null;
        }
    }
}
