import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    Board b = new Board(6, 7);
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void printBoardTest() {
        System.setOut(new PrintStream(outContent));

        b.printBoard();

        String expectedOutput  = "| | | | | | | |\n" +
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void insertOnePieceTest() {
        System.setOut(new PrintStream(outContent));

        b.insertPieceInColumn("Y", 4);
        b.printBoard();

        String expectedOutput  = "| | | | | | | |\n" +
                "| | | | | | | |\n" +
                "| | | | | | | |\n" +
                "| | | | | | | |\n" +
                "| | | | | | | |\n" +
                "| | | |Y| | | |\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void insertSeveralPiecesTest() {
        System.setOut(new PrintStream(outContent));

        b.insertPieceInColumn("Y", 4);
        b.insertPieceInColumn("R", 7);
        b.insertPieceInColumn("Y", 1);
        b.insertPieceInColumn("R", 3);
        b.insertPieceInColumn("Y", 3);
        b.insertPieceInColumn("R", 4);
        b.insertPieceInColumn("Y", 4);
        b.printBoard();

        String expectedOutput  = "| | | | | | | |\n" +
                "| | | | | | | |\n" +
                "| | | | | | | |\n" +
                "| | | |Y| | | |\n" +
                "| | |Y|R| | | |\n" +
                "|Y| |R|Y| | |R|\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void getRowTest() {
        b.insertPieceInColumn("Y", 4);
        b.insertPieceInColumn("R", 7);
        b.insertPieceInColumn("Y", 1);
        b.insertPieceInColumn("R", 3);

        ArrayList<String> row = new ArrayList<>();
        row.add("Y");
        row.add(" ");
        row.add("R");
        row.add("Y");
        row.add(" ");
        row.add(" ");
        row.add("R");

        assertTrue(row.equals(b.getRow(6)));
    }

    @Test
    void emptyRowTest() {
        assertTrue(b.emptyRow(1));
    }
}
