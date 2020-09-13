import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BoardTest {

    Board board = new Board(6, 7);

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void printBoardTest() {
        System.setOut(new PrintStream(outContent));
        board.printBoard();

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
        board.insertPieceInColumn("Y", 4);
        board.printBoard();

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
        board.insertPieceInColumn("Y", 4);
        board.insertPieceInColumn("R", 7);
        board.insertPieceInColumn("Y", 1);
        board.insertPieceInColumn("R", 3);
        board.insertPieceInColumn("Y", 3);
        board.insertPieceInColumn("R", 4);
        board.insertPieceInColumn("Y", 4);
        board.insertPieceInColumn("R", 7);
        board.insertPieceInColumn("Y", 7);
        board.insertPieceInColumn("R", 6);
        board.insertPieceInColumn("Y", 6);
    }

    @Test
    void insertSeveralPiecesTest() {
        System.setOut(new PrintStream(outContent));
        insertPiecesExample();
        board.printBoard();

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
        assertEquals(board.getRow(6), row);
    }

    @Test
    void getRowTest2() {
        insertPiecesExample();
        List<String> row = Arrays.asList(" ", " ", "Y", "R", " ", "Y", "R");
        assertEquals(board.getRow(5), row);
    }

    @Test
    void getDiagonalTest() {
        insertPiecesExample();

        List<String> diagonal = Arrays.asList(" ", " ", "Y", "Y");
        assertEquals(board.getDiagonal(5, 3, false), diagonal);
    }

    @Test
    void getDiagonalTest2() {
        insertPiecesExample();

        List<String> diagonal = Arrays.asList(" ", " ", " ", " ", "Y", "R");
        assertEquals(diagonal, board.getDiagonal(6, 7, false));
    }

    @Test
    void getAntiDiagonalTest() {
        insertPiecesExample();

        List<String> diagonal = Arrays.asList(" ", "Y", "Y", " ", " ", " ");
        assertEquals(diagonal, board.getDiagonal(5, 3, true));
    }

    @Test
    void isFullTest() {
        insertPiecesExample();
        assertFalse(board.isFull());
    }
}
