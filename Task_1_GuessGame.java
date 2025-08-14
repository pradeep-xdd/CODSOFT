import java.util.Random;
import java.util.Scanner;

public class Task_1_GuessGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        
        int low = 1,high=100;
        int maxAttempts = 7;
        int score = 0;
        int round = 1;
        
        System.out.println("Welcome to the Number Guessing Game!\n");
        boolean playAgain = true;
        
        while (playAgain) {
            int targetNumber = r.nextInt(high)+1;
            System.out.print("Round "+round);
            round++;
            System.out.println(" - Range 1 To 100");
            System.out.println("You have " + maxAttempts + " attempts.\n");
            
            int attempts = 0;
            boolean correctguess = false;
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                
                attempts++;
                
                if (userGuess == targetNumber) {
                    System.out.printf("Correct! You guessed the number in %d attempts.\n", attempts);
                    score += attempts;
                    correctguess = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.\n");
                } else {
                    System.out.println("Too high! Try again.\n");
                }
            }
            
            if (!correctguess) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + targetNumber);
            }
            
            System.out.println("Your current score: " + score + "\n");
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgainResponse = sc.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }
        
        System.out.println("Thank you for playing! Your final score: " + score);
    }
}
