/**
 * Main class for Connect4 game.
 * This class instantiates a {@link GameController} and starts the game.
 */
public class Main {
    /**
     * The main method for the Connect4 game.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        GameController game = new GameController();
        game.startGame();
    }
}
