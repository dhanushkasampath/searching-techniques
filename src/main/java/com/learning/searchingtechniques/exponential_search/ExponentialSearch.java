package com.learning.searchingtechniques.exponential_search;

import java.util.Arrays;

/**
 * Exponential search involves two steps:
 *
 * 1. Find range where element is present
 * 2. Do Binary Search in above found range.
 *
 * How to find the range where element may be present?
 * The idea is to start with subarray size 1, compare its last element with x,
 * then try size 2, then 4 and so on until last element of a subarray is not greater.
 * Once we find an index i (after repeated doubling of i), we know that the element must be present
 * between i/2 and i (Why i/2? because we could not find a greater value in previous iteration)
 */
public class ExponentialSearch {

    static int exponential_search(int[] arr,
                                  int arraySize, int elementToBeFind)
    {
        // If elementToBeFind is present at first location itself
        if (arr[0] == elementToBeFind) {
            return 0;
        }

        // Find range for binary search by repeated doubling
        int i = 1;
        while (i < arraySize && arr[i] <= elementToBeFind)
            i = i*2;

        // Call binary search for the found range.
        return Arrays.binarySearch(arr, i/2,
                Math.min(i, arraySize-1), elementToBeFind);
    }
    public static void main(String[] args) {
        int[] arr = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        int elementToBeFind = 55;

        // Function call
        int result = exponential_search(arr, arr.length, elementToBeFind);
        if (result == -1) {
            System.out.print("Element is not present in array");
        } else {
            System.out.print("Element is present at index " + result);
        }
    }
}
