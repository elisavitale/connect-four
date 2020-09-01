import java.util.ArrayList;

public class Column {
    private ArrayList<String> column;
    private int size;

    Column(int size) {
        this.size = size;
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
        return column.size() == size;
    }

    public String getPiece(int index) {
        if (size - index >= column.size())
            return " ";
        else
            return column.get(size - index);
    }
}
