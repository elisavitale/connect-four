import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoardRules {
    Board board;
    private List<String> y = Arrays.asList("Y", "Y", "Y", "Y");
    private List<String> r = Arrays.asList("R", "R", "R", "R");

    BoardRules(Board board) {
        this.board = board;
    }

    public boolean connectFourHorizontal() {
        ArrayList<Boolean> rowValues = new ArrayList<>();
        for (int i = 1; i <= board.numberOfRows; i++)
            rowValues.add(checkRow(i));
        return rowValues.contains(true);
    }

    public boolean checkRow(int index) {
        ArrayList<String> row = board.getRow(index);
        return Collections.indexOfSubList(row, y) != -1 || Collections.indexOfSubList(row, r) != -1;
    }

    public boolean connectFourVertical() {
        ArrayList<Boolean> columnValues = new ArrayList<>();
        for (int i = 1; i <= board.numberOfColumns; i++)
            columnValues.add(checkColumn(i));
        return columnValues.contains(true);
    }

    public boolean checkColumn(int index) {
        ArrayList<String> column = board.getColumn(index - 1);
        return Collections.indexOfSubList(column, y) != -1 || Collections.indexOfSubList(column, r) != -1;
    }
}
