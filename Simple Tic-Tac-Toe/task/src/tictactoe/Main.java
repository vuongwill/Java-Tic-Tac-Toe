package tictactoe;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] xox = new String[3][3];
        initiate(xox);
    }
    public static void initiate(String[][] xox) {
        while (true) {
            printBoard(xox);
            checkCoordX(xox);
            if (boardFull(xox) && !didAnyoneWin(xox)) {
                printBoard(xox);
                System.out.println("Draw");
                break;
            }
            if (didAnyoneWin(xox)) {
                printBoard(xox);
                System.out.println(getWinner(xox) + " wins");
                break;
            }
            printBoard(xox);
            checkCoordO(xox);
            if (didAnyoneWin(xox)) {
                printBoard(xox);
                System.out.println(getWinner(xox) + " wins");
                break;
            }
        }
    }
    public static boolean didAnyoneWin(String[][] xox) {
        if ((xox[1][1].equals("X") || xox[1][1].equals("O"))
                && (((xox[0][0].equals(xox[1][1])) && xox[0][0].equals(xox[2][2]))
                || ((xox[1][0].equals(xox[1][1])) && (xox[1][2]).equals(xox[1][1])
                || ((xox[0][1].equals(xox[1][1])) && (xox[2][1]).equals(xox[1][1]))
                || ((xox[0][2].equals(xox[1][1])) && (xox[1][1]).equals(xox[2][0]))))) {
            return true;
        }
        if ((xox[0][0].equals("X") || xox[0][0].equals("O"))
                && (((xox[0][0].equals(xox[1][0]) && (xox[2][0].equals(xox[0][0]))
                || (xox[0][0].equals(xox[0][1]) && xox[0][0].equals(xox[0][2])))))) {
            return true;
        }
        if (((xox[2][2].equals("X") || xox[2][2].equals("O"))
                && (((xox[0][2].equals(xox[1][2])) && (xox[0][2]).equals(xox[2][2]))
                || ((xox[2][0].equals(xox[2][1])) && (xox[2][0]).equals(xox[2][2]))))) {
            return true;
        }
        return false;
    }

    public static String getWinner(String[][] xox) {
        if ((xox[1][1].equals("X") || xox[1][1].equals("O"))
                && (((xox[0][0].equals(xox[1][1])) && xox[0][0].equals(xox[2][2]))
                || ((xox[1][0].equals(xox[1][1])) && (xox[1][2]).equals(xox[1][1])
                || ((xox[0][1].equals(xox[1][1])) && (xox[2][1]).equals(xox[1][1]))
                || ((xox[0][2].equals(xox[1][1])) && (xox[1][1]).equals(xox[2][0]))))) {
            return xox[1][1];
        }
        if ((xox[0][0].equals("X") || xox[0][0].equals("O"))
                && (((xox[0][0].equals(xox[1][0]) && (xox[2][0].equals(xox[0][0]))
                || (xox[0][0].equals(xox[0][1]) && xox[0][0].equals(xox[0][2])))))) {
            return xox[0][0];
        }
        if (((xox[2][2].equals("X") || xox[2][2].equals("O"))
                && (((xox[0][2].equals(xox[1][2])) && (xox[0][2]).equals(xox[2][2]))
                || ((xox[2][0].equals(xox[2][1])) && (xox[2][0]).equals(xox[2][2]))))) {
            return xox[2][2];
        }
        return "-1";
    }
    public static void printBoard(String[][] xox) {
        for (int i = 0; i < xox.length; i++) {
            for (int j = 0; j < xox.length; j++) {
                if (xox[i][j] == null) {
                    xox[i][j] = "_";
                }
            }
        }
        System.out.println("---------");
        System.out.println("| " + xox[0][0] + " " + xox[0][1] + " " + xox[0][2] + " |");
        System.out.println("| " + xox[1][0] + " " + xox[1][1] + " " + xox[1][2] + " |");
        System.out.println("| " + xox[2][0] + " " + xox[2][1] + " " + xox[2][2] + " |");
        System.out.println("---------");
    }
    public static void checkCoordX(String[][] xox) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the coordinates: ");
            if (!scanner.hasNextInt()) {
                System.out.println("You should enter numbers!");
                scanner.next();
                continue;
            }
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            if (x > 2 || x < 0 || y > 2 || y < 0) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if (xox[x][y].equals("X") || xox[x][y].equals("O")) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            if (xox[x][y].equals("_")) {
                xox[x][y] = "X";
                break;
            }
        }
    }
    public static void checkCoordO(String[][] xox) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the coordinates: ");
            if (!scanner.hasNextInt()) {
                System.out.println("You should enter numbers!");
                scanner.next();
                continue;
            }
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            if (x > 2 || x < 0 || y > 2 || y < 0) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if (xox[x][y].equals("X") || xox[x][y].equals("O")) {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            if (xox[x][y].equals("_")) {
                xox[x][y] = "O";
                break;
            }
        }
    }
    public static boolean boardFull(String[][] xox) {
        for (int i = 0; i < xox.length; i++) {
            for (int j = 0; j < xox.length; j++) {
                if (xox[i][j] == "_") {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean oneWinner(String[][] xox) {
        if (((xox[0][0].equals(xox[1][0])) && xox[0][0].equals(xox[2][0]))
                && ((xox[1].equals(xox[4])) && (xox[1]).equals(xox[7]))) {
            return false;
        }
        if (((xox[0][0].equals(xox[1][0])) && xox[0][0].equals(xox[2][0]))
                && ((xox[0][2].equals(xox[1][2])) && (xox[0][2]).equals(xox[2][2]))) {
            return false;
        }
        if (((xox[0][2].equals(xox[1][2])) && (xox[0][2]).equals(xox[2][2]))
                && ((xox[0][1].equals(xox[1][1])) && (xox[0][1]).equals(xox[2][1]))) {
            return false;
        }
        if ((((xox[0][0].equals(xox[0][1])) && xox[0][0].equals(xox[0][2]))
                && ((xox[1][0].equals(xox[1][1])) && (xox[1][0]).equals(xox[1][2])))) {
            return false;
        }
        if (((xox[0][0].equals(xox[0][1])) && xox[0][0].equals(xox[0][2]))
                && ((xox[2][0].equals(xox[2][1])) && (xox[2][0]).equals(xox[2][2]))) {
            return false;
        }
        if (((xox[1][0].equals(xox[1][1])) && (xox[1][0]).equals(xox[1][2]))
                && ((xox[2][0].equals(xox[2][1])) && (xox[2][0]).equals(xox[2][2]))) {
            return false;
        }
        return true;
    }
    public static boolean possible(String[][] xox) {
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < xox.length; i++) {
            for (int j = 0; j < xox.length; j++) {
                if (xox[i][j] == "X") {
                    xCount++;
                }
                if (xox[i][j] == "O") {
                    xCount++;
                }
            }
        }
        if (Math.abs(xCount - oCount) > 1) {
            return false;
        }
        return true;
    }
}
