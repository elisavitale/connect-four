import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColumnTest {

    @Test
    void insertTest() {
        Column c = new Column(6);
        c.insert("R");
        assertEquals("R", c.array[5]);
    }
}
