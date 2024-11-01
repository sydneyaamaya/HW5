/******************************************************************
 *
 *   SYDNEY AMAYA / SECTION 001
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90,99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {
        /**
         * B is a subset of A if of it's elements are in A
         * 1.Use a for loop to populate a hash table with list1
         * 2.Use a for loop to iterate through B and see if
         * the hashtable contains each element
         * 3.If there is an element of B not in A, return false
         */
        Hashtable<Integer, String> listOneHash = new Hashtable<>();
        for (int i = 0; i < list1.length; i++){
            listOneHash.put(list1[i], "String");
        }
        for (int i = 0; i < list2.length; i++){
            if(!listOneHash.containsKey(list2[i])){
                return false;
            }
        }
        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {
        /**
         * 1.Iterate through the array and order all the elements
         * in ascending order by using two for loops, one to iterate 
         * through the array and the other to compare each element
         * to every other element 
         * 2.if array[i] is greater than array[j] swap the elements
         * 3.to find the kth largest element in the array in ascending order, 
         * subtract k from the array's length 
         */
        int temp = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = i + 1; j < array.length; j++){
                if (array[i] > array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp; 
                }
            }
        }
        return array[array.length - k];
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
        /**
         * 1.create an array that is the length of array1 + array2
         * 2.add all the elements from array1 and array2 to the array
         * 3.sort the array 
         */
        int [] merged = new int[array1.length + array2.length];
        //count is a variable to keep track of where the last element
        //of array1 was added to the merged array
        int temp = 0;
        for (int i = 0; i < array1.length; i++){
            merged[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++){
            merged[array1.length + i] = array2[i];
        }
        for (int i = 0; i < merged.length; i++){
            for (int j = i + 1; j < merged.length; j++){
                if (merged[i] > merged[j]){
                    temp = merged[i];
                    merged[i] = merged[j];
                    merged[j] = temp; 
                }
            }
        }
        return merged;
    }

}