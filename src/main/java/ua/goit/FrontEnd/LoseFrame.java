package ua.goit.FrontEnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoseFrame extends JFrame implements ActionListener {
    private final JButton restartButton;
    private final JButton exitButton;

    public LoseFrame() {
        // Set introductory text
        JLabel label = new JLabel("Ви програли, але не переживайте, наступного разу пощастить");
        label.setBounds(50, 20, 300, 50);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 16));

        // Set button which restarts the game
        restartButton = new JButton("Спробувати ще раз!");
        restartButton.setBounds(70, 100, 150, 50);
        restartButton.addActionListener(this);
        restartButton.setBackground(new Color(0x2E7D32));
        restartButton.setForeground(Color.WHITE);
        restartButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Set button which exits the game
        exitButton = new JButton("Вийти з гри");
        exitButton.setBounds(220, 100, 150, 50);
        exitButton.addActionListener(this);
        exitButton.setBackground(new Color(0xD32F2F));
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Set and setting Frame
        this.setTitle("Ви програли");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(500, 200);

        // Place the frame in the middle
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(
                dim.width / 2 - this.getSize().width / 2,
                dim.height / 2 - this.getSize().height / 2
        );
        this.getContentPane().setBackground(new Color(0x212121));
        this.add(label);
        this.add(restartButton);
        this.add(exitButton);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button actions here
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoseFrame();
        });
    }
}
