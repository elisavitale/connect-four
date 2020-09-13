import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    private void initializeBoard() {
        for (int i = 0; i < numberOfColumns; i++)
            board[i] = new Column(numberOfRows);
    }

    public void printBoard() {
        System.out.print(" 1 2 3 4 5 6 7 \n");
        for (int i = 1; i <= numberOfRows; i++)
            printRow(i);
    }

    private void printRow(int index) {
        List<String> row = getRow(index);
        System.out.print("|" + String.join("|", row) + "|\n");
    }

    public List<String> getRow(int index) {
        ArrayList<String> row = new ArrayList<>();
        Arrays.stream(board)
              .map(column -> column.getPieceAtRow(index))
              .forEach(row::add);
        return row;
    }

    public List<String> getColumn(int index) {
        index--;
        return board[index].getColumn();
    }

    public List<String> getDiagonal(int currentRow, int currentColumn, boolean antiDiagonal) {
        currentColumn--;
        int[] startingPosition = getStartingPosition(currentRow, currentColumn, antiDiagonal);
        ArrayList<int[]> positions = getDiagonalPositions(startingPosition, antiDiagonal);
        return positions.stream()
                        .map(x -> board[x[0]].getPieceAtRow(x[1]))
                        .collect(Collectors.toList());
    }

    private int[] getStartingPosition(int row, int column, boolean antiDiagonal) {
        if (antiDiagonal)
            while (row < numberOfRows && column > 0) {
                row++;
                column--;
            }
        else
            while (row > 1 && column > 0) {
                row--;
                column--;
            }
        return new int[] {column, row};
    }

    private ArrayList<int[]> getDiagonalPositions(int[] diagonalStart, boolean antiDiagonal) {
        int column = diagonalStart[0];
        int row = diagonalStart[1];
        ArrayList<int[]> positions = new ArrayList<>();
        while (row >= 1 && row <= numberOfRows && column < numberOfColumns) {
            if (antiDiagonal) positions.add(new int[] {column++, row--});
            else positions.add(new int[] {column++, row++});
        }
        return positions;
    }

    public void insertPieceInColumn(String piece, int column) {
        column--;
        board[column].insert(piece);
    }

    public int currentSizeOfColumn(int column) {
        column--;
        return board[column].currentSize();
    }

    public boolean isFull() {
        return Arrays.stream(board)
                     .allMatch(Column::isFull);
    }
}
