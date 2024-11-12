import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        painel.setLayout(new GridBagLayout());
        painel.setBackground(Color.DARK_GRAY);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Cambria", Font.BOLD, 22));
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setBounds(20, 600, 1315, 150);

        Carro fusca = new Fusca("Azul", 1970, 12000);
        Carro chevette = new Chevette("Bege", 1978, 22000);
        Carro celta = new Celta("Preto", 2005, 20000);
        Carro focus = new Focus("Preto", 2010, 35000);
        Carro hb20 = new HB20("Branco", 2018, 40000);
        Carro kombi = new Kombi("Branco", 1980, 38000);
        Carro kwid = new Kwid("Laranja", 2023, 80000);
        Carro sandero = new Sandero("Prata", 2012, 33000);

        ActionListener showDetails = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                Carro selecionado = null;

                switch (source.getText()) {
                    case "Fusca":
                        selecionado = fusca;
                        break;
                    case "Chevette":
                        selecionado = chevette;
                        break;
                    case "Celta":
                        selecionado = celta;
                        break;
                    case "Focus":
                        selecionado = focus;
                        break;
                    case "HB20":
                        selecionado = hb20;
                        break;
                    case "Kombi":
                        selecionado = kombi;
                        break;
                    case "Kwid":
                        selecionado = kwid;
                        break;
                    case "Sandero":
                        selecionado = sandero;
                        break;
                }

                if (selecionado != null) {
                    textArea.setText(selecionado.fichaTecnica());
                }
            }
        };

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weightx = 1.0;

        addButtonToPanel(painel, "Fusca", showDetails, gbc, 0, 0);
        addButtonToPanel(painel, "Chevette", showDetails, gbc, 1, 0);
        addButtonToPanel(painel, "Celta", showDetails, gbc, 2, 0);
        addButtonToPanel(painel, "Focus", showDetails, gbc, 3, 0);

        addButtonToPanel(painel, "HB20", showDetails, gbc, 0, 1);
        addButtonToPanel(painel, "Kombi", showDetails, gbc, 1, 1);
        addButtonToPanel(painel, "Kwid", showDetails, gbc, 2, 1);
        addButtonToPanel(painel, "Sandero", showDetails, gbc, 3, 1);

        gbc.gridwidth = 4;
        painel.add(new JScrollPane(textArea), gbc);

        frame.add(menuPanel);
        frame.add(painel);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    private static void addButtonToPanel(JPanel panel, String carName, ActionListener listener, GridBagConstraints gbc, int x, int y) {

        JLabel label = new JLabel(carName, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
        gbc.gridx = x;
        gbc.gridy = y * 2;
        panel.add(label, gbc);

        JButton button = new JButton("Detalhes");
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setPreferredSize(new Dimension(100, 40));
        // mudança da cor do botao com o mouse
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.green);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.lightGray);
            }
        });
        button.setForeground(Color.black);
        button.setActionCommand(carName);
        button.addActionListener(listener);

        gbc.gridx = x;
        gbc.gridy = y * 2 + 1;
        panel.add(button, gbc);
    }
}
