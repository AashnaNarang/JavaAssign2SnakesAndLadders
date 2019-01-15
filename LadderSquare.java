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
public class LadderSquare extends SorLSquare {

    /**
     * Constructor to create squares on boards with ladders. Uses constructor
     * from super class and checks if endsquare is higher than starting square.
     *
     * @param number represents the actual board square player lands on
     * @param endSquare represents the square they will end at after going up
     * ladder
     */
    public LadderSquare(int number, int endSquare) {
        super(number, endSquare);
        if (endSquare <= number) {
            throw new IllegalArgumentException("endsquare invalid");
        }
    }

    /**
     * Method to return the square they will land on by called superclass'
     * getter method
     *
     * @return number of square they will land on after going up the ladder
     */
    @Override
    public int landOn() {
        System.out.println("Ayee congrats, you landed on a ladder");
        return super.getEndSquare();
    }

    /**
     * Converts number and end square to a string to put on board.
     *
     * @return a string with the starting square + end square
     */
    public String toString() {
        return super.getNumber() + "+" + super.getEndSquare();
    }

    /**
     * Do not need to override because this function is equivalent to the equals
     * in the SorLSquare class since no new instance variables were introduced
     */


}
