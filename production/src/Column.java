import java.util.ArrayList;

public class Column {
    private ArrayList<String> column;
    private int maxSize;

    Column(int size) {
        maxSize = size;
        column = new ArrayList<>();
    }

    public ArrayList<String> getColumn() {
        return column;
    }

    public void insert(String piece) {
        column.add(piece);
    }

    public boolean isFull() {
        return currentSize() == maxSize;
    }

    public int currentSize() {
        return column.size();
    }

    public String lastPiece() {
        if (currentSize() == 0)
            return " ";
        else
            return column.get(currentSize() - 1);
    }

    public String getPieceAtRow(int index) {
        if (maxSize - index >= currentSize())
            return " ";
        else
            return column.get(maxSize - index);
    }
}
