import java.util.*;

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

    private String chooseBetween(String firstChoice, String secondChoice) {
        String choice = "";
        while (!acceptableStringChoice(choice, firstChoice, secondChoice)) {
            System.out.print("Type " + firstChoice + " or " + secondChoice + ": ");
            choice = input.nextLine();
        }
        return choice;
    }

    private boolean acceptableStringChoice(String choice, String firstChoice, String secondChoice) {
        return choice.equals(firstChoice) || choice.equals(secondChoice);
    }

    public String chooseColor() {
        System.out.print("Choose a color (R = red, Y = yellow).\n");
        return chooseBetween("R", "Y");
    }

    public String chooseGameMode() {
        System.out.print("Choose a game mode (FOUR = Connect Four, POP = Pop Out).\n");
        return chooseBetween("FOUR", "POP");
    }

    public String chooseInsertOrPop() {
        if (insertIsAvailable() && popIsAvailable()) {
            System.out.print("Choose the next move (I = insert, P = pop).\n ");
            return chooseBetween("I", "P");
        }
        else if (insertIsAvailable())
            return "I";
        return "P";
    }

    private boolean insertIsAvailable() {
        return !board.isFull();
    }

    private boolean popIsAvailable() {
        int bottomRow = board.numberOfRows;
        return board.getRow(bottomRow)
                    .contains(color);
    }

    public boolean playerCanMove() {
        return popIsAvailable() || insertIsAvailable();
    }

    public int chooseColumn(boolean pop) {
        int column = 0;
        while (columnIsNotAcceptable(column, pop)) {
            System.out.print("Choose a column (1-" + board.numberOfColumns + "): ");
            column = handleNumericInput(column);
        }
        return column;
    }

    private boolean columnIsNotAcceptable(int column, boolean pop) {
        if (pop) return column < 1 || column > board.numberOfColumns || !bottomPieceMatchesColor(column);
        else return column < 1 || column > board.numberOfColumns || columnIsFull(column);
    }

    private boolean bottomPieceMatchesColor(int column) {
        column--;
        List<String> bottomRow = board.getRow(board.numberOfRows);
        return bottomRow.get(column)
                        .equals(color);
    }

    private boolean columnIsFull(int column) {
        return board.currentSizeOfColumn(column) == board.numberOfRows;
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
