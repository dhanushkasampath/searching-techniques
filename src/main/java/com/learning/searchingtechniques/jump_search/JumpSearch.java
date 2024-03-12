package com.learning.searchingtechniques.jump_search;

/**
 * Like Binary Search, Jump Search is a searching algorithm for ****sorted arrays.
 * The basic idea is to check fewer elements (than linear search) by jumping ahead by fixed steps or skipping
 * some elements in place of searching all elements.
 */
public class JumpSearch {

    /**
     * STEP 1: Jump from index 0 to index 4;
     * STEP 2: Jump from index 4 to index 8;
     * STEP 3: Jump from index 8 to index 12;
     * STEP 4: Since the element at index 12 is greater than 55, we will jump back a step to come to index 8.
     * STEP 5: Perform a linear search from index 8 to get the element 55.
     *
     * @param arr of elements
     * @param elementToBeFind element to be find
     * @return index of the element
     */
    public static int jump_search(int[] arr, int elementToBeFind){
        //getting the length of the array
        int arrayLength = arr.length;

        //getting the size of the jump. normally it's the square root of length
        int jumpStepSize = (int)Math.floor(Math.sqrt(arrayLength));

        //finding the block where element is present
        int prev = 0;
        for (int minStep = Math.min(jumpStepSize, arrayLength)-1;
             arr[minStep] < elementToBeFind;
             minStep = Math.min(jumpStepSize, arrayLength)-1)
        {
            prev = jumpStepSize;
            jumpStepSize += (int)Math.floor(Math.sqrt(arrayLength));
            if (prev >= arrayLength) {
                return -1;
            }
        }

        // Doing a linear search for x in block
        // beginning with prev.
        while (arr[prev] < elementToBeFind)
        {
            prev++;

            // If we reached next block or end of
            // array, element is not present.
            if (prev == Math.min(jumpStepSize, arrayLength)) {
                return -1;
            }
        }

        // If element is found
        if (arr[prev] == elementToBeFind) {
            return prev;
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        int elementToBeFind = 55;

        // Function call
        int result = jump_search(arr, elementToBeFind);
        if (result == -1) {
            System.out.print("Element is not present in array");
        } else {
            System.out.print("Element is present at index " + result);
        }
    }
}
