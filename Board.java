/**
 * This class represents the game board for the Connect4 game.
 *
 * @author Pax Sharma
 * @since 07/12/22
 */
public class Board {
    /** The game board as a two-dimensional array of characters. */
    private char[][] board;

    /**
     * Creates a new game board with the standard dimensions.
     */
    public Board() {
        setBoard(new char[6][7]);
    }

    /**
     * The printBoard method displays the board array in a tabular form. It checks
     * for the null character, and if the element is not a null character, the
     * method prints the element itself.
     */
    public void printBoard() {
        StringBuilder s = new StringBuilder();
        for (char[] row : getBoard()) {
            for (char boardElement : row) {
                if (boardElement != '\u0000') {
                    s.append("| ").append(boardElement).append(" ");
                } else {
                    s.append("|   ");
                }
            }
            s.append("|" + "\n");
        }
        System.out.println(s);
        System.out.println("  1   2   3   4   5   6   7");
    }

    /**
     * Places a counter with the specified player's mark at the given position on the board.
     *
     * @param position the position at which to place the counter
     * @param playerMark the mark of the player whose counter is being placed
     */
    protected void placeCounter(int position, char playerMark) {
        try {
            boolean placed = false;
            if (isColumnFull(position)) {
                throw new ColumnFullException();
            }
            for (int i = getBoard().length - 1; i >= 0; i--) {
                if (!placed && getBoard()[i][position - 1] == '\u0000') {
                    getBoard()[i][position - 1] = playerMark;
                    placed = true;
                }
            }
        } catch (ColumnFullException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Checks if the given column on the board is full.
     *
     * @param position the column to check
     * @return true if the column is full, false otherwise
     */
    protected boolean isColumnFull(int position) {
        for (char[] row : getBoard()) {
            if (row[position - 1] == '\u0000') {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the current state of the board.
     *
     * @return a 2D array representing the current state of the board
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * Sets the state of the board.
     *
     * @param board a 2D array representing the new state of the board
     */
    public void setBoard(char[][] board) {
        this.board = board;
    }
}
