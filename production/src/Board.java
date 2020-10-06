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

    public boolean columnIsFull(int column) {
        column--;
        return board[column].currentSize() == numberOfRows;
    }

    public boolean isFull() {
        return Arrays.stream(board)
                     .allMatch(Column::isFull);
    }

    public List<String> getColumn(int index) {
        index--;
        return board[index].getColumn();
    }

    public List<String> getRow(int index) {
        return Arrays.stream(board)
                     .map(column -> column.getPieceAtRow(index))
                     .collect(Collectors.toList());
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

    public boolean bottomPieceMatchesColor(int column, String color) {
        column--;
        return board[column].getPieceAtRow(numberOfRows)
                            .equals(color);
    }
}
