# Connect4 Game

This is a Connect4 game implemented in Java as part of the Principles of Programming 1 coursework. The game allows a human player to play against a computer player on a 6x7 grid. The goal of the game is to connect four tokens either diagonally, horizontally, or vertically.

## Requirements
To run the game, ensure you have Java 17 installed. You can use any Integrated Development Environment (IDE) for development, but the code must run on Java 17 without requiring additional libraries or programs.

## Getting Started

1. Clone or download the Connect4 repository from the Moodle platform.

2. Open the project in your preferred IDE.

3. Run the code to compile and execute the Connect4 game.

## Gameplay

1. Start the game by running the Connect4 program.

2. The game prompts the human player to make a move by entering the column number where they want to place their token (from 1 to 7).

3. The computer player then makes its move.

4. Alternate turns between the human player and the computer player until one of the players wins or the game ends in a draw.

5. The game ends when a player successfully connects four tokens in a row diagonally, horizontally, or vertically, or when the board is completely filled.

6. The game displays the final result and prompts the player to play again or exit.

## Code Restructuring and Object-Oriented Principles

The following improvements have been made to adhere to object-oriented principles:

1. **Modularisation**: The code has been modularised by extracting separate methods and classes for checking win conditions, representing the board, and managing the game logic. This improves code maintainability and reusability.

2. **Encapsulation**: The flow of the game has been encapsulated within a GameController class, which controls the interactions between the players and the board. The board and player entities are encapsulated within their respective classes, providing clear separation of concerns.

3. **Polymorphism**: Polymorphism is achieved by implementing a Player interface, allowing different types of players, such as human players and computer players, to be treated uniformly. The Player interface provides common methods for players, while allowing flexibility for different implementations.

## Report

Please refer to the provided report document for a more detailed explanation of the code restructuring and the application of object-oriented principles.

Enjoy playing Connect4!