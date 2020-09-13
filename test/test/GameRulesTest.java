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

        assertTrue(rules.connectFour(4));
    }

    @Test
    void connectFourHorizontalTest2() {
        board.insertPieceInColumn("Y", 1);
        board.insertPieceInColumn("Y", 2);
        board.insertPieceInColumn("Y", 3);
        board.insertPieceInColumn("Y", 6);

        assertFalse(rules.connectFour(3));
    }

    @Test
    void connectFourHorizontalTest3() {
        board.insertPieceInColumn("Y", 1);
        board.insertPieceInColumn("R", 2);
        board.insertPieceInColumn("Y", 4);
        board.insertPieceInColumn("Y", 5);
        board.insertPieceInColumn("Y", 6);
        board.insertPieceInColumn("Y", 7);

        assertTrue(rules.connectFour(5));
    }

    @Test
    void connectFourVerticalTest() {
        board.insertPieceInColumn("Y", 2);
        board.insertPieceInColumn("Y", 2);
        board.insertPieceInColumn("Y", 2);
        board.insertPieceInColumn("Y", 2);

        assertTrue(rules.connectFour(2));
    }

    @Test
    void connectFourVerticalTest2() {
        board.insertPieceInColumn("Y", 7);
        board.insertPieceInColumn("Y", 7);
        board.insertPieceInColumn("Y", 7);
        board.insertPieceInColumn("R", 7);
        board.insertPieceInColumn("Y", 7);

        assertFalse(rules.connectFour(7));
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

        assertTrue(rules.connectFour(3));
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

        assertTrue(rules.connectFour(4));
    }
}
