package Homework_1;

import java.util.Arrays;

import static Homework_1.Main.HeapSort.heapSort;

public class Main {

    public static class HeapSort {
        public static void heapSort(int arr[]) {
            int n = arr.length;

            // Построение кучи (перегруппировка массива)
            for (int i = n / 2 - 1; i >= 0; i--)
                heapify(arr, n, i);

            // Извлечение элементов из кучи по одному
            for (int i = n - 1; i >= 0; i--) {
                // Перемещаем текущий корень в конец
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                // Вызываем heapify на уменьшенной куче
                heapify(arr, i, 0);
            }
        }

        // Перегруппировка поддерева с корнем i, чтобы поддержать свойство кучи
        public static void heapify(int arr[], int n, int i) {
            int largest = i; // Инициализируем наибольший элемент как корень
            int left = 2 * i + 1; // Левый потомок узла i
            int right = 2 * i + 2; // Правый потомок узла i

            // Если левый потомок больше корня
            if (left < n && arr[left] > arr[largest])
                largest = left;

            // Если правый потомок больше, чем наибольший элемент на данный момент
            if (right < n && arr[right] > arr[largest])
                largest = right;

            // Если наибольший элемент не корень
            if (largest != i) {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                // Рекурсивно heapify поддерево
                heapify(arr, n, largest);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 54, 99, 7};
        int n = arr.length;

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(arr));

        heapSort(arr);

        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(arr));
    }

}
