package snakesandladders;

/**
 *
 * @author Aashna Narang
 */
public class SnakeSquare extends SorLSquare {

    /**
     * Constructor to create an instance of this class by uses constructor from
     * SorLSquare class. Checks if endsquare is lower than initial
     *
     * @param number represents the number of the board square player landed on
     * @param endSquare the square player will end at after going down the snake
     */
    public SnakeSquare(int number, int endSquare) {
        super(number, endSquare);
        if (endSquare >= number) {
            throw new IllegalArgumentException("endsquare invalid");
        }
    }

    /**
     * Returns the square they will land on after going down snake by using the
     * superclass' getter method.
     *
     * @returns the number of the square they land on
     */
    
    @Override
    public int landOn() {
        System.out.println("Oh no! You landed on a snake");
        return super.getEndSquare();
    }

    /**
     * Creates a string value for the square with a snake. Includes start square
     * then "-" endsquare.
     *
     * @return
     */
    @Override
    public String toString() {
        return super.getNumber() + "-" + this.getEndSquare();
    }

    /**
     * Do not need to override because this function is equivalent to the equals
     * in the SorLSquare class since no new instance variables were introduced
     * So doesn't need an equals method
     */


}
