import java.awt.Point;

public class Apple implements Food {
    private char foodSymbol;
    private Point position;

    public Apple(char foodSymbol) {
        this.foodSymbol = foodSymbol;
        this.position = new Point();
        spawn();
    }

    @Override
    public void spawn() {
        // Generate a random position for the food within the bounds of the board frame
        int x = randomPosition();
        int y = randomPosition();
        position.setLocation(x, y);
    }

    @Override
    public char getFoodSymbol() {
        return foodSymbol;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    private int randomPosition() {
        return (int) (Math.random() * (Board.BOARD_SIZE - 2) + 1);
    }
}