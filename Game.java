import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;

    private Boolean playAgain;

    public Game() {
        player1 = new Player();
        player2 = new Player();
    }

    public void play() {

        Scanner sc = new Scanner(System.in);
        System.out.println(
                "Two players take turns taking pieces off the pile. A player can't take more than half the avalible pieces. The last player to take a piece loses.");
        Boolean play = true;
        playAgain = false;

        Random rand = new Random();
        int currentPlayer = 1;
        String lastPlayer = "";
        if (rand.nextBoolean()) {
            currentPlayer = 2;
        }
        while (play) {
            System.out.println("There are " + Board.getNumPieces() + " pieces.");
            System.out.println("");

            if (currentPlayer == 1) {
                System.out.println(player1.getName() + " pick a valid number: ");
                int input = sc.nextInt();
                if (validNum(input)) { // if the input is valid then it will remove the number of pieces from the board
                                       // according to the input.

                    Board.removePieces(input);
                    player1.increment(input);
                    lastPlayer = player1.getName();
                    currentPlayer = 2;

                } else { // if the input is not valid then it will run again and ask for a valid input.
                    System.out.println("This input is not valid. Please try again.");
                }

            } else if (currentPlayer == 2) { // does the same thing for player2
                System.out.println(player2.getName() + " pick a valid number: ");
                int input = sc.nextInt();
                if (validNum(input)) { // if the input is valid then it will remove the number of pieces from the board
                                       // according to the input.
                    Board.removePieces(input);
                    player2.increment(input);
                    lastPlayer = player2.getName();
                    currentPlayer = 1;
                } else { // if the input is not valid then it will run again and ask for a valid input.
                    System.out.println("This input is not valid. Please try again.");
                }
            }
            // After there are no more moves left the score and winner will be printed. Then
            // it will ask the players if they want to play again.
            if (Board.getNumPieces() <= 1) {
                System.out.println('\n' + "Winner: " + lastPlayer);
                System.out.println("Score: " + player1.getName() + ": " + player1.getScore());
                System.out.println("Score: " + player2.getName() + ": " + player2.getScore());

                System.out.println("Do you want to play again? (true or false)");
                playAgain = sc.nextBoolean();
                if (playAgain) {
                    Board.populate();
                } else {
                    play = false;
                }
            }
        }
    }

    public boolean validNum(int input) {
        boolean out;
        int half = Board.getNumPieces() / 2;
        if (input <= half && input > 0) {
            out = true;
        } else {
            out = false;
        }
        return out;
    }
}
