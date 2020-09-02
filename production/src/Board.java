import java.util.ArrayList;

public class Board {
    int numberOfColumns;
    int numberOfRows;
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
        for (int i = 1; i <= numberOfRows; i++)
            printRow(i);
    }

    public void printRow(int index) {
        ArrayList<String> row = getRow(index);
        System.out.print("|");
        System.out.print(String.join("|", row));
        System.out.print("|\n");
    }

    public ArrayList<String> getRow(int index) {
        ArrayList<String> row = new ArrayList<>();
        for (int i = 0; i < numberOfColumns; i++)
            row.add(board[i].getPiece(index));
        return row;
    }

    public void insertPieceInColumn(String piece, int column) {
        board[column - 1].insert(piece);
    }

    public ArrayList<String> getColumn(int index) {
        ArrayList<String> column = new ArrayList<>();
        for (int i = 1; i <= numberOfRows; i++)
            column.add(board[index].getPiece(i));
        return column;
    }
}
