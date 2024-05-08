package Swing.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenderPanel extends JPanel implements ActionListener {
    private JButton maleButton;
    private JButton femaleButton;

    public GenderPanel() {
        setLayout(new BorderLayout());

        maleButton = new JButton("Male");
        maleButton.addActionListener(this);
        maleButton.setIcon(new ImageIcon("src/maleTrainer.png")); // Aggiungi il percorso dell'icona del maschio

        femaleButton = new JButton("Female");
        femaleButton.addActionListener(this);
        femaleButton.setIcon(new ImageIcon("src/maleTrainer.png")); // Aggiungi il percorso dell'icona della femmina

        JPanel topPanel = new JPanel();
        topPanel.add(femaleButton);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(maleButton);

        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == maleButton) {
            System.out.println("Selected Male");
            // Esegui le azioni necessarie per la selezione del maschio nel gioco Pokemon
        } else if (e.getSource() == femaleButton) {
            System.out.println("Selected Female");
            // Esegui le azioni necessarie per la selezione della femmina nel gioco Pokemon
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Pokemon Gender Selection");
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            GenderPanel genderPanel = new GenderPanel();
            frame.add(genderPanel);

            frame.setVisible(true);
        });
    }
}