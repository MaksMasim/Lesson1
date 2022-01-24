package Lesson1DZ;

public class Lesson1DZ {

    public static void main (String [] args){

        printThreeWords();
        сheckSumSigh();
        printColor();
        compareNumbers ();
    }

    public static void printThreeWords () {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void сheckSumSigh () {
        int a, b;
        a = 10;
        b = -11;
        int c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }

    }

    public static void printColor () {

        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        }
        else if (0< value && value <= 100) {
            System.out.println("Желтый");
        }
        else {
            System.out.println("Зеленый");
        }

    }

    public static void compareNumbers () {

        int a, b;
        a = 27;
        b = 28;
        if (a >= b){
            System.out.println("a >= b");
        }
        else {
            System.out.println("a < b");
        }

    }


}
