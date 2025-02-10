package com.back.algorithms;

public class QuickSort {
    public static void sort(int[] array, int low, int high) {
        while (low < high) {
            int pi = partition(array, low, high);

            if (pi - low < high - pi) {
                sort(array, low, pi - 1);
                low = pi + 1;
            } else {
                sort(array, pi + 1, high);
                high = pi - 1;
            }
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = medianOfThree(array, low, high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private static int medianOfThree(int[] array, int low, int high) {
        int mid = low + (high - low) / 2;

        if (array[low] > array[mid]) swap(array, low, mid);
        if (array[low] > array[high]) swap(array, low, high);
        if (array[mid] > array[high]) swap(array, mid, high);

        swap(array, mid, high);
        return array[high];
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
