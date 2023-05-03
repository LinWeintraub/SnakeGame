import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SnakeGame implements GameLogic {
    private Board board;
    private Character character;
    private Food food;
    private Graphic graphic;

    private boolean shouldGrow = false;
    private boolean gameOver = false;

    public SnakeGame(Board board, Character character, Food food, Graphic graphic) {
        this.board = board;
        this.character = character;
        this.food = food;
        this.graphic = graphic;
    }

    public void initializeGame() {
        board.placePointsOnBoard(character.getBody(), character.getCharacterSymbol());
        board.placePointOnBoard(food.getPosition(), food.getFoodSymbol());

        graphic.clear();
        graphic.drawBoard();
    }

    public void moveCharacter() {
        // Move the snake and check for collisions
        character.move(shouldGrow);
        shouldGrow = false;
        checkCollisions();
    }

    public void nextMove(int inputIndex) {
        Direction[][] directionsTable = {
                {Direction.DOWN, Direction.UP, Direction.LEFT, Direction.RIGHT},
                {Direction.UP, Direction.DOWN, Direction.RIGHT, Direction.LEFT}
        };

        Direction currentDirection = character.getDirection();

        if (inputIndex != -1) {
            Direction newDirection = directionsTable[inputIndex][currentDirection.ordinal()];
            // Set the new direction for the snake
            character.setDirection(newDirection);
        }
    }

    public void updateBoard() {
        // Clear the board and update the positions of the snake and food
        board.clearBoard();
        board.placePointsOnBoard(character.getBody(), character.getCharacterSymbol());
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
        return (character.getLength() - 1);
    }

    public void checkCollisions() {
        // Check for collision with walls
        if (character.getHead().getX() <= 0 || character.getHead().getX() >= Board.BOARD_SIZE - 1 ||
                character.getHead().getY() <= 0 || character.getHead().getY() >= Board.BOARD_SIZE - 1) {
            gameOver = true;
            return;
        }

        // Check for collision with snake's own body
        for (int i = 1; i < character.getBody().size(); i++) {
            if (character.getHead().equals(character.getBody().get(i))) {
                gameOver = true;
                return;
            }
        }

        // Check for collision with food
        if (character.getHead().equals(food.getPosition())) {
            shouldGrow = true;
            food.spawn();
        }
    }
}
