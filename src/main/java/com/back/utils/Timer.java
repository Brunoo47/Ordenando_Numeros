package com.back.utils;

public class Timer {
    public static long measureTime(Runnable algorithm) {
        int runs = 5; 
        long totalTime = 0;

        for (int i = 0; i < runs; i++) {
//            int[] testArray = Sorting.getTestArray();
            long startTime = System.nanoTime();
            algorithm.run();
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        return (totalTime / runs) / 1_000_000;
    }
}
