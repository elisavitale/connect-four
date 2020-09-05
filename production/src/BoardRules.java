import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoardRules {
    private Board board;
    private List<String> y = Arrays.asList("Y", "Y", "Y", "Y");
    private List<String> r = Arrays.asList("R", "R", "R", "R");

    BoardRules(Board board) {
        this.board = board;
    }

    public boolean connectFour(int input) {
        ArrayList<List<String>> rowColDiag = getRowColDiag(input);
        return rowColDiag.stream()
                         .anyMatch(x -> containsAlignment(x, y) || containsAlignment(x, r));
    }

    private ArrayList<List<String>> getRowColDiag(int columnIndex) {
        columnIndex--;
        int rowIndex = board.numberOfRows - board.currentColumnSizes()[columnIndex] + 1;
        ArrayList<List<String>> output = new ArrayList<>();
        output.add(board.getColumn(columnIndex));
        output.add(board.getRow(rowIndex));
        output.add(board.getDiagonal(rowIndex, columnIndex, false));
        output.add(board.getDiagonal(rowIndex, columnIndex, true));
        return output;
    }

    private boolean containsAlignment(List<String> list, List<String> alignment) {
        return Collections.indexOfSubList(list, alignment) != -1;
    }
}
