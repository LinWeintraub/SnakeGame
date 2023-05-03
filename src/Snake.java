import java.awt.*;
import java.util.ArrayList;

public class Snake implements Character {
    private ArrayList<Point> body;
    private char snakeSymbol;
    private Direction direction = Direction.RIGHT;

    public Snake(int x, int y, char snakeSymbol) {
        this.snakeSymbol = snakeSymbol;
        body = new ArrayList<>();
        body.add(new Point(x, y));
    }

    @Override
    public void move(boolean shouldGrow) {
        Point head = body.get(0);
        Point newHead = new Point(head.x, head.y);
        switch (direction) {
            case UP:
                newHead.x--;
                break;
            case RIGHT:
                newHead.y++;
                break;
            case DOWN:
                newHead.x++;
                break;
            case LEFT:
                newHead.y--;
                break;
        }

        body.add(0, newHead);

        if (!shouldGrow) {
            body.remove(body.size() - 1);
        }
    }

    @Override
    public void setDirection(Direction newDirection) {
        direction = newDirection;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public ArrayList<Point> getBody() {
        return body;
    }

    @Override
    public char getCharacterSymbol() {
        return snakeSymbol;
    }

    @Override
    public Point getHead() {
        return body.get(0);
    }

    @Override
    public int getLength() {
        return body.size();
    }
}