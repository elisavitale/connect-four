import java.util.*;
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

    public void insertPieceInColumn(String piece, int column) {
        column--;
        board[column].insert(piece);
    }

    public void popOut(int column) {
        column--;
        board[column].popOut();
    }

    public int currentSizeOfColumn(int column) {
        column--;
        return board[column].currentSize();
    }

    public boolean isFull() {
        return Arrays.stream(board)
                     .allMatch(Column::isFull);
    }

    public List<String> getRow(int index) {
        ArrayList<String> row = new ArrayList<>();
        Arrays.stream(board)
              .map(column -> column.getPieceAtRow(index))
              .forEach(row::add);
        return row;
    }

    public List<String> getDiagonal(int row, int column, boolean antiDiagonal) {
        column--;
        ArrayList<int[]> positions = getDiagonalPositions(row, column, antiDiagonal);
        return positions.stream()
                        .map(x -> board[x[0]].getPieceAtRow(x[1]))
                        .collect(Collectors.toList());
    }

    private ArrayList<int[]> getDiagonalPositions(int row, int column, boolean antiDiagonal) {
        ArrayList<int[]> positions = new ArrayList<>();
        int[] step = getFirstStep(row, column, antiDiagonal);
        while (stepIsInsideBoard(step))
            positions.add(nextDiagonalStep(step, antiDiagonal));
        return positions;
    }

    private int[] getFirstStep(int row, int column, boolean antiDiagonal) {
        if (antiDiagonal) while (row < numberOfRows && column > 0) {
            row++;
            column--;
        }
        else while (row > 1 && column > 0) {
            row--;
            column--;
        }
        return new int[] {column, row};
    }

    private boolean stepIsInsideBoard(int[] step) {
        int column = step[0];
        int row = step[1];
        return row >= 1 && row <= numberOfRows && column >= 0 && column < numberOfColumns;
    }

    private int[] nextDiagonalStep(int[] step, boolean antiDiagonal) {
        if (antiDiagonal) return new int[] {step[0]++, step[1]--};
        else return new int[] {step[0]++, step[1]++};
    }
}
