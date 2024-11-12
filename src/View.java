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
                Carro selectedCar = null;

                switch (source.getActionCommand()) {
                    case "Fusca":
                        selectedCar = fusca;
                        break;
                    case "Chevette":
                        selectedCar = chevette;
                        break;
                    case "Celta":
                        selectedCar = celta;
                        break;
                    case "Focus":
                        selectedCar = focus;
                        break;
                    case "HB20":
                        selectedCar = hb20;
                        break;
                    case "Kombi":
                        selectedCar = kombi;
                        break;
                    case "Kwid":
                        selectedCar = kwid;
                        break;
                    case "Sandero":
                        selectedCar = sandero;
                        break;
                }

                if (selectedCar != null) {
                    showCarDetails(selectedCar);
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
        button.setBackground(Color.lightGray);
        button.setForeground(Color.black);
        // muda a cor do botão
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.green);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.lightGray);
            }
        });
        button.setActionCommand(carName);
        button.addActionListener(listener);

        gbc.gridx = x;
        gbc.gridy = y * 2 + 1;
        panel.add(button, gbc);
    }
    private static void showCarDetails(Carro car) {
        JDialog dialog = new JDialog();
        dialog.setTitle("Especificações - " + car.getClass().getSimpleName());
        dialog.setSize(450, 400);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(52, 52, 59));
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(car.getClass().getSimpleName(), JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panel.add(titleLabel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setBackground(new Color(52, 52, 59));
        textArea.setForeground(Color.WHITE);
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        String detalhes = String.format(
                "Cor: %s\n" +
                        "Portas: %d\n" +
                        "Cavalos: %d\n" +
                        "Ano: %d\n" +
                        "Cilindros: %d\n" +
                        "Valor: R$ %.2f",
                car.getCor(), car.getPortas(), car.getCavalos(), car.getAno(), car.getCilindros(), car.getValor()
        );
        textArea.setText(detalhes);

        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton buyButton = new JButton("Comprar");
        buyButton.setFont(new Font("Arial", Font.BOLD, 16));
        buyButton.setBackground(new Color(76, 175, 80));
        buyButton.setForeground(Color.WHITE);
        buyButton.setFocusPainted(false);
        buyButton.setPreferredSize(new Dimension(120, 40));
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPurchaseConfirmation();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(52, 52, 59));
        buttonPanel.add(buyButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        dialog.add(panel);
        dialog.setVisible(true);
    }

    private static void showPurchaseConfirmation() {
        JDialog confirmationDialog = new JDialog();
        confirmationDialog.setTitle("Confirmação de Compra");
        confirmationDialog.setSize(350, 200);
        confirmationDialog.setLocationRelativeTo(null);
        confirmationDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel confirmationPanel = new JPanel();
        confirmationPanel.setBackground(new Color(52, 52, 59));
        confirmationPanel.setLayout(new BorderLayout());
        JLabel confirmationLabel = new JLabel("Compra realizada com sucesso!", JLabel.CENTER);
        confirmationLabel.setFont(new Font("Arial", Font.BOLD, 18));
        confirmationLabel.setForeground(Color.WHITE);

        confirmationLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        confirmationPanel.add(confirmationLabel, BorderLayout.CENTER);

        confirmationDialog.add(confirmationPanel);
        confirmationDialog.setVisible(true);
    }




}