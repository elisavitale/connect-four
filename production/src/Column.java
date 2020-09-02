import java.util.ArrayList;

public class Column {
    private ArrayList<String> column;
    private int maxSize;

    Column(int size) {
        this.maxSize = size;
        column = new ArrayList<>();
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
        return column.size() == maxSize;
    }

    public String getPieceAtRow(int index) {
        if (maxSize - index >= column.size())
            return " ";
        else
            return column.get(maxSize - index);
    }

    public int currentSize() {
        return column.size();
    }
}
