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
        System.out.print(" 1 2 3 4 5 6 7 \n");
        for (int i = 1; i <= numberOfRows; i++)
            printRow(i);
    }

    public void printRow(int index) {
        ArrayList<String> row = getRow(index);
        System.out.print("|" + String.join("|", row) + "|\n");
    }

    public ArrayList<String> getRow(int index) {
        ArrayList<String> row = new ArrayList<>();
        for (int i = 0; i < numberOfColumns; i++)
            row.add(board[i].getPieceAtRow(index));
        return row;
    }

    public ArrayList<String> getColumn(int index) {
        ArrayList<String> column = new ArrayList<>();
        for (int i = 1; i <= numberOfRows; i++)
            column.add(board[index].getPieceAtRow(i));
        return column;
    }

    public ArrayList<String> getDiagonal(int currentRow, int currentColumn) {
        ArrayList<String> diagonal = new ArrayList<>();
        while (currentRow > 1 && currentColumn > 0) {
            currentRow -= 1;
            currentColumn -= 1;
        }
        while (currentRow <= 6 && currentColumn <= 6) {
            diagonal.add(board[currentColumn].getPieceAtRow(currentRow));
            currentColumn += 1;
            currentRow += 1;
        }
        return diagonal;
    }

    public void insertPieceInColumn(String piece, int column) {
        board[column - 1].insert(piece);
    }

    public ArrayList<Integer> columnSizes() {
        ArrayList<Integer> columnSizes = new ArrayList<Integer>();
        for (int i = 0; i < numberOfColumns; i++)
            columnSizes.add(board[i].currentSize());
        return columnSizes;
    }
}
