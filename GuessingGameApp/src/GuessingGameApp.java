import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessingGameApp {
    private int numberToGuess;
    private int numberOfAttempts;
    private Random rand;

    public GuessingGameApp() {
        rand = new Random();
        numberToGuess = rand.nextInt(100) + 1;
        numberOfAttempts = 0;
        createGUI();
    }

    private void createGUI() {
        JFrame frame = new JFrame("Guessing Game");

        GuessingGameForm form = new GuessingGameForm();
        frame.setContentPane(form.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 400)); // Set preferred size
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);

        form.getGuessButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(form.getGuessField().getText());
                    numberOfAttempts++;
                    if (guess < numberToGuess) {
                        if (guess + 10 < numberToGuess) {
                            form.getResultLabel().setText("Too low! Try again.");
                        } else {
                            form.getResultLabel().setText("A little bit less! Try again.");
                        }
                    } else if (guess > numberToGuess) {
                        if (guess - 10 > numberToGuess) {
                            form.getResultLabel().setText("Too high! Try again.");
                        } else {
                            form.getResultLabel().setText("A little bit more! Try again.");
                        }
                    } else {
                        form.getResultLabel().setText("Congratulations! You guessed the number!");
                        form.getAttemptsLabel().setText("It took you " + numberOfAttempts + " attempts.");
                    }
                } catch (NumberFormatException ex) {
                    form.getResultLabel().setText("Invalid input. Please enter a number.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuessingGameApp();
            }
        });
    }
}
