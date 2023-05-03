import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleGame implements GameController {
    private SnakeGame snakeGame;
    private Graphic graphics;
    private Board board;
    private Character character;
    private Food food;
    private boolean gameOver = false;

    @Override
    public void startGame() {
        // Initialize the game board
        board = new PlayBoard();
        character = new Snake(1, 1, '#');
        food = new Apple('@');

        graphics = new ConsoleGraphic(board, character, food);
        snakeGame = new SnakeGame(board, character, food, graphics);

        // Start the game loop
        gameLoop();
    }

    @Override
    public int handleInput() {
        String input = "";
        int inputIndex = -1;

        try {
            // non-blocking I/O to check for input
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            long startTime = System.currentTimeMillis();
            while (!reader.ready() && (System.currentTimeMillis() - startTime) < 1000) {
                // Wait for input or timeout
            }

            if (reader.ready()) {
                input = reader.readLine().toLowerCase();

                // Determine the new direction based on input and current direction
                if (input.equals("a")) {
                    inputIndex = 0;
                } else if (input.equals("d")) {
                    inputIndex = 1;
                } else if (input.equals("q")) {
                    stopGame();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return inputIndex;
    }

    @Override
    public void stopGame() {
        System.exit(0); // exit the game
    }

    private void gameLoop() {
        welcomeMessage();
        snakeGame.initializeGame();

        while (!gameOver) {
            // Handle user input to change the direction of the snake's movement
            snakeGame.nextMove(handleInput());

            // Move the snake and check for collisions
            snakeGame.moveCharacter();

            // Update the game board
            snakeGame.updateBoard();
            snakeGame.updateScreen();

            // Check if the game is over
            gameOver = snakeGame.isGameOver();

            // Pause for a short time to create the illusion of motion
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        graphics.display("Game over! Your score is " + snakeGame.gameScore() + ".");
    }

    private void welcomeMessage() {
        graphics.display("Welcome to Snake Game! \n");
        graphics.display("Use [A] + enter to move left, [D] + enter to move right, press [Q] to quit. \n");
        graphics.display("Press Enter to play. \n");
        graphics.display("\n");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}