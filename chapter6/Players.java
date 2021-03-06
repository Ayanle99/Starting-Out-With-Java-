import testPack.Coin;

import java.util.Scanner;


public class Heads_Or_Tails_game {

    /**
     *  This game is meant for two or more players. In this game, the players take turns flipping a
     *  coin. Before the coin is flipped, players should guess if the coin will land headsup or tailsup.
     *  If player guesses correctly, then that player is awarded a point.
     *  If the player guesses incorrectly, the player loses a point.
     *  The first player to score five points is the winner.
     *
     *  Write a program that simulates the game being played by two players. Use the Coin class
     *  that you wrote as an assignment in Chapter 5 ( Programming Challenge 20) to simulate the
     *  coin. Write a Player class to simulate the players.
     *
     */

    public static void main(String[] args) {


        Players players = new Players();
        players.startGame();

    }

}


public class Players {

    static Coin coin = new Coin();
    static Scanner scanner = new Scanner(System.in);
    static int head = 0, tail = 0, points1 = 0, points2 = 0;

    public void startGame(){

        System.out.println("To win this game you should 5 points.");
        System.out.println();

        System.out.println("Player 1 name: ");
        String player1 = scanner.nextLine();

        System.out.println("Player 2 name: ");
        String player2 = scanner.nextLine();

        while (points1 < 5 && points2 < 5){

            System.out.println();

            coin.toss();
            String str = coin.getSideUp();

            if (str.equals("heads")){
                head++;
            }else {
                tail++;
            }

            points1 = getGuess(player1, str, points1);
            points2 = getGuess(player2, str, points2);

        }
        System.out.println();

        System.out.println("Head is up " + head + " times.");
        System.out.println("Tails is up " + tail + " times.");

        if (points1>=5){
            System.out.println(player1 +" got 5 point fiirst. So, you win.");
        }else {
            System.out.println(player2 + " got 5 points frist. You win.");
        }

    }
    public int getGuess(String player, String side, int points){

        char guess;

        System.out.println();

        System.out.println("Enter H or T for " + player);
        guess = scanner.next().charAt(0);

        // validate input
        while (guess != 'H' && guess !=  'h' && guess != 'T' && guess != 't') {

            System.out.println("Error: please enter either H or T for " + player);
            guess = scanner.next().charAt(0);

        }

        boolean headCheck = (guess == 'H' || guess == 'h') && side.equals("heads");
        boolean tailCheck = (guess == 'T' || guess == 't') && side.equals("tails");

        if (headCheck){
            System.out.println("1 point gained for " + player);
            points++;
        }else if (tailCheck){
            System.out.println("1 point gained for " + player);
            points++;
        }else {
            points--;
            System.out.println("1 point lost for " + player);
        }

        if (points < 0){
            points = 0;
        }
        System.out.println();

        System.out.println(player + "'s points are: " + points);


        return points;

    }



}

import java.util.Random;

public class Coin {

    private String sideUp;

    public Coin() {
        toss();
    }

    public void toss() {

        Random rand = new Random();
        int n = rand.nextInt(2);

        if (n == 0)
            sideUp = "heads";
        else
            sideUp = "tails";
    }

    public String getSideUp() {
        return sideUp;
    }

    public void equals(String str) {

        str = getSideUp();
    }

}
