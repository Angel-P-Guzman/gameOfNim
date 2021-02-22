import java.util.*;

public class Player {
    private String name;
    private int score;

    public Player() { // makes a player and asks for an input for the name
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a player name: ");
        name = sc.nextLine();
        score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void increment(int add) {
        score += add;
    }
}
