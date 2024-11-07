import javax.swing.*;
import java.awt.*;

public class View {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Página de Carros");
        frame.setSize(1370, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(Color.GRAY);
        frame.setContentPane(backgroundPanel);
        frame.setLayout(null); 


        JPanel menuPanel = new JPanel();
        menuPanel.setBounds(0, 0, 1370, 50); 
        menuPanel.setBackground(new Color(52, 52, 59));
        menuPanel.setLayout(new BorderLayout());

        JLabel label = new JLabel("AutoLux Automóveis", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));  
        label.setForeground(Color.WHITE); 
        menuPanel.add(label, BorderLayout.CENTER); 
        JPanel painel = new JPanel();
        painel.setBounds(20, 100, 1315, 500);
        painel.setLayout(new BorderLayout());

        painel.setBackground(Color.DARK_GRAY); 

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        textArea.setFont(new Font("Cambria", Font.BOLD, 22)); 
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.DARK_GRAY);

        Carro fusca = new Fusca("Azul", 1970, 12000);
        Carro chevette = new Chevette("Bege", 1978, 22000);
        Carro celta = new Celta("Preto", 2005, 20000);
        Carro focus = new Focus("Preto", 2010, 35000);
        Carro hb20 = new HB20("Branco", 2018, 40000);
        Carro kombi = new Kombi("Branco", 1980, 38000);
        Carro kwid = new Kwid("Laranja", 2023, 80000);
        Carro sandero = new Sandero("Prata", 2012, 33000);
        String fichaTecnicaCompleta = fusca.fichaTecnica()
                + "\n\n" + chevette.fichaTecnica()
                + "\n\n" + celta.fichaTecnica()
                + "\n\n" + focus.fichaTecnica()
                + "\n\n" + hb20.fichaTecnica()
                + "\n\n" + kombi.fichaTecnica()
                + "\n\n" + kwid.fichaTecnica()
                + "\n\n" + sandero.fichaTecnica();

        textArea.setText(fichaTecnicaCompleta);
        painel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        frame.add(menuPanel);
        frame.add(painel);    
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }
}
