import java.util.Random;
import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int maxAttempts = 5;
        int attempts = 0;
        int score = 50;
        boolean hasWon = false;


        JOptionPane.showMessageDialog(null, "Welcome to the Number Guessing Game!\n" + "-> In this game you have to guess a number between 1 to 100. \n-> You will have maximum 5 attempts to guess the number. \n-> The player's score is initially set to 50, and for each incorrect guess, 10 points are deducted.", "Number Guessing Game", JOptionPane.INFORMATION_MESSAGE);


        int randomNumber = random.nextInt(100) + 1;
        System.out.println(randomNumber);

            while (!hasWon && attempts < maxAttempts) {
                String input = JOptionPane.showInputDialog(null, "Enter your guess :", "Number Guessing Game", JOptionPane.QUESTION_MESSAGE);
                if (input != null) {
                int guess = Integer.parseInt(input);
                attempts++;

                if (guess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Enter higher number ! \nyou have "+(5-attempts)+" attempts left.", "Number Guessing Game", JOptionPane.WARNING_MESSAGE);
                } else if (guess > randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too high! Enter lower number ! \nyou have "+(5-attempts)+" attempts left.", "Number Guessing Game", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog( null, "Congratulations! You guessed the number in " + attempts + " attempts.\nYour score is: " + score+ "/50", "Number Guessing Game", JOptionPane.INFORMATION_MESSAGE);
                    hasWon = true;
                }
                score -= 10;
                } else {
                    System.out.println("No input provided.");
                    break;
                }
            }

            if (!hasWon) {
                JOptionPane.showMessageDialog(null, "Oops! You've reached the maximum " + maxAttempts + " attempts " + ".\nThe number was : " + randomNumber +"\nBetter luck next time!\nYour score is : 0", "Number Guessing Game", JOptionPane.WARNING_MESSAGE);
            }

    }
}