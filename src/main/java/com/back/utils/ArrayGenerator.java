package com.back.utils;
import java.util.Arrays;
import java.util.Random;

public class ArrayGenerator {
    public static int[] generateRandomArray(int size, int maxValue) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue);
        }
        return array;
    }

    public static int[] generateSortedArray(int size) {
        int[] array = generateRandomArray(size, 10000);
        Arrays.sort(array);
        return array;
    }

    public static int[] generateReversedArray(int size) {
        int[] array = generateSortedArray(size);
        for (int i = 0; i < size / 2; i++) {
            int temp = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = temp;
        }
       // return array;
    }

    public static int[] generateDuplicatedArray(int size, int uniqueValues) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(uniqueValues);
        }
        return array;
    }
}
