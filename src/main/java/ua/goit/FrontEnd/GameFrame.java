package ua.goit.FrontEnd;

import lombok.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public class GameFrame extends JFrame implements ActionListener {
    private JButton makeMoveButton;
    private JTextField cityTextField;
    private String answer;

    public GameFrame() {

        //Set makeMoveButton
        makeMoveButton = new JButton("Зробити хід");
        makeMoveButton.addActionListener(this);

        //Set cityTextField
        cityTextField = new JTextField();

        //Set makeMoveLabel
        JLabel makeMoveLabel = new JLabel("Введіть назву міста");
        makeMoveLabel.setForeground(new Color(0xFFFFFF));

        //Set answerLabel
        JLabel answerLabel = new JLabel("Комп'ютер: " + answer);
        answerLabel.setForeground(new Color(0xFFFFFF));


        //Set and setting using setLayout
        this.setTitle("Міста");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setResizable(true);
        this.setLayout(new GridLayout(2, 2));

        //Set button which starts the game
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(
                dim.width/2-this.getSize().width/2,
                dim.height/2-this.getSize().height/2
        );
        this.getContentPane().setBackground(new Color(0x373737));
        this.add(cityTextField);
        this.add(makeMoveLabel);
        this.add(makeMoveButton);
        this.add(answerLabel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == makeMoveButton) {
            if (Objects.equals(cityTextField.getText(), "Сдаюсь")) {
                System.out.println("Непогана спроба, проте ти програв. " +
                        "Але не слід сумувати, наступного разу ти точно виграєш)))");
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        }
    }
}
