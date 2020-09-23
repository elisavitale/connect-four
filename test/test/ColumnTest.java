import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ColumnTest {

    Column column = new Column(6);

    @Test
    void insertTest() {
        column.insert("R");
        assertEquals("R", column.lastPiece());
    }

    @Test
    void insertTwiceTest() {
        column.insert("R");
        column.insert("Y");
        assertEquals("Y", column.lastPiece());
    }

    @Test
    void isFullTest() {
        column.insert("R");
        column.insert("Y");
        column.insert("R");
        column.insert("Y");
        column.insert("R");
        column.insert("Y");
        assertTrue(column.isFull());
    }

    @Test
    void isFullTest2() {
        column.insert("R");
        column.insert("Y");
        column.insert("R");
        column.insert("Y");

        assertFalse(column.isFull());
    }

    @Test
    void getPieceTest() {
        column.insert("R");
        column.insert("Y");
        assertEquals("R", column.getPieceAtRow(6));
    }

    @Test
    void getPieceTest2() {
        column.insert("R");
        column.insert("Y");
        assertEquals(" ", column.getPieceAtRow(3));
    }

    @Test
    void popOutTest() {
        column.insert("R");
        column.insert("Y");
        column.insert("R");
        column.insert("R");
        column.popOut();
        List<String> expectedColumn = List.of("Y", "R", "R");
        assertEquals(expectedColumn, column.getColumn());
    }
}
