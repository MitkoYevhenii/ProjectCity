package ua.goit.frontEnd;

import lombok.*;
import ua.goit.backEnd.DataGame;
import ua.goit.backEnd.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@EqualsAndHashCode(callSuper = true)
@Data
public class GameFrame extends JFrame implements ActionListener {
    private final static GameFrame gameFrame = new GameFrame();
    private final static DataGame game = DataGame.getInstance();
    private String picturePath = "src/main/java/ua/goit/Resources/logo.png";
    private JButton makeMoveButton;
    private static JTextField cityTextField;
    private JLabel makeMoveLabel;
    private static JLabel answerLabel;
    private String answer;

    public static GameFrame getInstance() {
        return gameFrame;
    }

    public static GameFrame getInstanceAgain() {
        answerLabel.setText("Комп'ютер очікує вводу першого слова");
        cityTextField.setText("");
        game.reset();
        return gameFrame;
    }

    private GameFrame() {
        setupFrame();
        setupCityTextField();      // Initialize cityTextField
        setupMakeMoveLabel();      // Initialize makeMoveLabel
        setupMakeMoveButton();     // Initialize makeMoveButton
        setupAnswerLabel();        // Initialize answerLabel
        setupComponents();         // Add the components to the frame
        setVisible(true);
    }

    private void setupFrame() {
        //Set icon icon
        ImageIcon icon = new ImageIcon(picturePath);
        this.setIconImage(icon.getImage());

        // Set and setting using setLayout
        this.setTitle("Міста");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
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
    }

    private void setupComponents() {
        this.add(cityTextField);
        this.add(makeMoveLabel);
        this.add(makeMoveButton);
        this.add(answerLabel);
    }

    private void setupMakeMoveButton() {
        makeMoveButton = new JButton("Зробити хід");
        makeMoveButton.addActionListener(this);
        makeMoveButton.setPreferredSize(new Dimension(150, 40));
    }

    private void setupCityTextField() {
        cityTextField = new JTextField();
        cityTextField.setPreferredSize(new Dimension(250, 30));
    }

    private void setupMakeMoveLabel() {
        makeMoveLabel = new JLabel("Введіть назву міста");
        makeMoveLabel.setForeground(new Color(0xFFFFFF));
    }

    private void setupAnswerLabel(){
        answerLabel = new JLabel("Комп'ютер очікує вводу першого слова");
        answerLabel.setForeground(new Color(0xFFFFFF));
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == makeMoveButton) {
            String enteredWord = cityTextField.getText().toUpperCase();

            //if already lose or win
            if (enteredWord.equals("СДАЮСЬ") || enteredWord.equals("ЗДАЮСЬ") || game.isFinish()) {
                boolean isWinner = game.getLastSymbol().equals("finish");

                EndFrame endFrame = EndFrame.getInstance(isWinner);
                this.dispose();
                endFrame.setVisible(true);

            }

            answer = Player.playerTurn(enteredWord, game);
            answerLabel.setText("Комп'ютер: " + answer);
        }
    }
}
