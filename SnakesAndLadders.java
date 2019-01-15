/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesandladders;

/**
 *
 * @author Aashna Narang
 */
public class SnakesAndLadders {

    //Class variables/constants
    //Assuming NUM_PLAYERS is a default value. A ta named Islam Ibrahim gave these
    //instructions
    public static final int NUM_SQUARES = 100;
    public static final int NUM_PLAYERS = 2;

    //Instance variables
    //board is an array of squares, can be normal, snake squares or ladder squares
    private SnLSquare board[];
    //array to keep track of position for each player
    private int players[];
    //Dice to roll and move players
    private Dice dice;

    /**
     * Default constructor to create a snakes and ladders game for 2 people.
     * Uses the 1 arg constructor to initialize everything
     */
    public SnakesAndLadders() {
        this(NUM_PLAYERS);
    }

    /**
     * 1 Argument constructor to initialize an instance of this class/create a
     * game. Create board pieces that are normal space, snake squares, and
     * ladder squares. Initialize player array length to argument. Make each
     * player start at square 1. Create a dice object (with 2 die that can be
     * rolled)
     *
     * @param nPlayers represents number of players in the game
     */
    public SnakesAndLadders(int nPlayers) {
        if (nPlayers <= 0) {
            throw new IllegalArgumentException("Invalid number of players");
        }
        board = new SnLSquare[NUM_SQUARES];
        for (int i = 0; i < NUM_SQUARES; i++) {
            board[i] = new SnLSquare(i + 1);
        }

        board[3] = new LadderSquare(4, 14);
        board[8] = new LadderSquare(9, 31);
        board[19] = new LadderSquare(20, 38);
        board[27] = new LadderSquare(28, 84);
        board[39] = new LadderSquare(40, 59);
        board[62] = new LadderSquare(63, 81);
        board[70] = new LadderSquare(71, 91);

        board[16] = new SnakeSquare(17, 7);
        board[53] = new SnakeSquare(54, 34);
        board[61] = new SnakeSquare(62, 18);
        board[63] = new SnakeSquare(64, 60);
        board[86] = new SnakeSquare(87, 24);
        board[92] = new SnakeSquare(93, 73);
        board[98] = new SnakeSquare(99, 78);
        this.players = new int[nPlayers];
        for (int i = 0; i < nPlayers; i++) {
            players[i] = 1;
        }
        this.dice = new Dice();
    }

    /**
     * This function takes a turn for the given player. Rolls dice and moves
     * player accordingly, either stay on spot or down snake or up ladder.
     * Function checks if player go over 100th space. If they do, player moves
     * backwards in the amount of excess over 100
     *
     * @param player represents whose turn it is.
     * @return true if they roll doubles, false otherwise
     */
    public boolean takeTurn(int player) {
        int roll = dice.roll();
        int total = getPlayerPosition(player) + roll;
        System.out.println("Player " + player + " rolled " + roll);

        //taking care of excess if you go over 100th square
        if (total > 100) {
            total = 200 - total;
        }
        //setting players new position
        players[player] = board[total - 1].landOn();

        return dice.hasDoubles();
    }

    /**
     * Checks if the given player won or not, so checks if they're on square 100
     *
     * @param player represents the player number that we're checking
     * @return true if they won, otherwise false
     */
    public boolean isPlayerWinner(int player) {
        if (player > this.players.length) {
            throw new IllegalArgumentException("Player doesn't exist");
        }
        return players[player] == 100;
    }

    /**
     * Go through player array and check if any player has reached square 100
     *
     * @return the number of player who won, or -1 if no one won
     */
    public int getWinner() {
        for (int i = 0; i < this.players.length; i++) {
            if (players[i] == 100) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Getter method to tell what space each player is at
     *
     * @param player represents which player we are looking at
     * @return the player's position
     */
    public int getPlayerPosition(int player) {
        if (player < 0 && player > this.players.length) {
            throw new IllegalArgumentException("Invalid player number");
        }
        return players[player];
    }

    /**
     * Produce a string value of the board, 10 squares by 10 squares. Goes
     * through board array, print out the space using each element's toString
     *
     * @return a string of the board game
     */
    @Override
    public String toString() {
        String s = new String();
        for (int j = 0; j < NUM_SQUARES; j++) {
            if (j != 0 && j % 10 == 0) {
                s += "\n";
            }
            s += "| " + board[j].toString();
        }
        return s;
    }

    /**
     * Create a string of each player and what position they are in
     *
     * @return string in the format of player#:position
     */
    public String toStringCurrentPositions() {
        String s = new String();
        for (int i = 0; i < this.players.length; i++) {
            s += i + ":" + players[i] + " ";
        }
        return s;
    }

    /**
     * Print out the board, each player takes their turn, the print current
     * positions. If player rolls doubles, player goes again.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        //Create an object and Print game
        SnakesAndLadders game = new SnakesAndLadders();
        System.out.println("Snakes and Ladders");
        System.out.println(game.toString());
        //PLay game while no one has won
        while (game.getWinner() == -1) {
            for (int i = 0; i < game.players.length; i++) {
                boolean doubleTurn = game.takeTurn(i);
                //Take another turn if you roll doubles 
                while (doubleTurn && game.getWinner() == -1) {
                    System.out.println(game.toStringCurrentPositions());
                    doubleTurn = game.takeTurn(i);
                }
                System.out.println(game.toStringCurrentPositions());
            }
        }
        System.out.println("The winner is Player " + game.getWinner());
    }

}
