package com.learning.searchingtechniques.binary_search;

public class recursiveBinarySearch {

    public static int recursive_BinarySearch(int[] arr, int elementToBeFind,
                                             int lowestIndex, int highestIndex) {
        if (highestIndex >= lowestIndex) {
            int midIndex = lowestIndex + (highestIndex - lowestIndex) / 2;

            // If the element is present at the
            // middle itself
            if (arr[midIndex] == elementToBeFind) {
                return midIndex;
            }

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[midIndex] > elementToBeFind) {
                return recursive_BinarySearch(arr, elementToBeFind, lowestIndex, midIndex - 1);
            }

            // Else the element can only be present
            // in right subarray
            return recursive_BinarySearch(arr, elementToBeFind, midIndex + 1, highestIndex);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = { 2, 5, 8, 12, 16, 23, 38, 56, 72, 91 };
        int elementToBeFind = 72;

        // Function call
        int result = recursive_BinarySearch(arr, elementToBeFind, 0, arr.length-1);
        if (result == -1) {
            System.out.print("Element is not present in array");
        } else {
            System.out.print("Element is present at index " + result);
        }
    }
}