import java.util.List;

public class BoardVisual {
    private Board board;

    BoardVisual(Board board) {
        this.board = board;
    }

    public void printBoard() {
        System.out.print("\n 1 2 3 4 5 6 7 \n");
        for (int i = 1; i <= board.numberOfRows; i++)
            printRow(i);
    }

    private void printRow(int index) {
        List<String> row = board.getRow(index);
        System.out.print("|" + String.join("|", row) + "|\n");
    }
}
