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
public class SnLSquare {

    //Instance Variables
    private int number;

    /**
     * Constructor method for SnLSquare Class
     *
     * @param number represents the number of the square on the board.
     */
    public SnLSquare(int number) {
        this.number = number;
    }

    /**
     * Public getter method that returns the number instance variable of your
     * object
     *
     * @return the value of the number instance variable
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Public function that tells users what square they have landed on. Since
     * there are no snakes or ladders on this type of square, the square they
     * landed on is not different from getNumber
     *
     * @return the square the player is currently on using getNumber
     */
    public int landOn() {
        return this.getNumber();
    }

    /**
     * Converts board square number to a string
     *
     * @return string of number value
     */
    @Override
    public String toString() {
        return this.number + "";
    }

    /**
     * Checks if given object is equivalent to this object.First checks if
     * refers to same object, object refers to nothing, and if they are the same
     * class. Overriden from equals method java has already because we want to
     * make sure instance var. are same, not just if they point to same thing If
     * all true then the object is converted to the same type and then checks if
     * instance variables are equal.
     *
     * @param o is any type of object
     * @return true if they are equivalent (instance var are same) or false if
     * not
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        SnLSquare copy = (SnLSquare) o;
        return this.number == copy.number;
    }

}
