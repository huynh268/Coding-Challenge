package Array;

/**
 * Created by Tien on 9/1/2018.
 *
 *
 *
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 Return true if and only if the given array A is monotonic.


 Example 1:
 Input: [1,2,2,3]
 Output: true

 Example 2:
 Input: [6,5,4,4]
 Output: true

 Example 3:
 Input: [1,3,2]
 Output: false

 Example 4:
 Input: [1,2,4,5]
 Output: true

 Example 5:
 Input: [1,1,1]
 Output: true


 Note:
 1 <= A.length <= 50000
 -100000 <= A[i] <= 100000
 */
public class MonotonicArray896 {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param A
     * @return
     */
    public boolean isMonotonic(int[] A) {
        int n = A.length;
        if(n <= 2) return true;

        //inc = -1 or 0 or 1
        //inc = -1 if A[i] < A[i-1]
        //inc = 0 if A[i] == A[i-1]
        //inc = 1 if A[i] > A[i-1]
        int inc = 0;
        for(int i = 1; i < n; i++) {
            if(A[i] == A[i-1]) continue;
            if((inc == 1 && A[i] < A[i-1]) || (inc == -1 && A[i] > A[i-1])) return false;
            if(A[i] > A[i-1]) inc = 1;
            if(A[i] < A[i-1]) inc = -1;
        }

        return true;
    }
}
