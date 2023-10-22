package ua.goit.FrontEnd;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ua.goit.BackEnd.DataGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

@EqualsAndHashCode(callSuper = true)
@Data
public class EndFrame extends JFrame implements ActionListener {
    private static EndFrame endFrame;
    private final JButton restartButton;
    private final JButton exitButton;
    private JLabel label;
    private boolean isWin;

    public EndFrame(boolean isWin) {
        this.isWin = isWin;

        // Set introductory text
        if (isWin) {
            label = new JLabel("Ви виграли, хочете спробувати ще раз?");
            label.setForeground(Color.GREEN);
        } else {
            label = new JLabel("Ви програли, хочете спробувати ще раз?");
            label.setForeground(Color.RED);
        }
        label.setBounds(50, 20, 300, 50);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 16));

        // Set button which restarts the gameProcess
        restartButton = new JButton("Restart!");
        restartButton.setBounds(70, 100, 150, 50);
        restartButton.addActionListener(this);
        restartButton.setBackground(new Color(0x2E7D32));
        restartButton.setForeground(Color.WHITE);
        restartButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Set button which exits the gameProcess
        exitButton = new JButton("Exit");
        exitButton.setBounds(220, 100, 150, 50);
        exitButton.addActionListener(this);
        exitButton.setBackground(new Color(0xD32F2F));
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));

        ImageIcon icon = new ImageIcon("src/main/java/ua/goit/Resources/logo.png");
        this.setIconImage(icon.getImage());

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

    public static EndFrame getInstance(boolean isWin) {
        if (endFrame == null) {
            endFrame = new EndFrame(isWin);
        } else {
            endFrame.isWin = isWin;
            endFrame.updateLabels();
        }

        endFrame.isWin = isWin;
        return endFrame;
    }

    private void updateLabels() {
        if (isWin) {
            label.setText("Ви виграли, хочете спробувати ще раз?");
            label.setForeground(Color.GREEN);
        } else {
            label.setText("Ви програли, хочете спробувати ще раз?");
            label.setForeground(Color.RED);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == restartButton) {
            GameFrame gameFrame = GameFrame.getInstanceAgain();
            this.dispose();
            gameFrame.setVisible(true);
        }

        if (e.getSource() == exitButton) {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
    }
}
