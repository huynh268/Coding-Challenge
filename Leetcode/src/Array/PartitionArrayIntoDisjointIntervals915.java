package Array;

/**
 * Created by Tien on 10/7/2018.
 *
 * https://leetcode.com/problems/partition-array-into-disjoint-intervals/description/
 *
 * Given an array A, partition it into two (contiguous) subarrays left and right so that:
 Every element in left is less than or equal to every element in right.
 left and right are non-empty.
 left has the smallest possible size.
 Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.



 Example 1:
 Input: [5,0,3,8,6]
 Output: 3
 Explanation: left = [5,0,3], right = [8,6]

 Example 2:
 Input: [1,1,1,0,6,12]
 Output: 4
 Explanation: left = [1,1,1,0], right = [6,12]


 Note:
 2 <= A.length <= 30000
 0 <= A[i] <= 10^6
 It is guaranteed there is at least one way to partition A as described.
 */
public class PartitionArrayIntoDisjointIntervals915 {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param A
     * @return
     */
    public int partitionDisjoint1(int[] A) {
        int n = A.length;
        int[] max = new int[n], min = new int[n];
        max[0] = A[0];
        min[n-1] = A[n-1];
        for(int i = 1; i < n; i++) max[i] = Math.max(max[i-1], A[i]);
        for(int i = n-2; i >= 0; i--) min[i] = Math.min(min[i+1], A[i]);
        for(int i = 1; i < n; i++) if(max[i-1] <= min[i]) return i;
        return n;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param A
     * @return
     */
    public int partitionDisjoint2(int[] A) {
        int n = A.length;
        int[] min = new int[n];
        int maxL = A[0];
        min[n-1] = A[n-1];

        for(int i = n-2; i >= 0; i--) {
            min[i] = Math.min(min[i+1], A[i]);
        }

        for(int i = 1; i < n; i++) {
            if(maxL <= min[i]) return i;
            maxL = Math.max(maxL, A[i]);
        }

        return n;
    }
    
    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param A
     * @return
     */
    public int partitionDisjoint3(int[] A) {
        int maxL = A[0]; //max value of left group
        int max = A[0]; //max value from A[0] to current A[i]
        int partIndex = 0; //partition index
        for(int i = 1; i < A.length; i++) {
            if(maxL > A[i]) { //if max of left group is greater than A[i], repartition
                maxL = max; //update max of left group to the current max value from A[0] to A[i]
                partIndex = i;
            } else {
                max = Math.max(max, A[i]);
            }
        }
        return partIndex + 1;
    }
}
