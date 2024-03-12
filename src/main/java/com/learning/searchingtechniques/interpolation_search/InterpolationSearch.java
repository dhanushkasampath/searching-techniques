package com.learning.searchingtechniques.interpolation_search;

public class InterpolationSearch {

    /**
     *
     * Step1: In a loop, calculate the value of “pos” using the probe position formula.
     * Step2: If it is a match, return the index of the item, and exit.
     * Step3: If the item is less than arr[pos], calculate the probe position of the left sub-array.
     * Otherwise, calculate the same in the right sub-array.
     * Step4: Repeat until a match is found or the sub-array reduces to zero.
     *
     * @param arr of elements
     * @param elementToBeFind element to be find
     * @return index of the element
     */
    static int interpolation_search(int []arr, int lowestIndex,
                                   int highestIndex, int elementToBeFind)
    {
        int pos;

        // Since array is sorted, an element
        // present in array must be in range
        // defined by corner
        if (lowestIndex <= highestIndex && elementToBeFind >= arr[lowestIndex] &&
                elementToBeFind <= arr[highestIndex])
        {

            // Probing the position
            // with keeping uniform
            // distribution in mind.
            pos = lowestIndex + (((highestIndex - lowestIndex) /
                    (arr[highestIndex] - arr[lowestIndex])) *
                    (elementToBeFind - arr[lowestIndex]));

            // Condition of
            // target found
            if(arr[pos] == elementToBeFind) {
                return pos;
            }

            // If x is larger, x is in right sub array
            if(arr[pos] < elementToBeFind) {
                return interpolation_search(arr, pos + 1,
                        highestIndex, elementToBeFind);
            }

            // If x is smaller, x is in left sub array
            if(arr[pos] > elementToBeFind) {
                return interpolation_search(arr, lowestIndex,
                        pos - 1, elementToBeFind);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        int elementToBeFind = 55;

        // Function call
        int result = interpolation_search(arr, 0, arr.length - 1, elementToBeFind);
        if (result == -1) {
            System.out.print("Element is not present in array");
        } else {
            System.out.print("Element is present at index " + result);
        }
    }


}
