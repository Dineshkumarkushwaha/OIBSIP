import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int rounds = 0;

        System.out.println("Welcome to Guess the Number!");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + (rounds + 1));
            System.out.println("I have chosen a number between 1 and 100. Can you guess it?");

            while (!guessedCorrectly && attempts < 10) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempt(s)!");
                    score += 10 - attempts;
                    guessedCorrectly = true;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you couldn't guess the number. The correct number was: " + targetNumber);
            }

            rounds++;

            System.out.print("\nDo you want to play again? (y/n): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("y");
        }

        System.out.println("\nGame over!");
        System.out.println("Rounds played: " + rounds);
        System.out.println("Final score: " + score);
    }
}
