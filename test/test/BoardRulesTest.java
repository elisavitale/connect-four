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

        assertTrue(rules.connectFourHorizontal());
    }

    @Test
    void connectFourHorizontalTest2() {
        b.insertPieceInColumn("Y", 1);
        b.insertPieceInColumn("Y", 2);
        b.insertPieceInColumn("Y", 3);
        b.insertPieceInColumn("Y", 6);

        assertFalse(rules.connectFourHorizontal());
    }

    @Test
    void connectFourHorizontalTest3() {
        b.insertPieceInColumn("Y", 1);
        b.insertPieceInColumn("R", 2);
        b.insertPieceInColumn("Y", 4);
        b.insertPieceInColumn("Y", 5);
        b.insertPieceInColumn("Y", 6);
        b.insertPieceInColumn("Y", 7);

        assertTrue(rules.connectFourHorizontal());
    }

    @Test
    void connectFourVerticalTest() {
        b.insertPieceInColumn("Y", 2);
        b.insertPieceInColumn("Y", 2);
        b.insertPieceInColumn("Y", 2);
        b.insertPieceInColumn("Y", 2);

        assertTrue(rules.connectFourVertical());
    }

    @Test
    void connectFourVerticalTest2() {
        b.insertPieceInColumn("Y", 7);
        b.insertPieceInColumn("Y", 7);
        b.insertPieceInColumn("Y", 7);
        b.insertPieceInColumn("R", 7);
        b.insertPieceInColumn("Y", 7);

        assertTrue(rules.connectFourVertical());
    }
}
