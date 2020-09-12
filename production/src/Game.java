public class Game {
    Board board;
    Player player1;
    Player player2;
    BoardRules rules;

    Game() {
        board = new Board(6, 7);
        player1 = new Player(board, "R");
        player2 = new Player(board, "Y");
        rules = new BoardRules(board);
    }


}
