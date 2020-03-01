public class Game {
    private static Board board;
    private static Player player1;
    private static Player player2;

    public static void main(String[] args) {
        String color1 = Player.chooseColor();
        String color2 = Player.chooseColor();

        Board.printBoard();
    }
}
