import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameRules {
    private Board board;
    private List<String> fourY = Arrays.asList("Y", "Y", "Y", "Y");
    private List<String> fourR = Arrays.asList("R", "R", "R", "R");

    GameRules(Board board) {
        this.board = board;
    }

    public boolean connectFour(int input) {
        ArrayList<List<String>> rowColDiag = getCurrentRowColumnDiagonals(input);
        return rowColDiag.stream()
                         .anyMatch(x -> containsAlignment(x, fourY) || containsAlignment(x, fourR));
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
}
