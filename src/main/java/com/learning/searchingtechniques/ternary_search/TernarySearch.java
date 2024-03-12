package com.learning.searchingtechniques.ternary_search;

public class TernarySearch {
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
     * @param elementToBeFind needs to be find
     * @param lowestIndex lowest index of the array
     * @param highestIndex highest index of the array
     * @return index of the element
     */
    public static int ternary_search(int[] arr, int elementToBeFind, int lowestIndex, int highestIndex) {
        if (highestIndex >= lowestIndex) {
            int midIndex1 = lowestIndex + (highestIndex -lowestIndex)/3;
            int midIndex2 = highestIndex- (highestIndex -lowestIndex)/3;

            // Check if key is present at any mid
            if (arr[midIndex1] == elementToBeFind) {
                return midIndex1;
            }
            if (arr[midIndex2] == elementToBeFind) {
                return midIndex2;
            }

            /**
             * Since key is not present at mid,  check in which region it is present
             * then repeat the Search operation in that region
             *
             *  lowestIndex-------midIndex1---------midIndex2-------highestIndex
             *
             */

            if (elementToBeFind < arr[midIndex1]) {

                // The key lies in between lowestIndex and midIndex1
                return ternary_search(arr, elementToBeFind, lowestIndex,midIndex1 - 1);
            }
            else if (elementToBeFind > arr[midIndex2]) {

                // The key lies in between midIndex2 and highestIndex
                return ternary_search(arr, elementToBeFind,midIndex2 + 1, highestIndex);
            }
            else {

                // The key lies in between mid1 and mid2
                return ternary_search(arr, elementToBeFind,midIndex1 + 1, midIndex2 - 1);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = { 2, 5, 8, 12, 16, 23, 38, 56, 72, 91 };
        int elementToBeFind = 72;
        int lowestIndex = 0;
        int highestIndex = arr.length-1;

        // Function call
        int result = ternary_search(arr, elementToBeFind, lowestIndex, highestIndex);
        if (result == -1) {
            System.out.print("Element is not present in array");
        } else {
            System.out.print("Element is present at index " + result);
        }

    }
}
