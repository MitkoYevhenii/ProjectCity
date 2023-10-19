package ua.goit.FrontEnd;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@EqualsAndHashCode(callSuper = true)
@Data
public class StartFrame extends JFrame implements ActionListener {
    private final JButton button;

    public StartFrame() {

        //Set introductory text
        JLabel label = new JLabel("Вітаємо вас у грі дитинства і всіх розумників!");
        label.setBounds(50, 50, 300, 50);
        label.setForeground(new Color(0xFFFFFF));

        //Set button which starts the game
        button = new JButton("ОК!");
        button.setBounds(150, 100, 100, 50);
        button.addActionListener(this);
        button.setBackground(new Color(11, 11, 11));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);

        //Set icon icon
        ImageIcon icon = new ImageIcon("src/main/java/ua/goit/FrontEnd/logo.png");
        this.setIconImage(icon.getImage());

        //Set and setting Frame
        this.setTitle("Вітаємо");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(400, 250);

        //Place the frame in the middle
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(
                dim.width/2-this.getSize().width/2,
                dim.height/2-this.getSize().height/2
        );
        this.getContentPane().setBackground(new Color(0x373737));
        this.add(label);
        this.add(button);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("You pressed the button");
            GameFrame gameFrame = new GameFrame();
            setVisible(false);
            gameFrame.setVisible(true);
        }
    }
}
