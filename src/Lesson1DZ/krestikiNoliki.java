package Lesson1DZ;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class krestikiNoliki {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int[] lastMove = new int[2];

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
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
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
        lastMove[0] = y;
        lastMove[1] = x;
    }

    private static void aiTurn() {
        int x;
        int y;
        int aip = 2;
        int hp = 1;
        int[] variable = new int[fieldSizeY * fieldSizeX];
        int z = 0;
        variable[z] = 0;
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                z++;
//                Влево
                for (int k = 1; (j - k) >= 0 && k < 4; k++) {
                    if (field[i][j - k] == DOT_EMPTY) {
                        variable[z - 1] += 1;
                    }
                    if (field[i][j - k] == DOT_HUMAN) {
                        variable[z - 1] += 2;
                    }
                    if (field[i][j - k] == DOT_AI) {
                        variable[z - 1] += 3;
                    }
                }
//                Вправо
                for (int k = 1; (j + k) <= fieldSizeX - 1 && k < 4; k++) {
                    if (field[i][j + k] == DOT_EMPTY) {
                        variable[z - 1] += 1;
                    }
                    if (field[i][j + k] == DOT_HUMAN) {
                        variable[z - 1] += 2;
                    }
                    if (field[i][j + k] == DOT_AI) {
                        variable[z - 1] += 3;
                    }
                }
//                вверх
                for (int k = 1; (i - k) >= 0 && k < 4; k++) {
                    if (field[i - k][j] == DOT_EMPTY) {
                        variable[z - 1] += 1;
                    }
                    if (field[i - k][j] == DOT_HUMAN) {
                        variable[z - 1] += 2;
                    }
                    if (field[i - k][j] == DOT_AI) {
                        variable[z - 1] += 3;
                    }
                }
//                Вниз
                for (int k = 1; (i + k) <= fieldSizeY - 1 && k < 4; k++) {
                    if (field[i + k][j] == DOT_EMPTY) {
                        variable[z - 1] += 1;
                    }
                    if (field[i + k][j] == DOT_HUMAN) {
                        variable[z - 1] += 2;
                    }
                    if (field[i + k][j] == DOT_AI) {
                        variable[z - 1] += 3;
                    }
                }
//                Диагональ вниз на убывание
                for (int k = 1; (i - k) >= 0 && (j - k) >= 0 && k < 4; k++) {
                    if (field[i - k][j - k] == DOT_EMPTY) {
                        variable[z - 1] += 1;
                    }
                    if (field[i - k][j - k] == DOT_HUMAN) {
                        variable[z - 1] += 2;
                    }
                    if (field[i - k][j - k] == DOT_AI) {
                        variable[z - 1] += 3;
                    }
                }
//                Диагональ вниз на Возрастание
                for (int k = 1; (i + k) <= fieldSizeY - 1 && (j + k) <= fieldSizeX - 1 && k < 4; k++) {
                    if (field[i + k][j + k] == DOT_EMPTY) {
                        variable[z - 1] += 1;
                    }
                    if (field[i + k][j + k] == DOT_HUMAN) {
                        variable[z - 1] += 2;
                    }
                    if (field[i + k][j + k] == DOT_AI) {
                        variable[z - 1] += 3;
                    }
                }
//                Диагональ Вверх в право
                for (int k = 1; (i - k) >= 0 && (j + k) <= fieldSizeX - 1 && k < 4; k++) {
                    if (field[i - k][j + k] == DOT_EMPTY) {
                        variable[z - 1] += 1;
                    }
                    if (field[i - k][j + k] == DOT_HUMAN) {
                        variable[z - 1] += 2;
                    }
                    if (field[i - k][j + k] == DOT_AI) {
                        variable[z - 1] += 3;
                    }
                }
//                Диагональ вверх влево
                for (int k = 1; (i + k) <= fieldSizeY - 1 && (j - k) >= 0 && k < 4; k++) {
                    if (field[i + k][j - k] == DOT_EMPTY) {
                        variable[z - 1] += 1;
                    }
                    if (field[i + k][j - k] == DOT_HUMAN) {
                        variable[z - 1] += 2;
                    }
                    if (field[i + k][j - k] == DOT_AI) {
                        variable[z - 1] += 3;
                    }
                }
                    // Проверка линий
                for (int l = 1; ((j - l) >= 0 && field[i][j - l] == DOT_AI); l++) {
                    int coof = aip * l;
                    variable[z - 1] += coof;
                    if (l == 3) {
                        variable[z - 1] += 2000;
                    }
                }
                for (int l = 1; ((j + l) <= fieldSizeX - 1 && field[i][j + l] == DOT_AI); l++) {
                    int coof = aip * l;
                    variable[z - 1] += coof;
                    if (l == 3) {
                        variable[z - 1] += 2000;
                    }

                }

//        Проверка по вертикали

                for (int l = 1; ((i - l) >= 0 && field[i - l][j] == DOT_AI); l++) {
                    int coof = aip * l;
                    variable[z - 1] += coof;
                    if (l == 3) {
                        variable[z - 1] += 2000;
                    }
                }
                for (int l = 1; ((i + l) <= fieldSizeX - 1 && field[i + l][j] == DOT_AI); l++) {
                    int coof = aip * l;
                    variable[z - 1] += coof;
                    if (l == 3) {
                        variable[z - 1] += 2000;
                    }
                }
//        Проверака по диагонали вниз
                for (int l = 1; ((j - l) >= 0 && (i - l) >= 0 && field[i - l][j - l] == DOT_AI); l++) {
                    int coof = aip * l;
                    variable[z - 1] += coof;
                    if (l == 3) {
                        variable[z - 1] += 2000;
                    }
                }
                for (int l = 1; ((j + l) <= fieldSizeX - 1 && (i + l) <= fieldSizeY - 1 && field[i + l][j + l] == DOT_AI); l++) {
                    int coof = aip * l;
                    variable[z - 1] += coof;
                    if (l == 3) {
                        variable[z - 1] += 2000;
                    }
                }
//            Проверка по диагонали вверх
                for (int l = 1; ((j - l) >= 0 && (i + l) <= fieldSizeY - 1 && field[i + l][j - l] == DOT_AI); l++) {
                    int coof = aip * l;
                    variable[z - 1] += coof;
                    if (l == 3) {
                        variable[z - 1] += 2000;
                    }
                }
                for (int l = 1; ((j + l) <= fieldSizeX - 1 && (i - l) >= 0 && field[i - l][j + l] == DOT_AI); l++) {
                    int coof = aip * l;
                    variable[z - 1] += coof;
                    if (l == 3) {
                        variable[z - 1] += 2000;
                    }
                }
//                    Бебебе
                for (int l = 1; ((j - l) >= 0 && field[i][j - l] == DOT_HUMAN); l++) {
                    int coof = hp * l;
                    variable[z - 1] += coof;
                    if (l == 3) {
                        variable[z - 1] += 1000;
                    }
                }
                for (int l = 1; ((j + l) <= fieldSizeX - 1 && field[i][j + l] == DOT_HUMAN); l++) {
                    int coof = hp * l;
                    variable[z - 1] += coof;
                    if (l == 3) {
                        variable[z - 1] += 1000;
                    }
                }

//        Проверка по вертикали

                for (int l = 1; ((i - l) >= 0 && field[i - l][j] == DOT_HUMAN); l++) {
                    int coof = hp * l;
                    variable[z - 1] += coof;
                    if (l == 3) {
                        variable[z - 1] += 1000;
                    }
                }
                for (int l = 1; ((i + l) <= fieldSizeX - 1 && field[i + l][j] == DOT_HUMAN); l++) {
                    int coof = hp * l;
                    variable[z - 1] += coof;
                    if (l == 3) {
                        variable[z - 1] += 1000;
                    }
                }
//        Проверака по диагонали вниз
                for (int l = 1; ((j - l) >= 0 && (i - l) >= 0 && field[i - l][j - l] == DOT_HUMAN); l++) {
                    int coof = hp * l;
                    variable[z - 1] += coof;
                    if (l == 3) {
                        variable[z - 1] += 1000;
                    }
                }
                for (int l = 1; ((j + l) <= fieldSizeX - 1 && (i + l) <= fieldSizeY - 1 && field[i + l][j + l] == DOT_HUMAN); l++) {
                    int coof = hp * l;
                    variable[z - 1] += coof;
                    if (l == 3) {
                        variable[z - 1] += 1000;
                    }
                }
//            Проверка по диагонали вверх
                for (int l = 1; (j - l) >= 0 && (i + l) <= fieldSizeY - 1 && field[i + l][j - l] == DOT_HUMAN; l++) {
                    int coof = hp * l;
                    variable[z - 1] += coof;
                    if (l == 3) {
                        variable[z - 1] += 1000;
                    }
                }
                for (int l = 1; ((j + l) <= fieldSizeX - 1 && (i - l) >= 0 && field[i - l][j + l] == DOT_HUMAN); l++) {
                    int coof = hp * l;
                    variable[z - 1] += coof;
                    if (l == 3) {
                        variable[z - 1] += 1000;
                    }
                }
            }
        }
        int xx = 0;
        int yy = 0;
        int a = variable[0];
        int c = 0;
        do {
            for (int b = 0; b < variable.length; b++) {
                c = variable[b] > a ? b : c;
                a = variable[b] > a ? variable[b] : a;
            }
            variable[c] = -1;
            a = variable[0];
            yy = c / fieldSizeX  ;
            xx = c % fieldSizeX ;
//            x = RANDOM.nextInt(fieldSizeX);
//            y = RANDOM.nextInt(fieldSizeY);
        } while (field[yy][xx] != DOT_EMPTY);
        field[yy][xx] = DOT_AI;
        lastMove [0] = yy;
        lastMove [1] = xx;
    }

    private static void checkWin() {
        int x = lastMove[1];
        int y = lastMove[0];

//        Проверка по горизонтали

        int sum = 0;
        for (int i = 1; (x - i) >= 0 && field [y][x] == field [y][x-i]; i++) {
            sum += 1;
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