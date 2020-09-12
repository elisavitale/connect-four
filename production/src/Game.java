public class Game {
    Board board;
    Player player1;
    Player player2;
    BoardRules rules;

    Game(Board board) {
        this.board = board;
        System.out.print("PLAYER 1 >> ");
        this.player1 = new Player(board);
        System.out.print("PLAYER 2 >> ");
        this.player2 = new Player(board, setColor());
        System.out.println("Has color " + player2.color);
        rules = new BoardRules(board);
    }

    private String setColor() {
        if (player1.color.equals("R"))
            return "Y";
        else
            return "R";
    }
    public void start() {
        while (!board.isFull()) {
            System.out.print("PLAYER 1 >> ");
            int column1 = player1.chooseColumn();
            board.insertPieceInColumn(player1.color, column1);
            board.printBoard();
            if (rules.connectFour(column1))
                break;
            System.out.print("PLAYER 2 >> ");
            int column2 = player2.chooseColumn();
            board.insertPieceInColumn(player2.color, column2);
            board.printBoard();
            if (rules.connectFour(column2))
                break;
        }
    }
}
