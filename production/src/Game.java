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
        popOut = setGameMode();
    }

    private void setPlayers() {
        System.out.print("\nPLAYER 1 >> ");
        players.put(1, new Player(board));
        System.out.print("\nPLAYER 2 >> ");
        players.put(2, new Player(board, setPlayerColor()));
        System.out.println("Has color " + getPlayer(2).color + ".\n");
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

    private boolean setGameMode() {
        Player player1 = players.get(1);
        String gameMode = player1.chooseGameMode();
        return gameMode.equals("POP");
    }

    public void start() {
        int playerIndex = 1;
        while (gameNotOver()) {
            System.out.print("\nPLAYER " + playerIndex + " >> ");
            Player player = getPlayer(playerIndex);
            int column = move(player);
            boardVisual.printBoard();
            if (winningMove(column)) {
                winnerMessage(playerIndex);
                break;
            }
            playerIndex = nextPlayer(playerIndex);
        }
        System.out.println("Game over!");
    }

    private boolean gameNotOver() {
        if (popOut) return true;
        return !board.isFull();
    }

    private int move(Player player) {
        int column;
        if (popOut) {
            String insertOrPop = player.chooseInsertOrPop();
            column = player.chooseColumn(insertOrPop.equals("P"));
            if (insertOrPop.equals("P")) {
                board.popOut(column);
            }
            else
                board.insertPieceInColumn(player.color, column);
        }
        else {
            column = player.chooseColumn(false);
            board.insertPieceInColumn(player.color, column);
        }
        return column;
    }

    private boolean winningMove(int column) {
        return rules.connectFour(column, false);
    }

    private void winnerMessage(int current) {
        System.out.println("Player " + current + " wins the game.");
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
