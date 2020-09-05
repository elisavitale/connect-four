import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardRulesTest {

    Board b = new Board(6, 7);
    BoardRules rules = new BoardRules(b);

    @Test
    void connectFourHorizontalTest() {
        b.insertPieceInColumn("Y", 1);
        b.insertPieceInColumn("Y", 2);
        b.insertPieceInColumn("Y", 3);
        b.insertPieceInColumn("Y", 4);

        assertTrue(rules.connectFour(4));
    }

    @Test
    void connectFourHorizontalTest2() {
        b.insertPieceInColumn("Y", 1);
        b.insertPieceInColumn("Y", 2);
        b.insertPieceInColumn("Y", 3);
        b.insertPieceInColumn("Y", 6);

        assertFalse(rules.connectFour(3));
    }

    @Test
    void connectFourHorizontalTest3() {
        b.insertPieceInColumn("Y", 1);
        b.insertPieceInColumn("R", 2);
        b.insertPieceInColumn("Y", 4);
        b.insertPieceInColumn("Y", 5);
        b.insertPieceInColumn("Y", 6);
        b.insertPieceInColumn("Y", 7);

        assertTrue(rules.connectFour(5));
    }

    @Test
    void connectFourVerticalTest() {
        b.insertPieceInColumn("Y", 2);
        b.insertPieceInColumn("Y", 2);
        b.insertPieceInColumn("Y", 2);
        b.insertPieceInColumn("Y", 2);

        assertTrue(rules.connectFour(2));
    }

    @Test
    void connectFourVerticalTest2() {
        b.insertPieceInColumn("Y", 7);
        b.insertPieceInColumn("Y", 7);
        b.insertPieceInColumn("Y", 7);
        b.insertPieceInColumn("R", 7);
        b.insertPieceInColumn("Y", 7);

        assertFalse(rules.connectFour(7));
    }

    @Test
    void connectFourDiagonalTest() {
        b.insertPieceInColumn("Y", 1);
        b.insertPieceInColumn("R", 1);
        b.insertPieceInColumn("Y", 1);
        b.insertPieceInColumn("R", 1);
        b.insertPieceInColumn("Y", 1);
        b.insertPieceInColumn("R", 2);
        b.insertPieceInColumn("Y", 2);
        b.insertPieceInColumn("R", 2);
        b.insertPieceInColumn("Y", 2);
        b.insertPieceInColumn("R", 3);
        b.insertPieceInColumn("Y", 3);
        b.insertPieceInColumn("R", 4);
        b.insertPieceInColumn("Y", 4);
        b.insertPieceInColumn("R", 5);
        b.insertPieceInColumn("Y", 3);

        assertTrue(rules.connectFour(3));
    }


}
