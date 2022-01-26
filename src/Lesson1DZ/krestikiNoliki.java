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

    private static void initFild() {
        fieldSizeY = 3;
        fieldSizeX = 3;
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
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Ведите координаты хода X и Y от 1 до 3 через пробел >>>");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!(x >= 0 && x < fieldSizeX && y >= 0 && x < fieldSizeY) || field[y][x] != DOT_EMPTY);
        field[y][x] = DOT_HUMAN;
    }

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (field[y][x] != DOT_EMPTY);
        field[y][x] = DOT_HUMAN;
    }

    private static void checkWin() {

    }

    public static void main(String[] args) {
        initFild();
        printField();
        while (true) {
            humanTurn();
            printField();
            aiTurn();
            printField();
        }





    }
}