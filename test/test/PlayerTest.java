import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Board board = new Board(6, 7);

    public void setInputStream(String testInput) {
        InputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(inputStream);
    }

    @Test
    public void chooseColorTest() {
        String testInput = "Y";
        setInputStream(testInput);
        Player player = new Player(board);

        assertEquals("Y", player.color);
    }

    @Test
    public void chooseColorTest2() {
        String testInput = "WrongInput"
                         + "\n1234567890"
                         + "\nInput with spaces"
                         + "\nR";
        setInputStream(testInput);
        Player player = new Player(board);

        assertEquals("R", player.color);
    }

    @Test
    public void chooseColumn() {
        String testInput = "WrongInput"
                         + "\n1234567890"
                         + "\n6";
        setInputStream(testInput);
        Player player = new Player(board, "R");
        int column = player.chooseColumn();

        assertEquals(6, column);
    }
}
