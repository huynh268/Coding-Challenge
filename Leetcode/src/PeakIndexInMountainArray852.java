/**
 * Created by Tien on 6/17/2018.
 *
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
 *
 * Let's call an array A a mountain if the following properties hold:

 A.length >= 3
 There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

 Example 1:
 Input: [0,1,0]
 Output: 1

 Example 2:
 Input: [0,2,1,0]
 Output: 1

 Note:
 3 <= A.length <= 10000
 0 <= A[i] <= 10^6
 A is a mountain, as defined above.
 */
public class PeakIndexInMountainArray852 {

    /**
     * O(n) Time complexity
     * O(1) Space
     * @param A
     * @return
     */
    public int peakIndexInMountainArray1(int[] A) {
        for(int i = 1; i < A.length-1; i++) {
            if(A[i] > A[i+1]) return i;
        }
        return -1;
    }

    public int peakIndexInMountainArray2(int[] A) {
        int left = 0, right = A.length;
        while(left < right) {
            int middle = left + (right - left)/2;
            if(A[middle] < A[middle+1]) {
                left = middle+1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}
