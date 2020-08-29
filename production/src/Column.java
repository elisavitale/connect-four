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
}
