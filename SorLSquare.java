package snakesandladders;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Aashna Narang
 */
public class SorLSquare extends SnLSquare {

    //Instance variables
    private int endSquare;

    /**
     * Constructor method to create an instance of this class. Uses constructor
     * from parent class to instantiate the instance variable called "number"
     *
     * @param number represents the board square number
     * @param endSquare represents the square they will land on
     */
    public SorLSquare(int number, int endSquare) {
        super(number);
        if (number == endSquare) {
            throw new IllegalArgumentException("number and endSquare can't be same");
        }
        this.endSquare = endSquare;
    }

    /**
     * Public getter method to return the square the player will land on
     *
     * @return endSquare (instance variable)
     */
    public int getEndSquare() {
        return this.endSquare;
    }

    /**
     * Public method that tells user what square they will land on.
     *
     * @return endSquare, instance variable
     */
    @Override
    public int landOn() {
        return this.getEndSquare();
    }

    /**
     * Convert the boardSquare number and endSquare to a string.
     *
     * @return a string in the form of: CurrentSquareNumber:EndSquare
     */
    public String toString() {
        return super.getNumber() + ":" + this.endSquare;
    }

    /**
     * Checks if two objects are equivalent, so its instance variables are equal
     * First checks if argument refers to same object already, checks if object
     * points to nothing, and check if they're from the same class. If not then
     * the object is converted to the same type and then checks if instance
     * variables are equal.
     *
     * @param o represents any object of any type
     * @return true if they are equivalent or false if not
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
        SorLSquare copy = (SorLSquare) o;
        return (super.getNumber() == copy.getNumber()
                && this.endSquare == copy.endSquare);
    }

}
