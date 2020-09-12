import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    String color;
    private Scanner input = new Scanner(System.in);
    Board board;

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
            column = handleColumnInput(column);
        }
        return column;
    }

    private boolean columnIsAcceptable(int column) {
        return column >= 1 && column <= board.numberOfColumns;
    }

    private int handleColumnInput(int column) {
        try {
            column = input.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Input has to be an integer from 1 to " + board.numberOfColumns + ".");
            input.nextLine();
        }
        return column;
    }
}
