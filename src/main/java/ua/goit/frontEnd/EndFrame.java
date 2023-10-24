package ua.goit.frontEnd;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

@EqualsAndHashCode(callSuper = true)
@Data
public class EndFrame extends JFrame implements ActionListener {
    private static EndFrame endFrame;
    private JButton restartButton;
    private JButton exitButton;
    private JLabel finalGameLabel;
    private boolean isWin;
    private String picturePath = "src/main/java/ua/goit/Resources/logo.png";


    private EndFrame(boolean isWin) {
        this.isWin = isWin;
        isWinCheck();
        setupFrame();
        setupLabelFinalGame();
        setupRestartButton();
        setupExitButton();
        setupComponents();

        this.setVisible(true);
    }

    private void setupFrame() {
        ImageIcon icon = new ImageIcon(picturePath);
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
    }

    private void setupComponents() {
        this.add(finalGameLabel);
        this.add(restartButton);
        this.add(exitButton);
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
            finalGameLabel.setText("Ви виграли, хочете спробувати ще раз?");
            finalGameLabel.setForeground(Color.GREEN);
        } else {
            finalGameLabel.setText("Ви програли, хочете спробувати ще раз?");
            finalGameLabel.setForeground(Color.RED);
        }
    }

    private void isWinCheck() {
        if (isWin) {
            finalGameLabel = new JLabel("Ви виграли, хочете спробувати ще раз?");
            finalGameLabel.setForeground(Color.GREEN);
        } else {
            finalGameLabel = new JLabel("Ви програли, хочете спробувати ще раз?");
            finalGameLabel.setForeground(Color.RED);
        }
    }

    private void setupRestartButton() {
        restartButton = new JButton("Restart!");
        restartButton.setBounds(70, 100, 150, 50);
        restartButton.addActionListener(this);
        restartButton.setBackground(new Color(0x2E7D32));
        restartButton.setForeground(Color.WHITE);
        restartButton.setFont(new Font("Arial", Font.BOLD, 14));
    }

    private void setupExitButton() {
        exitButton = new JButton("Exit");
        exitButton.setBounds(220, 100, 150, 50);
        exitButton.addActionListener(this);
        exitButton.setBackground(new Color(0xD32F2F));
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));
    }

    private void setupLabelFinalGame() {
        finalGameLabel.setBounds(50, 20, 300, 50);
        finalGameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        finalGameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
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
