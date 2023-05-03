public interface GameLogic {
    void initializeGame();
    void moveCharacter();
    void nextMove(int inputIndex);
    void updateBoard();
    void updateScreen();
    boolean isGameOver();
    int gameScore();
    void checkCollisions();
}
