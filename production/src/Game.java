import java.util.HashMap;

public class Game {
    private Board board;
    private BoardVisual boardVisual;
    private GameRules rules;
    private HashMap<Integer, Player> players = new HashMap<>();
    private boolean popOut;

    Game() {
        board = new Board(6, 7);
        boardVisual = new BoardVisual(board);
        rules = new GameRules(board);
        setPlayers();
        setGameMode();
    }

    private void setPlayers() {
        System.out.print("\nPLAYER 1 >> ");
        Player player1 = new Player(board);
        System.out.print("\nPLAYER 2 >> ");
        Player player2 = new Player(board, setPlayerColor());
        System.out.println("Has color " + player2.color + ".\n");
        players.put(1, player1);
        players.put(2, player2);
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

    private void setGameMode() {
        Player player1 = players.get(1);
        String gameMode = player1.chooseGameMode();
        popOut = gameMode.equals("POP");
    }

    public void start() {
        int playerIndex = 1;
        while (!gameOver()) {
            System.out.print("\nPLAYER " + playerIndex + " >> ");
            Player player = getPlayer(playerIndex);
            int column = move(player);
            boardVisual.printBoard();
            if (winningMove(column)) {
                winnerMessage(column);
                break;
            }
            playerIndex = nextPlayer(playerIndex);
        }
        System.out.println("Game over!");
    }

    private boolean gameOver() {
        if (popOut) return false;
        return board.isFull();
    }

    private int move(Player player) {
        boolean pop = setInsertOrPop(player, popOut);
        int column = player.chooseColumn(pop);
        makeMoveOnBoard(player.color, pop, column);
        return column;
    }

    private boolean setInsertOrPop(Player player, boolean popOut) {
        if (popOut) {
            String insertOrPop = player.chooseInsertOrPop();
            return insertOrPop.equals("P");
        }
        return false;
    }

    private void makeMoveOnBoard(String piece, boolean pop, int column) {
        if (pop)
            board.popOut(column);
        else
            board.insertPieceInColumn(piece, column);
}

    private boolean winningMove(int column) {
        return rules.connectFour(column, popOut);
    }

    private void winnerMessage(int column) {
        String winner = rules.winner(column, popOut);
        System.out.println("\n" + winner + " wins the game.");
    }

    private int nextPlayer(int current) {
        if (current == 1)
            return 2;
        return 1;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
