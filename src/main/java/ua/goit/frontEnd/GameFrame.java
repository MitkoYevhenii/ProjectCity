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
        answerLabel.setText("<html>" + "Комп'ютер очікує вводу першого слова" + "</html>");
        cityTextField.setText("");
        game.reset();
        return gameFrame;
    }

    private GameFrame() {
        setupFrame();
        setupCityTextField();
        setupMakeMoveLabel();
        setupMakeMoveButton();
        setupAnswerLabel();
        setupComponents();
        setVisible(true);
    }

    private void setupFrame() {

        //Set icon icon
        ImageIcon icon = new ImageIcon(picturePath);
        this.setIconImage(icon.getImage());

        // Set and setting using setLayout
        this.setTitle("Міста");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 150);
        this.setResizable(false);
        this.setLayout(new GridLayout(2, 2, 10, 5));

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
        makeMoveButton.setBackground(new Color(51, 153, 255)); // Например, синий цвет
        makeMoveButton.setForeground(Color.WHITE); // Белый цвет
        makeMoveButton.setFont(new Font("Arial", Font.BOLD, 16)); // Пример шрифта
        makeMoveButton.setMargin(new Insets(10, 20, 10, 20));
        makeMoveButton.addActionListener(this);
        Dimension maxButtonSize = new Dimension(150, Integer.MAX_VALUE); // Установите максимальную ширину
        makeMoveButton.setMaximumSize(maxButtonSize);
    }


    private void setupCityTextField() {
        cityTextField = new JTextField();
        cityTextField.setBackground(new Color(240, 240, 240)); // Например, светло-серый цвет
        cityTextField.setForeground(Color.BLACK); // Черный цвет
        cityTextField.setFont(new Font("Arial", Font.PLAIN, 14)); // Пример шрифта и размера
        cityTextField.setMargin(new Insets(5, 5, 5, 5));
        cityTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Серая рамка
        Dimension maxTextFieldSize = new Dimension(250, Integer.MAX_VALUE); // Установите максимальную ширину
        cityTextField.setMaximumSize(maxTextFieldSize);
    }


    private void setupMakeMoveLabel() {
        makeMoveLabel = new JLabel("Введіть назву міста");
        makeMoveLabel.setForeground(new Color(0xFFFFFF));
    }

    private void setupAnswerLabel(){
        answerLabel = new JLabel("<html>" + "Комп'ютер очікує вводу першого слова"  + "</html>");
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
            answerLabel.setText("<html>" + "Комп'ютер: " + answer + "</html>");
        }
    }
}
