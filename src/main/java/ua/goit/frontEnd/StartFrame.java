package ua.goit.frontEnd;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@EqualsAndHashCode(callSuper = true)
@Data
public class StartFrame extends JFrame implements ActionListener {

    private final static StartFrame startFrame = new StartFrame();
    private JButton okButton;
    private JLabel introductoryLabel;

    public static void getInstance() {}

    private StartFrame() {
        setupFrame();
        setupOkButton();
        setupIntroductoryLabel();
        setupComponents();
        this.setVisible(true);
    }

    private void setupFrame() {
        this.setTitle("Вітаємо");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(400, 250);
        this.getContentPane().setBackground(new Color(0x373737));

        ImageIcon icon = new ImageIcon("src/main/java/ua/goit/Resources/logo.png");
        this.setIconImage(icon.getImage());

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

    }

    private void setupComponents() {
        this.add(introductoryLabel);
        this.add(okButton);
    }

    private void setupIntroductoryLabel() {
        introductoryLabel = new JLabel("Вітаємо вас у грі дитинства і всіх розумників!");
        introductoryLabel.setBounds(50, 50, 300, 50);
        introductoryLabel.setForeground(new Color(0xFFFFFF));
    }

    private void setupOkButton() {
        okButton = new JButton("ОК!");
        okButton.setBounds(150, 100, 100, 50);
        okButton.addActionListener(this);
        okButton.setBackground(new Color(11, 11, 11));
        okButton.setBorderPainted(false);
        okButton.setFocusPainted(false);
        okButton.setForeground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            GameFrame gameFrame = GameFrame.getInstance();
            this.dispose();
            gameFrame.setVisible(true);
        }
    }
}
