public class Board {
    static String[][] board;

    Board() {
        board = new String[6][7];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 7; j++)
                board[i][j] = " ";
    }

    public void printBoard() {
        for (int i = 0; i < 6; i++) {
            printRow(i);
        }
    }

    public static void printRow(int i) {
        for (int j = 0; j < 7; j++)
            System.out.print("|" + board[i][j]);
        System.out.print("|\n");
    }

    public static void main(String[] args) {
        Board b = new Board();
        b.printBoard();
    }
}
