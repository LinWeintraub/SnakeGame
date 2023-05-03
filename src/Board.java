import java.awt.*;
import java.util.ArrayList;

public interface Board {
    int BOARD_SIZE = 10;

    void createBoard();
    void clearBoard();
    void placePointsOnBoard(ArrayList<Point> points, char c);
    boolean placePointOnBoard(Point point, char c);
    char[][] getBoard();
}
