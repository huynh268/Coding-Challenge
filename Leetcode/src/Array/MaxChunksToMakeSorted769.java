package Array;

import java.util.Arrays;

/**
 * Created by Tien on 4/22/2018.
 *
 *
 *
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions),
 * and individually sort each chunk.  After concatenating them, the result equals the sorted array. What is the most number of chunks we could have made?

 Example 1:
 Input: arr = [4,3,2,1,0]
 Output: 1
 Explanation:
 Splitting into two or more chunks will not return the required result.
 For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.

 Example 2:
 Input: arr = [1,0,2,3,4]
 Output: 4
 Explanation:
 We can split into two chunks, such as [1, 0], [2, 3, 4].
 However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.

 Note:
 arr will have length in range [1, 10].
 arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
 */
public class MaxChunksToMakeSorted769 {

    /**
     * Since arr[i] is a permutation of [0, 1, ..., arr.length - 1], we use the index of array for comparison.
     * O(n) Time complexity
     * O(1) Space
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if(max == i) ans++;
        }
        return ans;
    }

    /**
     * This solution works on the case which arr[i] is not a permutation of [0, 1, ..., arr.length - 1].
     * arr[i] is a random number.
     * O(nlogn) Time complexity
     * O(n) Space
     * @param arr
     * @return
     */
    public int maxChunksToSorted2(int[] arr) {
        int[] max = new int[arr.length];
        int currentMax = 0;
        for(int i = 0; i < arr.length; i++) {
            currentMax = Math.max(currentMax, arr[i]);
            max[i] = currentMax;
        }

        Arrays.sort(arr);
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            if(max[i] == arr[i]) ans++;
        }

        return ans;
    }
}
