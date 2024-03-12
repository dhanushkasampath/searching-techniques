package com.learning.searchingtechniques.linear_search;

public class LinearSearch {
    /**
     * Here main logic is iterating through the array and find the element using if check
     *
     * @param arr of integers
     * @param element needs to be find
     * @return index of the element
     */
    public static int search(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 10, 40 };
        int elementToBeFind = 10;

        // Function call
        int result = search(arr, elementToBeFind);
        if (result == -1)
            System.out.print("Element is not present in array");
        else
            System.out.print("Element is present at index " + result);
    }
}
