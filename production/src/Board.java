public class Board {
    private int numberOfColumns;
    private int numberOfRows;
    private Column[] board;

    Board(int rows, int columns) {
        numberOfColumns = columns;
        numberOfRows = rows;
        board = new Column[numberOfColumns];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < numberOfColumns; i++)
            board[i] = new Column(numberOfRows);
    }

    public void printBoard() {
        for (int i = 0; i < numberOfRows; i++)
            printRow(i);
    }

    public void printRow(int i) {
        for (int j = 0; j < numberOfColumns; j++)
            System.out.print("|" + board[j].getPiece(i));
        System.out.print("|\n");
    }
}
