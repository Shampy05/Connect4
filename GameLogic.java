/**
 * This class contains the game logic for the Connect4 game.
 *
 * @author Pax Sharma
 * @since 08/12/22
 */
public class GameLogic {
    /**
     * Check if the specified player has won the game.
     *
     * @param player the player to check for a win
     * @param myBoard the current state of the board
     * @return true if the player has won, false otherwise
     */
    protected static boolean checkWin(Player player, Board myBoard) {
        return checkHorizontal(player, myBoard) || checkVertical(player, myBoard) || checkDiagonal(player, myBoard);
    }

    /**
     * Check if the specified player has won the game by making a diagonal line of four of their pieces on the game board.
     *
     * @param player the player to check for a win
     * @param myBoard the current game board
     * @return true if the player has won, false otherwise
     */
    private static boolean checkDiagonal(Player player, Board myBoard) {
        // add functionality for vertical checking
        for (int i = 0; i < myBoard.getBoard()[0].length - 3; i++) {
            for (int j = 0; j < myBoard.getBoard().length - 3; j++) {
                if (myBoard.getBoard()[j][i] == player.getPlayerMark()
                        && myBoard.getBoard()[j + 1][i + 1] == player.getPlayerMark()
                        && myBoard.getBoard()[j + 2][i + 2] == player.getPlayerMark()
                        && myBoard.getBoard()[j + 3][i + 3] == player.getPlayerMark()) {
                    return true;
                }
            }
        }

        for (int i = 0; i < myBoard.getBoard()[0].length - 3; i++) {
            for (int j = 3; j < myBoard.getBoard().length; j++) {
                if (myBoard.getBoard()[j][i] == player.getPlayerMark()
                        && myBoard.getBoard()[j - 1][i + 1] == player.getPlayerMark()
                        && myBoard.getBoard()[j - 2][i + 2] == player.getPlayerMark()
                        && myBoard.getBoard()[j - 3][i + 3] == player.getPlayerMark()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if the specified player has won the game by making a vertical line of four of their pieces on the game board.
     *
     * @param player the player to check for a win
     * @param myBoard the current game board
     * @return true if the player has won, false otherwise
     */
    private static boolean checkVertical(Player player, Board myBoard) {
        for (int i = 0; i < myBoard.getBoard().length; i++) {
            for (int j = 0; j < myBoard.getBoard().length - 3; j++) {
                if (myBoard.getBoard()[j][i] == player.getPlayerMark()
                        && myBoard.getBoard()[j+1][i] == player.getPlayerMark()
                        && myBoard.getBoard()[j+2][i] == player.getPlayerMark()
                        && myBoard.getBoard()[j+3][i] == player.getPlayerMark()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if the specified player has won the game by making a horizontal line of four of their pieces on the game board.
     *
     * @param player the player to check for a win
     * @param myBoard the current game board
     * @return true if the player has won, false otherwise
     */
    private static boolean checkHorizontal(Player player, Board myBoard) {
        for (int i = 0; i < myBoard.getBoard()[0].length - 1; i++) {
            for (int j = 0; j < myBoard.getBoard()[0].length - 3; j++) {
                if (myBoard.getBoard()[i][j] == player.getPlayerMark()
                        && myBoard.getBoard()[i][j+1] == player.getPlayerMark()
                        && myBoard.getBoard()[i][j+2] == player.getPlayerMark()
                        && myBoard.getBoard()[i][j+3] == player.getPlayerMark()) {
                    return true;
                }
            }
        }
        return false;
    }
}
