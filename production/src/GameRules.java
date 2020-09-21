import java.util.*;
import java.util.stream.IntStream;

public class GameRules {
    private Board board;
    private List<String> fourR = alignmentOfLengthFour("R");
    private List<String> fourY = alignmentOfLengthFour("Y");

    GameRules(Board board) {
        this.board = board;
    }

    private List<String> alignmentOfLengthFour(String label) {
        return Arrays.asList(label, label, label, label);
    }

    public boolean connectFour(int lastInput, boolean popOut) {
        ArrayList<List<String>> rowColDiag = getColumnRowsDiagonals(lastInput, popOut);
        return rowColDiag.stream()
                         .anyMatch(x -> containsAlignment(x, fourR) || containsAlignment(x, fourY));
    }

    private ArrayList<List<String>> getColumnRowsDiagonals(int column, boolean popOut) {
        ArrayList<List<String>> rowColDiag = new ArrayList<>();
        rowColDiag.add(board.getColumn(column));
        for (int row : getRowIndexes(column, popOut))
            rowColDiag.addAll(currentRowAndDiagonals(row, column));
        return rowColDiag;
    }

    private int[] getRowIndexes(int column, boolean popOut) {
        if (popOut) return IntStream.range(firstNonemptyRow(column), board.numberOfRows + 1)
                                    .toArray();
        else return new int[] {firstNonemptyRow(column)};
    }

    private int firstNonemptyRow(int column) {
        return board.numberOfRows - board.currentSizeOfColumn(column) + 1;
    }

    private List<List<String>> currentRowAndDiagonals(int row, int column) {
        return Arrays.asList(board.getRow(row),
                             board.getDiagonal(row, column, false),
                             board.getDiagonal(row, column, true));
    }

    private boolean containsAlignment(List<String> list, List<String> alignment) {
        return Collections.indexOfSubList(list, alignment) != -1;
    }
}
