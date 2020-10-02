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
        players.put(1, player1);
        Player player2 = new Player(board, setPlayerColor());
        System.out.println("\nPLAYER 2 >> Has color " + player2.color + ".\n");
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
        Player player1 = getPlayer(1);
        String gameMode = player1.chooseGameMode();
        popOut = gameMode.equals("POP");
    }

    public void start() {
        int playerIndex = 1;
        Player player = getPlayer(playerIndex);
        boardVisual.printBoard();
        while (!gameOver(player)) {
            System.out.print("\nPLAYER " + playerIndex + " >> ");
            boolean pop = insertOrPop(player, popOut);
            int column = player.chooseColumn(pop);
            move(player.color, pop, column);
            boardVisual.printBoard();
            if (winningMove(column, pop)) {
                winnerMessage(column, pop);
                break;
            }
            playerIndex = nextPlayer(playerIndex);
            player = getPlayer(playerIndex);
        }
        System.out.println("\nGame over!");
    }

    private boolean gameOver(Player player) {
        return rules.gameOver(player, popOut);
    }

    private boolean insertOrPop(Player player, boolean popOut) {
        if (popOut) {
            String insertOrPop = player.chooseInsertOrPop();
            return insertOrPop.equals("P");
        }
        return false;
    }

    private void move(String piece, boolean pop, int column) {
        if (pop) board.popOut(column);
        else board.insertPieceInColumn(piece, column);
    }

    private boolean winningMove(int column, boolean pop) {
        return rules.connectFour(column, pop);
    }

    private void winnerMessage(int column, boolean pop) {
        String winner = rules.winner(column, pop);
        System.out.println("\n" + winner + " wins the game.");
    }

    private int nextPlayer(int current) {
        if (current == 1) return 2;
        return 1;
    }
}
