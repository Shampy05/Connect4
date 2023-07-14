import java.util.Random;

/**
 * This class represents a computer player in a game.
 * It implements the Player interface and has methods for making a move and getting the player's mark and name.
 *
 * @author Pax Sharma
 * @since 10/12/2022
 */
public class ComputerPlayer implements Player {
    /** The mark that represents the player on the game board. */
    private final char playerMark;
    /** The name of the player. */
    private final String playerName;
    /** The random number generator. */
    private final Random random;
    /**
     * Creates a new computer player with the given mark and name.
     *
     * @param playerMark the mark that represents the player on the game board
     * @param playerName the name of the player
     */
    public ComputerPlayer(char playerMark, String playerName) {
        this.playerMark = playerMark;
        this.playerName = playerName;
        this.random = new Random();
    }
    /**
     * Gets the mark for the computer player.
     *
     * @return the mark for the computer player
     */
    public char getPlayerMark() {
        return this.playerMark;
    }

    /**
     * Gets the name of the computer player.
     *
     * @return the name of the computer player
     */
    public String getPlayerName() {
        return this.playerName;
    }

    /**
     * Sets the properties for the computer player.
     */
    @Override
    public void setPlayerProperties() {
        // do nothing as the computer properties are already set in the constructor
    }

    /**
     * Returns a message to display when the computer player has won the game.
     */
    @Override
    public void hasWonMessage() {
        System.out.println(getPlayerName() + " wins!");
    }

    /**
     * Makes a move for the computer player.
     *
     * @return a random number between 1 and 7
     */
    @Override
    public int makeMove() {
        // column full protection
        // make sure to remove the hard coding
        System.out.println("Computer chooses...");
        return random.nextInt(UPPER_USER_INPUT_BOUND - 1) + 1;
    }
}
