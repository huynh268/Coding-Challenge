package Sorting;

/**
 * Created by Tien on 12/16/2017.
 *
 * You have a sorted array of integers. Write a function that returns a sorted array containing the squares of those integers.

 Example

 For array = [-6, -4, 1, 2, 3, 5], the output should be
 sortedSquaredArray(array) = [1, 4, 9, 16, 25, 36].

 The array of squared integers from array is: [36, 16, 1, 4, 9, 25]. When sorted, it becomes: [1, 4, 9, 16, 25, 36].
 */
public class SortedSquaredArray {

    int[] sortedSquaredArray(int[] array) {
        int[] r = new int[array.length];
        int i = 0, j = array.length-1;

        for(int a = r.length-1; a >= 0; a--){
            int s = array[-array[i] >  array[j] ? i++: j--];
            r[a] = s*s;
        }

        return r;
    }
}
