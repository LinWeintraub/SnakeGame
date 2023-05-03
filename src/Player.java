import java.awt.*;
import java.util.ArrayList;

public interface Player {
    void move(boolean condition);
    void setDirection(Direction direction);
    Direction getDirection();
    ArrayList<Point> getBody();
    char getCharacterSymbol();
    Point getHead();
    int getLength();
}
