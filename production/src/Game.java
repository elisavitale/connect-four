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
        boardVisual.printBoard();
        while (!gameOver(playerIndex)) {
            int column = move(playerIndex);
            boardVisual.printBoard();
            if (winningMove(column)) {
                winnerMessage(column);
                break;
            }
            playerIndex = nextPlayer(playerIndex);
        }
        System.out.println("\nGame over!");
    }

    private boolean gameOver(int currentPlayer) {
        if (popOut) return !playerCanMove(currentPlayer);
        else return board.isFull();
    }

    private boolean playerCanMove(int currentPlayer) {
        return getPlayer(currentPlayer).playerCanMove();
    }

    private int move(int currentPlayer) {
        System.out.print("\nPLAYER " + currentPlayer + " >> ");
        Player player = getPlayer(currentPlayer);
        boolean pop = insertOrPop(player, popOut);
        int column = player.chooseColumn(pop);
        fromPlayerChoiceToBoardMove(player.color, pop, column);
        return column;
    }

    private boolean insertOrPop(Player player, boolean popOut) {
        if (popOut) {
            String insertOrPop = player.chooseInsertOrPop();
            return insertOrPop.equals("P");
        }
        return false;
    }

    private void fromPlayerChoiceToBoardMove(String piece, boolean pop, int column) {
        if (pop) board.popOut(column);
        else board.insertPieceInColumn(piece, column);
    }

    private boolean winningMove(int column) {
        return rules.connectFour(column, popOut);
    }

    private void winnerMessage(int column) {
        String winner = rules.winner(column, popOut);
        System.out.println("\n" + winner + " wins the game.");
    }

    private int nextPlayer(int current) {
        if (current == 1) return 2;
        return 1;
    }
}
