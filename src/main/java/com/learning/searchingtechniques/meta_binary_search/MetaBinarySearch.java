package com.learning.searchingtechniques.meta_binary_search;

import com.google.common.math.BigIntegerMath;

import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Vector;

/**
 * This algorithm is designed to reduce the number of
 * comparisons needed to search the list for a given
 * element.
 */
public class MetaBinarySearch {

    /**
     * 1. Store number of bits to represent the largest array index in variable lg.
     * 2. Use lg to start off the search in a for loop.
     * 3. If the element is found return pos.
     * 4. Otherwise, incrementally construct an index to reach the target value in the for loop.
     * 5. If element found return pos otherwise -1.
     *
     * @return index of the element found
     */
    static int meta_binary_search(Vector<Integer> vector, int key_to_search) {
        int n = vector.size();
        // Set number of bits to represent largest array index
        int lg = BigIntegerMath.log2(BigInteger.valueOf(n-1), RoundingMode.UNNECESSARY) + 1;

        int pos = 0;
        for (int i = lg - 1; i >= 0; i--) {
            if (vector.get(pos) == key_to_search) {
                return pos;
            }

            // Incrementally construct the
            // index of the target value
            int new_pos = pos | (1 << i);

            // find the element in one
            // direction and update position
            if ((new_pos < n) && (vector.get(new_pos) <= key_to_search)) {
                pos = new_pos;
            }
        }

        // if element found return pos otherwise -1
        return ((vector.get(pos) == key_to_search) ? pos : -1);
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<Integer>();
        int[] arr = {-2, 10, 100, 250, 32315};
        for (int j : arr) {
            vector.add(j);
        }
        int elementToBeFind = 10;
        int result = meta_binary_search(vector, elementToBeFind);
        if (result == -1)
            System.out.print("Element is not present in array");
        else
            System.out.print("Element is present at index " + result);
    }
}
