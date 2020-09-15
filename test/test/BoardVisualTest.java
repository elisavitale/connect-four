import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardVisualTest {

    Board board = new Board(6, 7);
    BoardVisual bv = new BoardVisual(board);
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void printBoardTest() {
        System.setOut(new PrintStream(outContent));
        bv.printBoard();

        String expectedOutput  = " 1 2 3 4 5 6 7 \n"+
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}
