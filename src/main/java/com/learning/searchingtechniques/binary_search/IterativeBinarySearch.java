package com.learning.searchingtechniques.binary_search;

public class IterativeBinarySearch {
    /**
     *
     * To apply Binary Search algorithm:
     *
     * The data structure must be sorted.
     * Access to any element of the data structure takes constant time.
     *
     * Here main logic is
     * 1. get the lowest index
     * 2. get the highest index
     * 3. iterate using a while loop till lowest index is <= highest index
     *  -----inside the while loop-----
     * 4. get the mid index
     * 5. if value of mid index equals to element then that's the point and return the mid index
     * 6. if value of mid index is less than element, ignore the left half by reassigning new value to lowestIndex
     * 7. if value of mid index is greater than element, ignore the right half by reassigning new value to highestIndex
     *  -----end of while loop---------
     * 8. return -1 if nothing returned from while loop
     *
     *
     * Arrays.binarySearch() method has the same implementation
     *
     * @param arr of integers
     * @param element needs to be find
     * @return index of the element
     */
    public static int iterative_binarySearch(int[] arr, int element) {
        int lowestIndex = 0;
        int highestIndex = arr.length - 1;
        while (lowestIndex <= highestIndex) {
            int midIndex = lowestIndex + (highestIndex - lowestIndex)/2;

            // check if element is present at mid
            if (arr[midIndex] == element) {
                return midIndex;
            }

            // if value of mid index is less than element, ignore the left half
            if (arr[midIndex] < element) {
                lowestIndex = midIndex + 1;
            }

            // if value of mid index is greater than element, ignore the right half
            if (arr[midIndex] > element) {
                highestIndex = midIndex - 1;
            }
        }

        // If we reach here, then element was
        // not present
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = { 2, 5, 8, 12, 16, 23, 38, 56, 72, 91 };
        int elementToBeFind = 72;

        // Function call
        int result = iterative_binarySearch(arr, elementToBeFind);
        if (result == -1)
            System.out.print("Element is not present in array");
        else
            System.out.print("Element is present at index " + result);
    }
}