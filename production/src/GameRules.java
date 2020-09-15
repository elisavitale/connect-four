import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameRules {
    private Board board;

    GameRules(Board board) {
        this.board = board;
    }

    public boolean connectFour(int lastInput) {
        ArrayList<List<String>> rowColDiag = getCurrentRowColumnDiagonals(lastInput);
        List<String> fourR = alignmentOfLength("R", 4);
        List<String> fourY = alignmentOfLength("Y", 4);
        return rowColDiag.stream()
                         .anyMatch(x -> containsAlignment(x, fourR) || containsAlignment(x, fourY));
    }

    private ArrayList<List<String>> getCurrentRowColumnDiagonals(int columnIndex) {
        int rowIndex = currentRowIndex(columnIndex);
        ArrayList<List<String>> rowColDiag = new ArrayList<>();
        rowColDiag.add(board.getColumn(columnIndex));
        rowColDiag.add(board.getRow(rowIndex));
        rowColDiag.add(board.getDiagonal(rowIndex, columnIndex, false));
        rowColDiag.add(board.getDiagonal(rowIndex, columnIndex, true));
        return rowColDiag;
    }

    private int currentRowIndex(int column) {
        return board.numberOfRows - board.sizeOfColumn(column) + 1;
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
