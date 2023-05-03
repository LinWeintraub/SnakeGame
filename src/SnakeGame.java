import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SnakeGame implements GameLogic {
    private Board board;
    private Player player;
    private Food food;
    private Graphic graphic;

    private boolean shouldGrow = false;
    private boolean gameOver = false;

    public SnakeGame(Board board, Player player, Food food, Graphic graphic) {
        this.board = board;
        this.player = player;
        this.food = food;
        this.graphic = graphic;
    }

    public void initializeGame() {
        board.placePointsOnBoard(player.getBody(), player.getCharacterSymbol());
        board.placePointOnBoard(food.getPosition(), food.getFoodSymbol());

        graphic.clear();
        graphic.drawBoard();
    }

    public void moveCharacter() {
        // Move the snake and check for collisions
        player.move(shouldGrow);
        shouldGrow = false;
        checkCollisions();
    }

    public void nextMove(int inputIndex) {
        Direction[][] directionsTable = {
                {Direction.DOWN, Direction.UP, Direction.LEFT, Direction.RIGHT},
                {Direction.UP, Direction.DOWN, Direction.RIGHT, Direction.LEFT}
        };

        Direction currentDirection = player.getDirection();

        if (inputIndex != -1) {
            Direction newDirection = directionsTable[inputIndex][currentDirection.ordinal()];
            // Set the new direction for the snake
            player.setDirection(newDirection);
        }
    }

    public void updateBoard() {
        // Clear the board and update the positions of the snake and food
        board.clearBoard();
        board.placePointsOnBoard(player.getBody(), player.getCharacterSymbol());
        board.placePointOnBoard(food.getPosition(), food.getFoodSymbol());
    }

    public void updateScreen() {
        graphic.clear();
        graphic.drawBoard();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int gameScore() {
        return (player.getLength() - 1);
    }

    public void checkCollisions() {
        // Check for collision with walls
        if (player.getHead().getX() <= 0 || player.getHead().getX() >= Board.BOARD_SIZE - 1 ||
                player.getHead().getY() <= 0 || player.getHead().getY() >= Board.BOARD_SIZE - 1) {
            gameOver = true;
            return;
        }

        // Check for collision with snake's own body
        for (int i = 1; i < player.getBody().size(); i++) {
            if (player.getHead().equals(player.getBody().get(i))) {
                gameOver = true;
                return;
            }
        }

        // Check for collision with food
        if (player.getHead().equals(food.getPosition())) {
            shouldGrow = true;
            food.spawn();
        }
    }
}
