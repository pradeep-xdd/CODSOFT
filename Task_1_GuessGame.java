import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        
        int low = 1, high = 100, maxGuesses = 5;
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
                    System.out.println(" Low Guess! The Number Is Higher");
                } else {
                    System.out.println("High Guess! The Number Is Lower");
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
        
        System.out.println("\nFinal stats:");
        System.out.println("Games: " + gamesPlayed + ", Won: " + wins);
        if (gamesPlayed > 0) {
            System.out.println("Win rate: " + (wins * 100 / gamesPlayed) + "%");
        }
        
        sc.close();
    }
}
