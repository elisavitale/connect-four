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

    public boolean connectFour() {
        ArrayList<ArrayList<String>> allRowsColumns = getAllRowsColumns();
        return allRowsColumns.stream()
                             .anyMatch(x -> containsAlignment(x, y) || containsAlignment(x, r));
    }

    private ArrayList<ArrayList<String>> getAllRowsColumns() {
        ArrayList<ArrayList<String>> allRowsColumns = new ArrayList<>();
        for (int i = 1; i <= board.numberOfRows; i++)
            allRowsColumns.add(board.getRow(i));
        for (int i = 1; i <= board.numberOfColumns; i++)
            allRowsColumns.add(board.getColumn(i - 1));
        return allRowsColumns;
    }

    private boolean containsAlignment(ArrayList<String> list, List<String> alignment) {
        return Collections.indexOfSubList(list, alignment) != -1;
    }
}
