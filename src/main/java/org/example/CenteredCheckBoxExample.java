package org.example;
import java.awt.*;
import javax.swing.*;

public class CenteredCheckBoxExample {

    private JFrame frame;
    private JPanel panel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CenteredCheckBoxExample example = new CenteredCheckBoxExample();
            example.createAndShowGUI();
        });
    }

    public void createAndShowGUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        addComponentsToPanel();

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addComponentsToPanel() {
        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));

        checkBoxPanel.add(Box.createVerticalGlue()); // Componente de relleno

        JCheckBox checkBox = new JCheckBox("Centrado");
        checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkBoxPanel.add(checkBox);

        checkBoxPanel.add(Box.createVerticalGlue()); // Componente de relleno

        JButton button = new JButton("Botón");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkBoxPanel.add(button);

        checkBoxPanel.add(Box.createVerticalGlue()); // Componente de relleno

        panel.add(checkBoxPanel);
    }
}
