import java.lang.reflect.Array;
import java.util.stream.Stream;

public class Column {
    String[] array;
    int s;

    Column(int size) {
        s = size;
        array = new String[size];
        initializeColumn();
    }

    public void initializeColumn() {
        for (int i = 0; i < s; i++)
            array[i] = " ";
    }

    public void insert(String piece) {
        if (!isFull()) {
            array[findNextIndex()] = piece;
        }
    }

    public boolean isFull() {
        Stream<String> str = Stream.of(array);
        return str.noneMatch(x -> x.equals(" "));
    }

    public int findNextIndex() {
        int ind = 0;
        for (int i = 5; i >= 0; i--) {
            if (array[i].equals(" ")){
                ind = i;
                break;
            }
        }
        return ind;
    }
}
