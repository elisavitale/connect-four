import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    Board b = new Board(6, 7);
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void printBoardTest() {
        System.setOut(new PrintStream(outContent));
        b.printBoard();

        String expectedOutput  = " 1 2 3 4 5 6 7 \n"+
                                 "| | | | | | | |\n" +
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

        String expectedOutput  = " 1 2 3 4 5 6 7 \n" +
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n" +
                                 "| | | |Y| | | |\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    void insertPiecesExample() {
        b.insertPieceInColumn("Y", 4);
        b.insertPieceInColumn("R", 7);
        b.insertPieceInColumn("Y", 1);
        b.insertPieceInColumn("R", 3);
        b.insertPieceInColumn("Y", 3);
        b.insertPieceInColumn("R", 4);
        b.insertPieceInColumn("Y", 4);
        b.insertPieceInColumn("R", 7);
        b.insertPieceInColumn("Y", 7);
        b.insertPieceInColumn("R", 6);
        b.insertPieceInColumn("Y", 6);
    }

    @Test
    void insertSeveralPiecesTest() {
        System.setOut(new PrintStream(outContent));
        insertPiecesExample();
        b.printBoard();

        String expectedOutput  = " 1 2 3 4 5 6 7 \n" +
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n" +
                                 "| | | | | | | |\n" +
                                 "| | | |Y| | |Y|\n" +
                                 "| | |Y|R| |Y|R|\n" +
                                 "|Y| |R|Y| |R|R|\n";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void getRowTest() {
        insertPiecesExample();
        List<String> row = Arrays.asList("Y", " ", "R", "Y", " ", "R", "R");
        assertEquals(b.getRow(6), row);
    }

    @Test
    void getRowTest2() {
        insertPiecesExample();
        List<String> row = Arrays.asList(" ", " ", "Y", "R", " ", "Y", "R");
        assertEquals(b.getRow(5), row);
    }

    @Test
    void getDiagonalTest() {
        insertPiecesExample();

        List<String> diagonal = Arrays.asList(" ", " ", "Y", "Y");
        assertEquals(b.getDiagonal(5, 2, false), diagonal);
    }

    @Test
    void getDiagonalTest2() {
        insertPiecesExample();

        List<String> diagonal = Arrays.asList(" ", " ", " ", " ", "Y", "R");
        assertEquals(diagonal, b.getDiagonal(6, 6, false));
    }

    @Test
    void getAntiDiagonalTest() {
        insertPiecesExample();

        List<String> diagonal = Arrays.asList(" ", "Y", "Y", " ", " ", " ");
        assertEquals(diagonal, b.getDiagonal(5, 2, true));
    }
}
