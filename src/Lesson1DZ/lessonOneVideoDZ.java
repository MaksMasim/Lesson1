package Lesson1DZ;

public class lessonOneVideoDZ {

    public static void main(String[] args) {
        visokosnii();
    }

    public static void typeVariable(){
        byte a = 2;
        short b = 300;
        int c = 70000;
        long d = 3000000000l;
        float e = 1.3458f;
        double f = 4.342241;
        char g = 567;
        boolean h = false;
        }

    public static int theExuation (int a, int b, int c, int d) {

        int e = a*(b+(c/d));
        return e;
    }

    public static boolean pravdaLoz (int a, int b){
        if (10 <= (a + b) && (a + b) <= 20){
            boolean c = true;
            return c;
        }
        else {
            boolean d = false;
            return d;
        }
    }

    public static void NaPechat (int a) {

        if (a >= 0) {
            System.out.println("Число положительное");
        }
        else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean proverka (int a){
        if (a < 0){
            boolean b = true;
            return b;
        }
        else {
            boolean c = false;
            return c;
        }
    }

    public static void ivodimeni (String a) {
        System.out.println("Привет, " + a);
    }

    public static void visokosnii (){
        int b = 40500;
        if ((b / 400) >= (int) 1 && b % 400 == 0) {
            System.out.println("Год является високосным");
        }
        else if (((b / 100) >= 1 && (b % 100 == 0)) || (b % 4) != 0 ) {
            System.out.println("Год является не високосным");
        }
        else {
            System.out.println("Год является високосным");
        }

    }
}
