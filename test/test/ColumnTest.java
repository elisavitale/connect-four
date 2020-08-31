import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColumnTest {

    @Test
    void insertTest() {
        Column c = new Column(6);
        c.insert("R");
        assertEquals("R", c.lastPiece());
    }

    @Test
    void insertTwiceTest() {
        Column c = new Column(6);
        c.insert("R");
        c.insert("Y");
        assertEquals("Y", c.lastPiece());
    }

    @Test
    void isFullTest() {
        Column c = new Column(6);
        c.insert("R");
        c.insert("Y");
        c.insert("R");
        c.insert("Y");
        c.insert("R");
        c.insert("Y");
        assertEquals(true, c.isFull());
    }
}
