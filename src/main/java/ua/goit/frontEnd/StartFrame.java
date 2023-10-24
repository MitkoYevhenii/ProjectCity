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
    private final JButton okButton = setupOkButton();
    private final JLabel introductoryLabel = setupIntroductoryLabel();

    public static void getInstance() {}

    private StartFrame() {
        setupFrame();
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

    private static JLabel setupIntroductoryLabel() {
        JLabel label = new JLabel("Вітаємо вас у грі дитинства і всіх розумників!");
        label.setBounds(50, 50, 300, 50);
        label.setForeground(new Color(0xFFFFFF));
        return label;
    }

    private JButton setupOkButton() {
        JButton button = new JButton("ОК!");
        button.setBounds(150, 100, 100, 50);
        button.addActionListener(this);
        button.setBackground(new Color(11, 11, 11));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        return button;
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
