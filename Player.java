/**
 * The `Player` interface represents a player in a game.
 * It defines methods for making a move, getting the player's mark, getting the player's name and setting the player's properties.
 *
 * @author Pax Sharma
 * @since 09/12/2022
 */
public interface Player {
    /** The upper bound for a valid user input. */
    int UPPER_USER_INPUT_BOUND = 7;
    /** The lower bound for a valid user input. */
    int LOWER_USER_INPUT_BOUND = 1;
    /**
     * Make a move on the board.
     *
     * @return the column where the player's piece was placed on the game board
     */
    int makeMove();
    /**
     * Get the player's mark as a string.
     *
     * @return the player's mark as a string
     */
    char getPlayerMark();
    /**
     * Get the player's name as a string.
     *
     * @return the player's name as a string
     */
    String getPlayerName();
    /**
     * Set the player's properties, such as their name and mark.
     */
    void setPlayerProperties();
    /**
     * Returns a message to display when the player has won the game.
     */
    void hasWonMessage();
}
