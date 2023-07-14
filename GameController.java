import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class is the controller for a Connect4 game.
 * It has a method for starting the game, checking who starts, adding players, switching between players,
 * and pausing the game for the computer.
 *
 * @author Pax Sharma
 * @since 08/12/22
 */
public class GameController {
    /** The list of players in the game. */
    private ArrayList<Player> players = new ArrayList<>();
    /** The list of players in the game. */
    private Board myBoard;
    /** The random number generator. */
    private final Random random;

    /**
     * Creates a new game controller and instantiates a game board and random number generator.
     */
    public GameController() {
        myBoard = new Board();
        this.random = new Random();
    }

    /**
     * Starts the Connect4 game.
     */
    public void startGame() {
        // print the introductory message
        printWelcomeMessage();
        myBoard.printBoard();
        addPlayers();
        boolean gameOver = false;
        Player currentPlayer = checkFirstTurn();
        // loop until the game is over
        while (true) {
            // place mark on the board based on user input
            try {
                myBoard.placeCounter(currentPlayer.makeMove(), currentPlayer.getPlayerMark());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Please try again.");
                continue;
            }
            sleep(currentPlayer, 1000); // sleep for 1 second
            myBoard.printBoard();
            gameOver = GameLogic.checkWin(currentPlayer, myBoard);
            if (gameOver) {
                currentPlayer.hasWonMessage();
                break;
            }
            currentPlayer = switchPlayer(currentPlayer);
        }

        System.out.println("Game over.");
    }

    /**
     * Checks who goes first in the game of Connect4.
     *
     * @return the player who goes first
     */
    private Player checkFirstTurn() {
        try {
            System.out.println("Enter 1 to go first");
            System.out.println("Enter 2 to go second");
            System.out.println("Press 0 to decide randomly.");
            BufferedReader turnInputReader = new BufferedReader(new InputStreamReader(System.in));
            int turnInput = 0;
            do {
                turnInput = Integer.parseInt(turnInputReader.readLine());
                if (turnInput == 0) {
                    break;
                }
                if (turnInput == 1) {
                    return players.get(0);
                } else if (turnInput == 2) {
                    return players.get(1);
                } else {
                    System.out.println("Please enter a valid input!");
                }
            } while (true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return players.get(random.nextInt(1));
    }

    /**
     * Adds players to the game of Connect4.
     */
    private void addPlayers() {
        BufferedReader userOpponentReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 1 to play against a computer");
        System.out.println("Enter 2 to play against another human");
        System.out.println("Enter anything else to watch a computer play against itself");
        System.out.println("Enter quit to exit");
        System.out.println("Enter your choice: ");
        String userOpponentInput = null;
        try {
            userOpponentInput = userOpponentReader.readLine();
            if (userOpponentInput.equals("1")) {
                players.add(new HumanPlayer('r', "Human"));
                players.get(0).setPlayerProperties(); // set player name and mark
                players.add(new ComputerPlayer('y', "Computer"));
            } else if (userOpponentInput.equals("2")) {
                players.add(new HumanPlayer('r', "Human 1"));
                players.add(new HumanPlayer('y', "Human 2"));
                for(Player player : players) {
                    player.setPlayerProperties();
                }
            } else {
                players.add(new ComputerPlayer('r', "Computer 1"));
                players.add(new ComputerPlayer('y', "Computer 2"));
            }

            if (userOpponentInput.equals("quit")) {
                System.exit(0);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Switches the current player in the game of Connect4.
     *
     * @param currentPlayer the current player
     * @return the next player
     */
    private Player switchPlayer(Player currentPlayer) {
        if (players.get(0) == currentPlayer) {
            return players.get(1);
        }
        return players.get(0);
    }

    /**
     * This method is used to display a welcome message to the player.
     */
    private static void printWelcomeMessage() {
        System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players red and yellow");
        System.out.println("Player 1 is Red, Player 2 is Yellow");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println();
    }
    /**
     * Pauses the game for a specified amount of time.
     *
     * @param currentPlayer The player whose turn it is
     * @param timeInMilliseconds The amount of time in milliseconds to pause the game.
     */
    private static void sleep(Player currentPlayer, int timeInMilliseconds) {
        try {
            // sleep for 1 second if the current player is a computer
            if (currentPlayer instanceof ComputerPlayer) {
                Thread.sleep(timeInMilliseconds);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
