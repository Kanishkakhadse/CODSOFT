import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int maxRounds = 3;
        int maxAttempts = 5;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have " + maxRounds + " rounds to guess the number.");
        
        for (int round = 1; round <= maxRounds; round++) {
            int number = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 0;
            boolean correctGuess = false;
            
            System.out.println("\nRound " + round + ":");
            System.out.println("Guess the number between 1 and 100:");
            
            while (attempts < maxAttempts && !correctGuess) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess == number) {
                    System.out.println("Correct! You've guessed the number.");
                    score += (maxAttempts - attempts + 1); // Higher score for fewer attempts
                    correctGuess = true;
                } else if (guess > number) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }
            }
            
            if (!correctGuess) {
                System.out.println("You've used all attempts! The number was: " + number);
            }
        }
        
        System.out.println("\nGame Over! Your total score is: " + score);
        scanner.close();
    }
}