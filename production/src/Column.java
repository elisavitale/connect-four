import java.util.ArrayList;

public class Column {
    private ArrayList<String> column;
    private int s;

    Column(int size) {
        s = size;
        column = new ArrayList<>(size);
    }

    public String lastPiece() {
        if (column.size() == 0)
            return " ";
        else
            return column.get(column.size() - 1);
    }

    public void insert(String piece) {
        if (!isFull())
            column.add(piece);
    }

    public boolean isFull() {
        return column.size() == s;
    }
}
