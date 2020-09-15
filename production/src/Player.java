import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    String color;
    private Board board;
    private Scanner input = new Scanner(System.in);

    Player(Board board) {
        this.board = board;
        this.color = chooseColor();
    }

    Player(Board board, String color) {
        this.board = board;
        this.color = color;
    }

    public String chooseColor() {
        String color = "";
        while (!colorIsAcceptable(color)) {
            System.out.print("Choose a color (R = red, Y = yellow): ");
            color = input.nextLine();
        }
        return color;
    }

    private boolean colorIsAcceptable(String color) {
        return color.equals("Y") || color.equals("R");
    }

    public int chooseColumn() {
        int column = 0;
        while (!columnIsAcceptable(column)) {
            System.out.print("Choose a column (1-" + board.numberOfColumns + "): ");
            column = handleNumericInput(column);
        }
        return column;
    }

    private boolean columnIsAcceptable(int column) {
        return column >= 1 && column <= board.numberOfColumns && !columnIsFull(column);
    }

    private boolean columnIsFull(int column) {
        return board.currentSizeOfColumn(column) == 6;
    }

    private int handleNumericInput(int column) {
        try {
            column = input.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Input has to be an integer from 1 to " + board.numberOfColumns + ".");
            input.nextLine();
        }
        return column;
    }

    public String chooseGameMode() {
        String gameMode = "";
        while (!gameMode.equals("FOUR") && !gameMode.equals("POP")) {
            System.out.println("Choose a game mode. Type FOUR to play Connect Four or POP to play Pop Out: ");
            gameMode = input.nextLine();
        }
        return gameMode;
    }
}
