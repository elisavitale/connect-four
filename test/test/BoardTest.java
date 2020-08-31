import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    void printBoardTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Board b = new Board(6, 7);
        b.printBoard();

        String expectedOutput  = "| | | | | | | |\n" +
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}
