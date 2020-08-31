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

    @Test
    void getPieceTest() {
        Column c = new Column(6);
        c.insert("R");
        c.insert("Y");
        assertEquals("R", c.getPiece(1));
    }

    @Test
    void getPieceTest2() {
        Column c = new Column(6);
        c.insert("R");
        c.insert("Y");
        assertEquals(" ", c.getPiece(4));
    }
}
