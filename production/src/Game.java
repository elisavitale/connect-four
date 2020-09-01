public class Game {
    Board board;
    Player player1;
    Player player2;

    Game() {
        board = new Board(6, 7);
        player1 = new Player("R");
        player2 = new Player("Y");
    }
}
