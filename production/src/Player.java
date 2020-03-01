import java.util.Scanner;

public class Player {
    public String color;

    public static String chooseColor() {
        System.out.println("Type R(red) or Y (yellow) to choose a color: ");
        Scanner color = new Scanner(System.in);
        return color.nextLine();
    }

    public static int chooseColumn() {
        System.out.println("Type a number from 1 to 7 to choose a column: ");
        Scanner column = new Scanner(System.in);
        return column.nextInt();
    }
}
