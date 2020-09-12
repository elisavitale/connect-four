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
        return board[index].getColumn();
    }

    public List<String> getDiagonal(int currentRow, int currentColumn, boolean antiDiagonal) {
        ArrayList<int[]> positions;
        if (antiDiagonal)
            positions = antiDiagonalPositions(currentRow, currentColumn);
        else
            positions = diagonalPositions(currentRow, currentColumn);
        return positions.stream()
                        .map(x -> board[x[1]].getPieceAtRow(x[0]))
                        .collect(Collectors.toList());
    }

    private ArrayList<int[]> diagonalPositions(int row, int column) {
        while (row > 1 && column > 0) {
            row--;
            column--;
        }
        ArrayList<int[]> positions = new ArrayList<>();
        while (row <= 6 && column <= 6)
            positions.add(new int[] {row++, column++});
        return positions;
    }

    private ArrayList<int[]> antiDiagonalPositions(int row, int column) {
        while (row < 6 && column > 0) {
            row++;
            column--;
        }
        ArrayList<int[]> positions = new ArrayList<>();
        while (row >= 1 && column <= 6)
            positions.add(new int[] {row--, column++});
        return positions;
    }

    public void insertPieceInColumn(String piece, int column) {
        board[column - 1].insert(piece);
    }

    public int[] currentColumnSizes() {
        return Arrays.stream(board)
                     .mapToInt(Column::currentSize)
                     .toArray();
    }

    public boolean isFull() {
        return Arrays.stream(board)
                     .allMatch(Column::isFull);
    }
}
