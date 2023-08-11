package Seminar_2;


import java.util.Arrays;

public class Main {

    public static void SSort_D(int[] arr){
//        int max = Arrays.stream(arr).max().getAsInt();
//        int min = Arrays.stream(arr).min().getAsInt();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length - i; j++) {
                arr[i] = Arrays.stream(arr).max().getAsInt();
            }
        }

    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SSort_D(arr);
        System.out.println(Arrays.toString(arr));
    }
}
