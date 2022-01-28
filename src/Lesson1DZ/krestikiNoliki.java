package Lesson1DZ;

import java.util.Random;
import java.util.Scanner;

public class krestikiNoliki {

    private  static  final  char DOT_HUMAN = 'X';
    private  static  final  char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    private  static  final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int [] lastMove = new int[2];

    private static void initField() {
        fieldSizeY = 5;
        fieldSizeX = 5;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        for (int i = 0; i < fieldSizeY; i++ ) {
            for (int j = 0; j< fieldSizeX; j++) {
                System.out.print(field[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Ведите координаты хода X и Y от 1 до 5 через пробел >>>");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!(x >= 0 && x < fieldSizeX && y >= 0 && x < fieldSizeY) || field[y][x] != DOT_EMPTY);
        field[y][x] = DOT_HUMAN;
        lastMove [0] = y;
        lastMove [1] = x;
            }

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (field[y][x] != DOT_EMPTY);
        field[y][x] = DOT_AI;
        lastMove [0] = y;
        lastMove [1] = x;
    }

    private static void checkWin() {
        int x = lastMove[1];
        int y = lastMove[0];

//        Проверка по горизонтали

        int sum = 0;
        for (int i = 1; (x - i) >= 0 && field [y][x] == field [y][x-i]; i++) {
            sum += 1;
        }
        if (sum >= 3) {
            System.out.println("You Win");
        }

        for (int i = 1; (x + i) <= fieldSizeX -1 && field [y][x] == field [y][x+i]; i++) {
            sum += 1;
        }
        if (sum >= 3) {
            System.out.println("You Win");
        }

//        Проверка по вертикали

        sum = 0;
        for (int i = 1; (y - i) >= 0 && field [y][x] == field [y-i][x]; i++) {
            sum += 1;
        }
        if (sum >= 3) {
        System.out.println("You Win");
        }

        for (int i = 1; (y + i) <= fieldSizeX -1 && field [y][x] == field [y+i][x]; i++) {
            sum += 1;
            }
            if (sum >= 3) {
                System.out.println("You Win");
            }
//        Проверака по диагонали вниз

        sum = 0;
        for (int i = 1; (x - i) >= 0 && (y - i) >= 0 && field [y][x] == field [y-i][x-i]; i++) {
            sum += 1;
        }
        if (sum >= 3) {
        System.out.println("You Win");
        }

        for (int i = 1; (x + i) <= fieldSizeX -1 && (y + i) <= fieldSizeY - 1 && field [y][x] == field [y+i][x+i]; i++) {
            sum += 1;
            }
            if (sum >= 3) {
                System.out.println("You Win");
            }
//            Проверка по диагонали вверх

        sum = 0;
        for (int i = 1; (x - i) >= 0 && (y + i) <= fieldSizeY - 1 && field [y][x] == field [y+i][x-i]; i++) {
            sum += 1;
        }
        if (sum >= 3) {
            System.out.println("You Win");
        }
        for (int i = 1; (x + i) <= fieldSizeX -1 && (y - i) >= 0 && field [y][x] == field [y-i][x+i]; i++) {
            sum += 1;
        }
        if (sum >= 3) {
            System.out.println("You Win");
        }
    }

    private static void printWin (String printWin) {

    }

    private static void endGame() {

    }

    public static void main (String[] args) {
        initField();
        printField();
        while (true) {
            humanTurn();
            printField();
            checkWin();
            aiTurn();
            printField();
            checkWin();
        }
//        endGame();





    }
}