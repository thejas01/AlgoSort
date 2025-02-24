package com.thejas.algo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SortingService {

    public List<int[]> bubbleSort(int[] arr) {
        List<int[]> steps = new ArrayList<>();
        int n = arr.length;
        int[] tempArr = arr.clone(); // Clone original array

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tempArr[j] > tempArr[j + 1]) {
                    // Swap elements
                    int temp = tempArr[j];
                    tempArr[j] = tempArr[j + 1];
                    tempArr[j + 1] = temp;
                    steps.add(tempArr.clone()); // Store the step
                }
            }
        }
        return steps;
    }

    public List<int[]> sortArray(int[] array, String algorithm) {
        return switch (algorithm.toLowerCase()) {
            case "bubble" -> bubbleSort(array);
            default -> throw new IllegalArgumentException("Unsupported Algorithm: " + algorithm);
        };
    }
}