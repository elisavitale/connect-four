import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(c.isFull());
    }

    @Test
    void isFullTest2() {
        Column c = new Column(6);
        c.insert("R");
        c.insert("Y");
        c.insert("R");
        c.insert("Y");

        assertFalse(c.isFull());
    }

    @Test
    void getPieceTest() {
        Column c = new Column(6);
        c.insert("R");
        c.insert("Y");
        assertEquals("R", c.getPieceAtRow(6));
    }

    @Test
    void getPieceTest2() {
        Column c = new Column(6);
        c.insert("R");
        c.insert("Y");
        assertEquals(" ", c.getPieceAtRow(3));
    }
}
