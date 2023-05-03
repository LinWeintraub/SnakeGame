import java.io.IOException;

public class ConsoleGraphic implements Graphic {
    private Board board;
    private Player player;
    private Food food;
    private char characterSymbol;
    private char foodSymbol;

    public ConsoleGraphic(Board board, Player player, Food food) {
        this.board = board;
        this.player = player;
        this.food = food;

        characterSymbol = player.getCharacterSymbol();
        foodSymbol = food.getFoodSymbol();
    }

    @Override
    public void display(String s) {
        System.out.print(s);
    }

    @Override
    public void drawBoard() {
        String greenColor = "\u001B[32m";
        String redColor = "\u001B[31m";
        String resetColor = "\u001B[0m";

        for (int row = 0; row < Board.BOARD_SIZE; row++) {
            for (int col = 0; col < Board.BOARD_SIZE; col++) {
                if (characterSymbol == board.getBoard()[row][col]) {
                    display(greenColor + characterSymbol + resetColor + " ");
                } else if (foodSymbol == board.getBoard()[row][col]) {
                    display(redColor + foodSymbol + resetColor + " ");
                } else {
                    display(board.getBoard()[row][col] + " ");
                }
            }

            display("\n");
        }
    }

    @Override
    public void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {

        }
    }
}