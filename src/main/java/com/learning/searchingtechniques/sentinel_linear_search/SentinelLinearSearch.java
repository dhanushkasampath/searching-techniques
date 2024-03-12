package com.learning.searchingtechniques.sentinel_linear_search;

public class SentinelLinearSearch {
    /**
     * This is a variant of Linear Search that uses
     * a sentinel value(adding an extra element at the end of the array)
     * to optimize the search process
     *
     * -----Here are the steps for Sentinel Linear Search algorithm:-----
     *
     * 1. Initialize the search index variable i to 0.
     * 2. Set the last element of the array to the search key.
     * 3. While the search key is not equal to the current element of the array (i.e., arr[i]),
     * increment the search index i.
     * 4. If i is less than the size of the array or arr[i] is equal to the search key,
     * return the value of i (i.e., the index of the search key in the array).
     * 5. Otherwise, the search key is not present in the array, so return -1 (or any other appropriate value to indicate that the key is not found).
     *
     * @param arr of integers
     * @param element needs to be find
     * @return index of the element
     */
    public static int search(int[] arr, int element) {
        // get the last element
        int lastElement = arr[arr.length - 1];

        //set the element to be searched as the last element of the array
        arr[arr.length - 1] = element;
        int i = 0;

        // iterate till we find the needed element in the array. when found i contains the needed index
        while (arr[i] != element) {
            i++;
        }

        // reset the actual last element in the array
        arr[arr.length - 1] = lastElement;

        if (i < arr.length - 1 || lastElement == element) {
            return i;
        } else {
            return -1;
        }
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
