import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoardRules {
    Board board;

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
        List<String> y = Arrays.asList("Y", "Y", "Y", "Y");
        List<String> r = Arrays.asList("R", "R", "R", "R");
        return Collections.indexOfSubList(row, y) != -1 || Collections.indexOfSubList(row, r) != -1;
    }
}
