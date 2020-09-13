import java.util.HashMap;

public class Game {
    private Board board;
    private GameRules rules;
    private HashMap<Integer, Player> players = new HashMap<>();

    Game(Board board) {
        this.board = board;
        setPlayers();
        rules = new GameRules(board);
    }

    private void setPlayers() {
        System.out.print("PLAYER 1 >> ");
        players.put(1, new Player(board));
        System.out.print("PLAYER 2 >> ");
        players.put(2, new Player(board, setPlayerColor()));
        System.out.println("Has color " + getPlayer(2).color);
    }

    private String setPlayerColor() {
        Player player1 = getPlayer(1);
        if (player1.color.equals("R"))
            return "Y";
        return "R";
    }

    private Player getPlayer(int index) {
        return players.get(index);
    }

    public void start() {
        int currentPlayerIndex = 1;
        while (!board.isFull()) {
            System.out.print("PLAYER " + currentPlayerIndex + " >> ");
            Player currentPlayer = getPlayer(currentPlayerIndex);
            int column = move(currentPlayer);
            if (winningMove(column)) {
                winnerMessage(currentPlayerIndex);
                break;
            }
            currentPlayerIndex = nextPlayer(currentPlayerIndex);
        }
        System.out.println("Game over!");
    }

    private int move(Player player) {
        int column = player.chooseColumn();
        board.insertPieceInColumn(player.color, column);
        board.printBoard();
        return column;
    }

    private boolean winningMove(int column) {
        return rules.connectFour(column);
    }

    private void winnerMessage(int current) {
        System.out.println("Player " + current + " wins the game.");
    }

    private int nextPlayer(int current) {
        if (current == 1)
            return 2;
        return 1;
    }
}
