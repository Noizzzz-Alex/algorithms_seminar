package Seminar_1;

public class Main {

    public static int sum(int n) { //сложность O(n) линейная
        int result = 0;
        for (int i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }
    // O(n) = O(n/2) = 1/2 O(n) константы можем сокращать(опустить)
    // при расчете оценки сложности

    // result  = n * (n+1) /2 O(1) - формула арифметической прогрессии
    // с решением алгоритмом с константной сложностью.
//---------------------------------------------------------------------

    //поиск простых чисел
    // сложность O(n^2) = O(n * n/2) квадратичная сложность
//    public static void simple(int n) {
//        for (int i = 2; i <= n; i++) {
//            boolean flag = true;
//            for (int j = 2; j <= i / 2; j+=2) {
//                if (i % j == 0) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                System.out.println(i);
//            }
//        }
//    }

    public static void simple(int n) {
        for (int i = 2; i <= n; i++) { //O(n sqrt(n))
            boolean flag = true;
            for (int j = 2; j * j <= i; j++) {//O( sqrt(n))
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
            }
        }
    }

    //---------------------------------------------------------------------
    public static int cubs(int n, int k) { // O(n^k), O(n^4) так как кубика 4.
        int result = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                for (int c = 1; c <= n; c++) {
                    for (int d = 1; d <= n; d++) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static int cubsRecursive(int n, int k) {
        if (k == 0) {
            return 1;
        }
        return cubsRecursive(n - 1, k - 1) + cubsRecursive(n - 1, k);
    }

    public static void main(String[] args) {
        // сумма чисел от 1 до N
        //System.out.println(sum(100));
        //simple(1000000);
        System.out.println(cubs(6, 4));
        System.out.println(cubsRecursive(6,4));


    }
}
