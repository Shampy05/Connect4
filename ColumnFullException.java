/**
 * This exception is thrown when a player attempts to make a move in a full column.
 *
 * @author Pax Sharma
 * @since 12/12/2022
 */
public class ColumnFullException extends Exception {
    /**
     * Creates a new column full exception with the given message.
     */
    public ColumnFullException () {
        super("The column is full.");
    }
}