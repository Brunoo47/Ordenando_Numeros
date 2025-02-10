package com.back.tests;
import com.back.algorithms.BubbleSort;
import com.back.algorithms.MergeSort;
import com.back.algorithms.QuickSort;
import com.back.utils.ArrayGenerator;
import com.back.utils.Timer;

import java.util.Arrays;

public class SortingTester {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};
        String[] scenarios = {"Aleatória", "Ordenada", "Reversa", "Duplicada"};

        System.out.printf("%-10s %-10s %-15s %-15s %-15s\n", "Tamanho", "Cenário", "QuickSort (ms)", "MergeSort (ms)", "BubbleSort (ms)");
        System.out.println("----------------------------------------------------------------------------------------");

        for (int size : sizes) {
            for (String scenario : scenarios) {
                int[] testArray;
                switch (scenario) {
                    case "Ordenada":
                        testArray = ArrayGenerator.generateSortedArray(size);
                        break;
                    case "Reversa":
                        testArray = ArrayGenerator.generateReversedArray(size);
                        break;
                    case "Duplicada":
                        testArray = ArrayGenerator.generateDuplicatedArray(size, size / 10);
                        break;
                    default:
                        testArray = ArrayGenerator.generateRandomArray(size, 1000000);
                }

                int[] arrayCopy = Arrays.copyOf(testArray, testArray.length);
                int[] finalArrayCopy = arrayCopy;
                int[] finalArrayCopy1 = arrayCopy;
                long quickTime = Timer.measureTime(() -> QuickSort.sort(finalArrayCopy, 0, finalArrayCopy1.length - 1));

                arrayCopy = Arrays.copyOf(testArray, testArray.length);
                int[] finalArrayCopy2 = arrayCopy;
                int[] finalArrayCopy3 = arrayCopy;
                long mergeTime = Timer.measureTime(() -> MergeSort.sort(finalArrayCopy2, 0, finalArrayCopy3.length - 1));

                arrayCopy = Arrays.copyOf(testArray, testArray.length);
                int[] finalArrayCopy4 = arrayCopy;
                long bubbleTime = Timer.measureTime(() -> BubbleSort.sort(finalArrayCopy4));

                System.out.printf("%-10d %-10s %-15d %-15d %-15d\n", size, scenario, quickTime, mergeTime, bubbleTime);
            }
        }
    }
}
