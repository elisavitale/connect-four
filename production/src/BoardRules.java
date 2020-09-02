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
        ArrayList<ArrayList<String>> currentRowColumn = getCurrentRowColumn(input);
        return currentRowColumn.stream()
                .anyMatch(x -> containsAlignment(x, y) || containsAlignment(x, r));
    }

    private ArrayList<ArrayList<String>> getCurrentRowColumn(int input) {
        ArrayList<ArrayList<String>> output = new ArrayList<>();
        output.add(board.getColumn(input - 1));
        int currentRowIndex = board.numberOfRows - board.columnSizes().get(input - 1) + 1;
        output.add(board.getRow(currentRowIndex));
        return output;
    }

    private boolean containsAlignment(ArrayList<String> list, List<String> alignment) {
        return Collections.indexOfSubList(list, alignment) != -1;
    }
}
