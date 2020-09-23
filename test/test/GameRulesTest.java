import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameRulesTest {

    Board board = new Board(6, 7);
    GameRules rules = new GameRules(board);

    @Test
    void connectFourHorizontalTest() {
        board.insertPieceInColumn("Y", 1);
        board.insertPieceInColumn("Y", 2);
        board.insertPieceInColumn("Y", 3);
        board.insertPieceInColumn("Y", 4);

        assertFalse(rules.connectFour(4, false));
    }

    @Test
    void connectFourHorizontalTest2() {
        board.insertPieceInColumn("Y", 1);
        board.insertPieceInColumn("Y", 2);
        board.insertPieceInColumn("Y", 3);
        board.insertPieceInColumn("Y", 6);

        assertFalse(rules.connectFour(3, false));
    }

    @Test
    void connectFourHorizontalTest3() {
        board.insertPieceInColumn("Y", 1);
        board.insertPieceInColumn("R", 2);
        board.insertPieceInColumn("Y", 4);
        board.insertPieceInColumn("Y", 5);
        board.insertPieceInColumn("Y", 6);
        board.insertPieceInColumn("Y", 7);

        assertFalse(rules.connectFour(5, false));
    }

    @Test
    void connectFourVerticalTest() {
        board.insertPieceInColumn("Y", 2);
        board.insertPieceInColumn("Y", 2);
        board.insertPieceInColumn("Y", 2);
        board.insertPieceInColumn("Y", 2);

        assertFalse(rules.connectFour(2, false));
    }

    @Test
    void connectFourVerticalTest2() {
        board.insertPieceInColumn("Y", 7);
        board.insertPieceInColumn("Y", 7);
        board.insertPieceInColumn("Y", 7);
        board.insertPieceInColumn("R", 7);
        board.insertPieceInColumn("Y", 7);

        assertFalse(rules.connectFour(7, false));
    }

    @Test
    void connectFourDiagonalTest() {
        board.insertPieceInColumn("Y", 1);
        board.insertPieceInColumn("R", 1);
        board.insertPieceInColumn("Y", 1);
        board.insertPieceInColumn("R", 1);
        board.insertPieceInColumn("Y", 1);
        board.insertPieceInColumn("R", 2);
        board.insertPieceInColumn("Y", 2);
        board.insertPieceInColumn("R", 2);
        board.insertPieceInColumn("Y", 2);
        board.insertPieceInColumn("R", 3);
        board.insertPieceInColumn("Y", 3);
        board.insertPieceInColumn("R", 4);
        board.insertPieceInColumn("Y", 4);
        board.insertPieceInColumn("R", 5);
        board.insertPieceInColumn("Y", 3);

        assertTrue(rules.connectFour(3, false));
    }

    @Test
    void connectFourAntiDiagonalTest() {
        board.insertPieceInColumn("Y", 1);
        board.insertPieceInColumn("R", 2);
        board.insertPieceInColumn("Y", 2);
        board.insertPieceInColumn("R", 2);
        board.insertPieceInColumn("Y", 3);
        board.insertPieceInColumn("R", 3);
        board.insertPieceInColumn("Y", 3);
        board.insertPieceInColumn("R", 4);
        board.insertPieceInColumn("Y", 4);
        board.insertPieceInColumn("R", 4);
        board.insertPieceInColumn("Y", 4);

        assertTrue(rules.connectFour(4, false));
    }

    @Test
    void connectFourPopTest() {
        board.insertPieceInColumn("Y", 1);
        board.insertPieceInColumn("Y", 2);
        board.insertPieceInColumn("Y", 4);
        board.insertPieceInColumn("R", 3);
        board.insertPieceInColumn("Y", 3);
        board.insertPieceInColumn("R", 3);
        board.popOut(3);

        assertFalse(rules.connectFour(3, true));
    }

    @Test
    void connectFourPopTest2() {
        board.insertPieceInColumn("Y", 1);
        board.insertPieceInColumn("R", 1);
        board.insertPieceInColumn("Y", 1);
        board.insertPieceInColumn("R", 1);
        board.insertPieceInColumn("Y", 2);
        board.insertPieceInColumn("R", 3);
        board.insertPieceInColumn("Y", 2);
        board.insertPieceInColumn("R", 2);
        board.insertPieceInColumn("Y", 3);
        board.insertPieceInColumn("R", 3);
        board.insertPieceInColumn("Y", 3);
        board.insertPieceInColumn("R", 4);
        board.insertPieceInColumn("Y", 4);
        board.popOut(3);

        assertTrue(rules.connectFour(3, true));
    }
}
