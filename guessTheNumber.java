import java.util.InputMismatchException;
import java.util.Scanner;

public class guessTheNumber {
    public static void main(String[] args){
        boolean running = true;
        Scanner userInput = new Scanner(System.in);
        guesserGame game1 = new guesserGame();
        convertDifficulty diffConverter = new convertDifficulty();

        while (running){
            System.out.print("Do you want to start the game? (y/n) ");
            String userAnswer = userInput.nextLine().toLowerCase();
            System.out.print("What difficulty do you want to play? (easy, medium, hard) ");
            String difficulty_word = userInput.nextLine().toLowerCase();
            int difficulty_factor = diffConverter.convertDiffPlease(difficulty_word);

            if (userAnswer.equals("n") || !userAnswer.equals("y")) { //TODO terminate game if difficulty is not valid
                running = false;
                System.out.println("FUCK YOU! :)");
            } else {
                game1.startGame(difficulty_factor);
            }
        }
    }
}

class guesserGame {
    guesserGame(){
        this.gameName = "Number Guesser";
        this.scanner = new Scanner(System.in);
    }

    private Scanner scanner;
    private String gameName;
    private int pcNum;
    private int userNum;
    private String displayText = "Welcome to Number guesser!";
    int difficulty_factor;

    public void startGame(int difficulty_factor){

        this.pcNum = (int) (Math.random() * difficulty_factor + 1);
        System.out.println(this.displayText);
        System.out.println(this.gameName);
        System.out.print("Enter a number between 1 and " + difficulty_factor + " : ");

        try {
            this.userNum = this.scanner.nextInt();
            if (this.pcNum == this.userNum) {
                System.out.println("You win!");
                System.out.println("PC guessed: " + this.pcNum);
            } else {
                System.out.println("Better Luck next time!");
                System.out.println("PC guessed: " + this.pcNum);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number!");
        }
    }

}

class convertDifficulty {
    String difficulty;
    int difficulty_factor;
    public int convertDiffPlease(String difficulty){
        if (difficulty.equals("easy")) {
            difficulty_factor = 10;
        } else if (difficulty.equals("medium")) {
            difficulty_factor = 50;
        } else if (difficulty.equals("hard")) {
            difficulty_factor = 100;
        } else {

            System.out.println("Fuck you for not choosing a valid diff!");
        }
        return difficulty_factor;
    }
}
