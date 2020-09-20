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
        String testInput = "3";
        setInputStream(testInput);
        Player player = new Player(board, "R");
        int column = player.chooseColumn(false);

        assertEquals(3, column);
    }

    @Test
    public void chooseColumn2() {
        String testInput = "WrongInput"
                         + "\n1234567890"
                         + "\n6";
        setInputStream(testInput);
        Player player = new Player(board, "R");
        int column = player.chooseColumn(false);

        assertEquals(6, column);
    }

    @Test
    public void chooseGameModeTest() {
        String testInput = "FOUR";
        setInputStream(testInput);
        Player player = new Player(board, "R");
        String gameMode = player.chooseGameMode();

        assertEquals("FOUR", gameMode);
    }

    @Test
    public void chooseInsertOrPopTest() {
        Player player = new Player(board, "R");
        String expected = "INSERT";

        assertEquals(expected, player.chooseInsertOrPop());
    }

    @Test
    public void chooseInsertOrPopTest2() {
        Player player = new Player(board, "R");

        board.insertPieceInColumn("Y", 1);
        board.insertPieceInColumn("Y", 2);
        board.insertPieceInColumn("Y", 3);
        board.insertPieceInColumn("Y", 4);
        board.insertPieceInColumn("Y", 5);
        board.insertPieceInColumn("Y", 6);
        board.insertPieceInColumn("Y", 7);

        String testInput = "POP"
                         + "\nINSERT";
        setInputStream(testInput);
        String output = player.chooseInsertOrPop();
        String expectedOutput = "INSERT";
        assertEquals(expectedOutput, output);
    }

    @Test
    public void chooseInsertOrPopTest3() {
        Player player = new Player(board, "R");

        board.insertPieceInColumn("Y", 1);
        board.insertPieceInColumn("R", 2);
        board.insertPieceInColumn("Y", 3);
        board.insertPieceInColumn("R", 4);
        board.insertPieceInColumn("Y", 5);
        board.insertPieceInColumn("R", 6);

        String testInput = "POP";
        setInputStream(testInput);
        String output = player.chooseInsertOrPop();
        String expectedOutput = "POP";
        assertEquals(expectedOutput, output);
    }

    @Test
    public void chooseColumnToPopTest() {
        board.insertPieceInColumn("Y", 1);
        board.insertPieceInColumn("R", 2);
        board.insertPieceInColumn("Y", 3);
        board.insertPieceInColumn("R", 4);
        board.insertPieceInColumn("Y", 5);
        board.insertPieceInColumn("R", 6);

        String testInput = "1"
                         + "\n3"
                         + "\n5"
                         + "\n2";
        setInputStream(testInput);
        Player player = new Player(board, "R");
        int column = player.chooseColumn(true);

        assertEquals(2, column);
    }
}
