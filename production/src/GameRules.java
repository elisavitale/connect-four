import java.util.*;
import java.util.stream.IntStream;

public class GameRules {
    private Board board;

    GameRules(Board board) {
        this.board = board;
    }

    public boolean connectFour(int lastInput, boolean popOut) {
        ArrayList<List<String>> diagonals = getDiagonals(lastInput, popOut);
        return checkAlignments(diagonals, "R") || checkAlignments(diagonals, "Y");
    }

    private ArrayList<List<String>> getDiagonals(int column, boolean popOut) {
        ArrayList<List<String>> diagonals = new ArrayList<>();
        for (int row : getRowIndexes(column, popOut)) {
            diagonals.add(board.getDiagonal(row, column, false));
            diagonals.add(board.getDiagonal(row, column, true));
        }
        return diagonals;
    }

    private int[] getRowIndexes(int column, boolean popOut) {
        if (popOut) return IntStream.range(firstNonemptyRow(column), board.numberOfRows + 1)
                                    .toArray();
        else return new int[] {firstNonemptyRow(column)};
    }

    private int firstNonemptyRow(int column) {
        return board.numberOfRows - board.currentSizeOfColumn(column) + 1;
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
        ArrayList<List<String>> diagonals = getDiagonals(lastInput, popOut);
        if (checkAlignments(diagonals, "R"))
            return "R";
        return "Y";
    }
}
