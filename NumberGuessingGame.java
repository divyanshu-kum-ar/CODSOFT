import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int number = random.nextInt(100) + 1; // Generate random number (1-100)
            int maxAttempts = 10;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts. Good luck!");

            // Loop until user guesses correctly or runs out of attempts
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Your guess? ");
                int guess;

                // Handle invalid input
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }

                attempts++;

                // Compare guess with the generated number
                if (guess < number) {
                    System.out.println("Too low!");
                } else if (guess > number) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number " + number + " in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalScore += maxAttempts - attempts + 1; // Score based on remaining attempts
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + number + ".");
            }

            System.out.println("Your current score: " + totalScore);

            //  Ask if the user wants to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nThanks for playing! Your final score: " + totalScore);
        scanner.close();
    }
}
