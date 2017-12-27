package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by Tien on 12/16/2017.
 *
 * Given K sorted arrays, return their sorted concatenation.

 Example

 For arrays = [[1, 3, 5], [2, 3], [2, 3, 5, 8]], the output should be
 mergeKArrays(arrays) = [1, 2, 2, 3, 3, 3, 5, 5, 8].
 */
public class MergeKArrays {


    static ArrayList<Integer> mergeKArrays1(int[][] arrays) {
        int[] firstUnused = new int[arrays.length];
        ArrayList<Integer> result = new ArrayList<>();
        int n = 0;
        for (int i = 0; i < arrays.length; i++) {
            n += arrays[i].length;
        }
        for (int i = 0; i < n; i++) {
            int minIndex = -1,
                    minValue = 0;
            for (int j = 0; j < arrays.length; j++) {
                if (firstUnused[j] < arrays[j].length) {
                    if (minIndex == -1 || minValue > arrays[j][firstUnused[j]] ) {
                        minIndex = j;
                        minValue = arrays[j][firstUnused[j]];
                    }
                }
            }
            result.add(minValue);
            firstUnused[minIndex]++;
        }
        return result;
    }

    /*****************************************************************************************/
    /**
     * Using merge sort to merge k sorted arrays from input
     * @param arrays - contains sorted arrays to be merged
     * @return sorted arrays
     */
    static int[] mergeKArrays2(int[][] arrays) {
        int[] res = merge(arrays[0], arrays[1]);
        for(int i = 2; i < arrays.length; i++) {
            res = merge(res, arrays[i]);
        }

        return res;
    }

    /**
     * Merge 2 sorted arrays
     * @param a - sorted array
     * @param b - sorted array
     * @return a sorted array with elements from a and b
     */
    static int[] merge(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int[] c = new int[m+n];
        int k = 0, i = 0, j = 0;

        while(i < m && j < n) {
            if(a[i] < b[j])
                c[k++] = a[i++];
            else
                c[k++] = b[j++];
        }

        while(i<m) {
            c[k++] = a[i++];
        }

        while(j<n) {
            c[k++] = b[j++];
        }

        return c;
    }

    /*****************************************************************************************/

    static int[] mergeKArrays3(int[][] arrays) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int len = 0;
        for(int i = 0; i < arrays.length; i++) {
            for(int j = 0; j < arrays[i].length; j++) {
                priorityQueue.offer(arrays[i][j]);
                len++;
            }
        }
        int[] res = new int[len];
        int n = 0;
        while (!priorityQueue.isEmpty()){
            res[n++] = priorityQueue.remove();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arrays = {{1, 3, 5}, {2, 3}, {2, 3, 5, 8}};
        System.out.println("merge1: "+Arrays.toString(mergeKArrays1(arrays).toArray(new Integer[0])));
        System.out.println("merge2: "+Arrays.toString(mergeKArrays2(arrays)));
        System.out.println("merge3: "+Arrays.toString(mergeKArrays3(arrays)));
    }
}
