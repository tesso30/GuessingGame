import javax.swing.*;

public class GuessingGameForm {
    private JPanel mainPanel;
    private JTextField guessField;
    private JButton guessButton;
    private JLabel resultLabel;
    private JLabel attemptsLabel;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextField getGuessField() {
        return guessField;
    }

    public JButton getGuessButton() {
        return guessButton;
    }

    public JLabel getResultLabel() {
        return resultLabel;
    }

    public JLabel getAttemptsLabel() {
        return attemptsLabel;
    }

}
