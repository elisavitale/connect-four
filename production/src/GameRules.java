import java.util.*;
import java.util.stream.IntStream;

public class GameRules {
    private Board board;

    GameRules(Board board) {
        this.board = board;
    }

    public boolean connectFour(int lastInput, boolean popOut) {
        ArrayList<List<String>> linesToCheck = getColumnRowsDiagonals(lastInput, popOut);
        return checkAlignments(linesToCheck, "R") || checkAlignments(linesToCheck, "Y");
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

    private boolean checkAlignments(ArrayList<List<String>> linesToCheck, String color) {
        List<String> alignment = alignmentOfLengthFour(color);
        return linesToCheck.stream()
                           .anyMatch(line -> contains(line, alignment));
    }

    private List<String> alignmentOfLengthFour(String label) {
        return Arrays.asList(label, label, label, label);
    }

    private boolean contains(List<String> line, List<String> alignment) {
        return Collections.indexOfSubList(line, alignment) != -1;
    }

    public String winner(int lastInput, boolean popOut) {
        ArrayList<List<String>> linesToCheck = getColumnRowsDiagonals(lastInput, popOut);
        if (checkAlignments(linesToCheck, "R"))
            return "R";
        return "Y";
    }
}
