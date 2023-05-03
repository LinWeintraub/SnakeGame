import java.awt.*;
import java.util.ArrayList;

public class PlayBoard implements Board {
    private char[][] board;
    private char borderChar = '*';
    private char emptyChar = ' ';

    public PlayBoard() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        createBoard();
    }

    @Override
    public void createBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (row == 0 || row == BOARD_SIZE - 1 || col == 0 || col == BOARD_SIZE - 1) {
                    board[row][col] = borderChar;
                } else {
                    board[row][col] = emptyChar;
                }
            }
        }
    }

    @Override
    public void clearBoard() {
        for (int row = 1; row < BOARD_SIZE - 1; row++) {
            for (int col = 1; col < BOARD_SIZE - 1; col++) {
                board[row][col] = ' ';
            }
        }
    }

    @Override
    public void placePointsOnBoard(ArrayList<Point> points, char c) {
        for (Point point : points) {
            board[point.x][point.y] = c;
        }
    }

    @Override
    public boolean placePointOnBoard(Point point, char c) {
        if (board[(int) point.getX()][(int) point.getY()] != ' ') {
            return false;
        }

        // Set the character at the specified point on the board
        board[(int) point.getX()][(int) point.getY()] = c;
        return true;
    }

    @Override
    public char[][] getBoard() {
        return board;
    }
}