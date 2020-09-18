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
        String red = "R";
        String yellow = "Y";
        System.out.print("Choose a color (R = red, Y = yellow): ");
        return chooseBetween(red, yellow);
    }

    public String chooseGameMode() {
        String connectFour = "FOUR";
        String popOut = "POP";
        System.out.print("Choose a game mode. Type FOUR to play Connect Four or POP to play Pop Out: ");
        return chooseBetween(connectFour, popOut);
    }

    public String chooseInsertOrPop() {
        if (!board.getRow(6).contains(color))
            return "INSERT";
        else if (board.isFull())
            return "POP";
        else
            return chooseBetween("INSERT", "POP");
    }

    private String chooseBetween(String firstChoice, String secondChoice) {
        String choice = "";
        while (!acceptableStringChoice(choice, firstChoice, secondChoice)) {
            choice = input.nextLine();
        }
        return choice;
    }

    private boolean acceptableStringChoice(String choice, String firstChoice, String secondChoice) {
        return choice.equals(firstChoice) || choice.equals(secondChoice);
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
}
