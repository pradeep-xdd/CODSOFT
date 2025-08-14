import java.util.Random;
import java.util.Scanner;

public class Task_1_GuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        
        int low = 1, high = 100, maxGuesses = 8;
        int gamesPlayed = 0, wins = 0, totalGuesses = 0;
        String choice = "y";
        
        System.out.println("Number Guessing Game");
        System.out.println("Guess the number between " + low + " and " + high);
        
        while (choice.equals("y")) {
            int number = r.nextInt(high) + 1;
            int guesses = 0;
            boolean correct = false;
            gamesPlayed++;
            
            System.out.println("\nGame " + gamesPlayed + " - I've picked a number!");
            
            while (guesses < maxGuesses && !correct) {
                System.out.print("Your guess: ");
                int guess = sc.nextInt();
                guesses++;
                
                if (guess == number) {
                    System.out.println("Right! Got it in " + guesses + " tries");
                    correct = true;
                    wins++;
                    totalGuesses += guesses;
                } else if (guess < number) {
                    System.out.println("Guess Higher");
                } else {
                    System.out.println(" Guess Lower");
                }
                
                if (!correct && guesses < maxGuesses) {
                    System.out.println("Tries left: " + (maxGuesses - guesses));
                }
            }
            
            if (!correct) {
                System.out.println("No more tries! It was " + number);
            }
            
            System.out.println("Score: " + wins + "/" + gamesPlayed);
            if (wins > 0) {
                System.out.println("Avg guesses: " + (totalGuesses / wins));
            }
            
            System.out.print("Play again? (y/n): ");
            choice = sc.next();
        }
        
    }
}
