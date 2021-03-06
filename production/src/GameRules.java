import java.util.*;
import java.util.stream.IntStream;

public class GameRules {
    private Board board;

    GameRules(Board board) {
        this.board = board;
    }

    public boolean gameOver(Player currentPlayer, boolean popOutMode) {
        if (popOutMode) return !playerCanMove(currentPlayer);
        else return board.isFull();
    }

    public boolean playerCanMove(Player player) {
        return popIsAvailable(player) || insertIsAvailable();
    }

    public boolean insertIsAvailable() {
        return !board.isFull();
    }

    public boolean popIsAvailable(Player player) {
        int bottomRow = board.numberOfRows;
        return board.getRow(bottomRow)
                    .contains(player.color);
    }

    public boolean connectFour(int lastInput, boolean pop) {
        ArrayList<List<String>> lines = getLinesToCheck(lastInput, pop);
        return containWinningAlignment(lines, "R") || containWinningAlignment(lines, "Y");
    }

    private ArrayList<List<String>> getLinesToCheck(int column, boolean pop) {
        ArrayList<List<String>> lines = new ArrayList<>();
        lines.add(board.getColumn(column));
        for (int row : getRowIndexes(column, pop)) {
            lines.add(board.getRow(row));
            lines.add(board.getDiagonal(row, column, false));
            lines.add(board.getDiagonal(row, column, true));
        }
        return lines;
    }

    private int[] getRowIndexes(int column, boolean pop) {
        if (pop) return IntStream.range(firstNonemptyRow(column), board.numberOfRows + 1)
                                 .toArray();
        else return new int[] {firstNonemptyRow(column)};
    }

    private int firstNonemptyRow(int column) {
        return board.numberOfRows - board.currentSizeOfColumn(column) + 1;
    }

    private boolean containWinningAlignment(ArrayList<List<String>> linesToCheck, String color) {
        List<String> alignment = alignmentOfLengthFour(color);
        return linesToCheck.stream()
                           .anyMatch(line -> contains(line, alignment));
    }

    private List<String> alignmentOfLengthFour(String color) {
        return Arrays.asList(color, color, color, color);
    }

    private boolean contains(List<String> line, List<String> alignment) {
        return Collections.indexOfSubList(line, alignment) != -1;
    }

    public String winner(int lastInput, boolean pop) {
        ArrayList<List<String>> lines = getLinesToCheck(lastInput, pop);
        if (containWinningAlignment(lines, "R"))
            return "R";
        return "Y";
    }
}
