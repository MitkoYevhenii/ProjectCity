package ua.goit.FrontEnd;

import lombok.*;
import ua.goit.BackEnd.DataGame;
import ua.goit.BackEnd.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Map;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
public class GameFrame extends JFrame implements ActionListener {
    private final static GameFrame gameFrame = new GameFrame();
    private final JButton makeMoveButton;
    private final JTextField cityTextField;
    private final JLabel answerLabel;
    private String answer;
    private DataGame game = DataGame.getInstance();

    private GameFrame() {

        // Set makeMoveButton
        makeMoveButton = new JButton("Зробити хід");
        makeMoveButton.addActionListener(this);
        makeMoveButton.setPreferredSize(new Dimension(150, 40));

        // Set cityTextField
        cityTextField = new JTextField();
        cityTextField.setPreferredSize(new Dimension(200, 30));


        // Set makeMoveLabel
        JLabel makeMoveLabel = new JLabel("Введіть назву міста");
        makeMoveLabel.setForeground(new Color(0xFFFFFF));

        //Set answerLabel
        answerLabel = new JLabel("Комп'ютер: " + answer);
        answerLabel.setForeground(new Color(0xFFFFFF));


        // Set and setting using setLayout
        this.setTitle("Міста");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setResizable(true);
        this.setLayout(new GridLayout(2, 2, 20, 20));

        // Center the frame on the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(
                dim.width/2-this.getSize().width/2,
                dim.height/2-this.getSize().height/2
        );
        // Set the background color
        this.getContentPane().setBackground(new Color(0x373737));

        // Add components to the panel
        this.add(cityTextField);
        this.add(makeMoveLabel);
        this.add(makeMoveButton);
        this.add(answerLabel);
    }

    public static GameFrame getInstance() {
        return gameFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == makeMoveButton) {
            boolean loseBoolean = cityTextField.getText().equalsIgnoreCase("сдаюсь")
                    || cityTextField.getText().equalsIgnoreCase("здаюсь");

            if (loseBoolean) {
                EndFrame endFrame = new EndFrame();
                setVisible(false);
                endFrame.setVisible(true);
            } else if (game.getScore() == 0) {
                answer = Player.firstTurn(cityTextField.getText().toUpperCase(), game);
            } else {
                answer = Player.turn(cityTextField.getText().toUpperCase(), game);
            }
            answerLabel.setText("Комп'ютер: " + answer);
        }
    }
}
