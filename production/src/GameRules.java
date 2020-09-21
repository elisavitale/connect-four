import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class GameRules {
    private Board board;
    private List<String> fourR = alignmentOfLength("R", 4);
    private List<String> fourY = alignmentOfLength("Y", 4);

    GameRules(Board board) {
        this.board = board;
    }

    public boolean connectFour(int lastInput, boolean pop) {
        ArrayList<List<String>> rowColDiag = getCurrentRowColumnDiagonals(lastInput, pop);
        return rowColDiag.stream()
                         .anyMatch(x -> containsAlignment(x, fourR) || containsAlignment(x, fourY));
    }

    private ArrayList<List<String>> getCurrentRowColumnDiagonals(int columnIndex, boolean pop) {
        int[] currentRowIndexes = getCurrentRowIndexes(columnIndex, pop);
        ArrayList<List<String>> rowColDiag = new ArrayList<>();
        rowColDiag.add(board.getColumn(columnIndex));
        for (int rowIndex : currentRowIndexes)
            rowColDiag.addAll(currentRowsAndDiagonals(rowIndex, columnIndex));
        return rowColDiag;
    }

    private List<List<String>> currentRowsAndDiagonals(int row, int column) {
        return Arrays.asList(board.getRow(row),
                             board.getDiagonal(row, column, false),
                             board.getDiagonal(row, column, true));
    }

    private int[] getCurrentRowIndexes(int column, boolean pop) {
        if (pop) return IntStream.range(firstNonemptyRow(column), board.numberOfRows + 1)
                                 .toArray();
        else return new int[] {firstNonemptyRow(column)};
    }

    private int firstNonemptyRow(int column) {
        return board.numberOfRows - board.currentSizeOfColumn(column) + 1;
    }

    private boolean containsAlignment(List<String> list, List<String> alignment) {
        return Collections.indexOfSubList(list, alignment) != -1;
    }

    private List<String> alignmentOfLength(String label, int length) {
        List<String> alignment = new ArrayList<>();
        for (int i = 0; i < length; i++) alignment.add(label);
        return alignment;
    }
}
