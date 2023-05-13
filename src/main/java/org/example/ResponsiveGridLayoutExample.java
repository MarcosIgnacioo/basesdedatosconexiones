package org.example;

import java.awt.*;
import javax.swing.*;

public class ResponsiveGridLayoutExample {

    private JFrame frame;
    private JPanel panel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ResponsiveGridLayoutExample example = new ResponsiveGridLayoutExample();
            example.createAndShowGUI();
        });
    }

    public void createAndShowGUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900,900));

        panel = new JPanel(new GridBagLayout());
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        addComponentsToPanel();

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addComponentsToPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Etiqueta 1
        JLabel label1 = new JLabel("Etiqueta 1:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER; // Alinear al centro horizontalmente
        panel.add(label1, gbc);

        JTextField textField1 = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // Permitir expansión horizontal
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textField1, gbc);

        // Resto de los componentes...
    }
}
