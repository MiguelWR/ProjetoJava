import java.io.*;
import java.util.ArrayList;

public class Persistencia {

    public static void salvarClientes(ArrayList<Cliente> clientes, String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(clientes);
            System.out.println("Lista de clientes salva com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar a lista de clientes: " + e.getMessage());
        }
    }

    public static ArrayList<Cliente> carregarClientes(String nomeArquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (ArrayList<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar a lista de clientes: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
