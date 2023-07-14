import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class representing a human player in a game of Connect4.
 * This class implements the {@link Player} interface and provides implementations for the
 * {@link Player#makeMove()}, {@link Player#setPlayerProperties}, {@link Player#getPlayerMark()},
 * and {@link Player#getPlayerName()} methods. It also provides a method to get user's input,
 * validate the user's input, and printing a winning message.
 *
 * @author Pax Sharma
 * @since 10/12/2022
 */
public class HumanPlayer implements Player {
    /** The mark that represents the player on the game board. */
    private char playerMark;
    /** The name of the player. */
    private String playerName;
    /** The buffered reader to read input from the user. */
    private BufferedReader userInputReader;

    /**
     * Creates a new human player with the given mark, name, and initialises the buffered reader.
     *
     * @param playerMark the mark that represents the player on the game board
     * @param playerName the name of the player
     */
    public HumanPlayer(char playerMark, String playerName) {
        /*
         * Initialise BufferedReader only once for a single instance of HumanPlayer
         * object
         */
        try {
            userInputReader = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.playerMark = playerMark;
        this.playerName = playerName;
    }

    /**
     * Gets the mark of this player.
     *
     * @return the mark of this player
     */
    public char getPlayerMark() {
        return playerMark;
    }

    /**
     * Gets the name of this player.
     *
     * @return the name of this player
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Sets the name and mark of this player.
     */
    @Override
    public void setPlayerProperties() {
        changeMark();
        changeName();
    }

    /**
     * Makes a move for this player.
     * This method prompts the user for input and returns the position integer.
     *
     * @return the user's input
     */
    @Override
    public int makeMove() {
        int userInput = 0;
        try {
            System.out.println(this.playerName + ", please enter an input (enter quit to exit): ");
            userInput = validateUserInput(Integer.parseInt(getUserInput()));
        } catch (RuntimeException e) {
            System.out.println("Something went wrong. Please try again.");
            this.makeMove();
        }
        return userInput;

    }

    /**
     * Gets the user's input for their next move.
     * This method prompts the user for input and returns their choice.
     *
     * @return the user's input
     * @throws RuntimeException if the user's input is invalid
     */
    private String getUserInput() throws RuntimeException {
        // get an input from the user between 1 and 7
        String userResponse = null;
        try {
            userResponse = userInputReader.readLine();
            if (userResponse.equals("quit")) {
                System.exit(0);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return userResponse;
    }

    /**
     * Validates the user's input for their next move.
     * This method checks if the user's input is a valid column number on the board.
     *
     * @param userInput the user's input to validate
     * @throws RuntimeException if the user's input is invalid
     */
    private int validateUserInput(int userInput) throws RuntimeException {
        try {
            while (userInput < LOWER_USER_INPUT_BOUND || userInput > UPPER_USER_INPUT_BOUND) {
                System.out.println("Please enter a valid input between 1 and 7: ");
                userInput = Integer.parseInt(getUserInput());
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return userInput;
    }

    /**
     * Changes the mark of this player.
     * This method allows the user to change the mark (any key on their keyboard) that represents
     * this player on the game board.
     */
    private void changeMark() {
        System.out.println("Please press a key on your keyboard to choose your marker (press enter to keep default 'r'): ");
        try {
            String userInput = getUserInput();
            if (userInput.length() < 1) {
                return;
            }
            setPlayerMark(userInput.charAt(0));
        } catch (RuntimeException e) {
            System.out.println("Something went wrong. Please try again.");
            this.changeMark();
        }
        System.out.println("Player marker " + this.playerMark + " changed successfully.");
    }

    /**
     * Changes the name of this player.
     * This method allows the user to change the name of this player.
     */
    private void changeName() {
        System.out.println("Please enter your name (press enter to keep default \"Human\"): ");
        try {
            String newName = getUserInput();
            if (newName.equals("")) {
                return;
            }
            setPlayerName(newName);
        } catch (RuntimeException e) {
            System.out.println("Something went wrong. Please try again.");
            this.changeName();
        }
        System.out.println("Player name " + this.getPlayerName() + " changed successfully.");
    }

    /**
     * Sets the mark of this player.
     *
     * @param playerMark the new mark of this player
     */
    private void setPlayerMark(char playerMark) {
        this.playerMark = playerMark;
    }

    /**
     * Sets the name of this player.
     *
     * @param playerName the new name of this player
     */
    private void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Returns a message to display when the human player has won the game.
     */
    public void hasWonMessage() {
        System.out.println("Congratulations " + getPlayerName() + "! You win.");
    }
}
