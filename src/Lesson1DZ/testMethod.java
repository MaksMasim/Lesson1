package Lesson1DZ;

import java.util.Arrays;

public class testMethod {

    public static void main(String[] args) {

        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        papapam1 (arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();

        int[] arr2 = new int [8];
        papapam2 (arr2);
        System.out.println(Arrays.toString(arr2));
        System.out.println();

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8 ,9, 1};
        papapam3 (arr3);
        System.out.println(Arrays.toString(arr3));
        System.out.println();

        int[] arr4 = {7, 9, 89, 3, 45, 8, 90};
        System.out.println("Значение максимальное = " + papapam4Max(arr4) + ". Находится в ячейке " + (papapam4MaxN(arr4) + 1));
        System.out.println("Значение миниимальное = " + papapam4Min(arr4) + ". Находится в ячейке " + (papapam4MinN(arr4) + 1));
        System.out.println();


        int [][] arr5 = new int [5][5];
        papapam5 (arr5);
        for (int a = 0; a < arr5.length; a++) {
            for( int b = 0; b < arr5.length; b++) {
                System.out.print(arr5[a][b] + "  ");
            }
            System.out.println();
        }
        System.out.println();

        int [] arr6 = {1, 2, 3, 4, 5, 0, 2, 3};
        if (papapam6(arr6) == true) {
            System.out.println("Баланс есть");
        }else {
            System.out.println("Баланс отсутствует");
        }

//
    }

    public static int[] papapam1 (int[] arr) {
        for (int a = 0; a < arr.length; a++) {
            arr[a] = arr[a] == 1 ? 0 : 1;
        }
        return arr;

    }

    public static int[] papapam2 (int[] arr2) {
        int b = 1;
        for (int a = 0; a < arr2.length; a++, b += 3) {
            arr2 [a] = b;
                    }
        return arr2;
    }

    public static int[] papapam3 (int[] arr3) {
        for (int a = 0; a < arr3.length; a++) {
            arr3 [a] = arr3 [a] > 6 ? arr3 [a] : arr3[a] *2;
        }
        return arr3;
    }

    public static int papapam4Max (int [] arr4) {
        int a = arr4[0];
        for (int b = 0; b < arr4.length; b++) {
            a = arr4[b] > a ? arr4[b] : a;
        }
        return a;
    }
    public static int papapam4Min (int [] arr4) {
        int a = arr4[0];
        for (int b = 0; b < arr4.length; b++) {
            a = arr4[b] < a ? arr4[b] : a;
        }
        return a;
    }
    public static int papapam4MaxN (int [] arr4) {
        int a = arr4[0];
        int c = 0;
        for (int b = 0; b < arr4.length; b++) {
            c = arr4[b] > a ? b : c;
            a = arr4[b] > a ? arr4[b] : a;
        }
        return c;
    }
    public static int papapam4MinN (int [] arr4) {
        int a = arr4[0];
        int c = 0;
        for (int b = 0; b < arr4.length; b++) {
            c = arr4[b] < a ? b : c;
            a = arr4[b] < a ? arr4[b] : a;
        }
        return c;
    }

    public static int [][] papapam5 (int [][] arr5) {
        for (int a = 0; a < arr5.length; a++) {
            for (int b = 0; b < 5; b++) {
                arr5[a][b] = a == b || a + b == 4 ? 1 : 0;
            }
        }
        return arr5;

    }

    public static boolean papapam6 (int [] arr6) {
        if (arr6[0] == arr6[1]+arr6[2]+arr6[3]+arr6[4]+arr6[5]+arr6[6]+arr6[7]) {
            return true;
        }else if (arr6[0]+arr6[1] == arr6[2]+arr6[3]+arr6[4]+arr6[5]+arr6[6]+arr6[7]) {
            return true;
        }else if (arr6[0]+arr6[1]+arr6[2] == arr6[3]+arr6[4]+arr6[5]+arr6[6]+arr6[7]) {
            return true;
        }else if (arr6[0]+arr6[1]+arr6[2]+arr6[3]==arr6[4]+arr6[5]+arr6[6]+arr6[7]) {
            return true;
        }else if (arr6[0]+arr6[1]+arr6[2]+arr6[3]+arr6[4]==arr6[5]+arr6[6]+arr6[7]) {
            return true;
        }else if (arr6[0]+arr6[1]+arr6[2]+arr6[3]+arr6[4]+arr6[5]==arr6[6]+arr6[7]) {
            return true;
        }else if (arr6[0]+arr6[1]+arr6[2]+arr6[3]+arr6[4]+arr6[5]+arr6[6]==arr6[7]) {
            return true;
        }else {
            return false;
        }
    }






}