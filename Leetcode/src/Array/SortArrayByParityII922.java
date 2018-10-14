package Array;

/**
 * Created by Tien on 10/13/2018.
 *
 *
 *
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 You may return any answer array that satisfies this condition.



 Example 1:
 Input: [4,2,5,7]
 Output: [4,5,2,7]
 Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.


 Note:
 2 <= A.length <= 20000
 A.length % 2 == 0
 0 <= A[i] <= 1000
 */
public class SortArrayByParityII922 {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityII1(int[] A) {
        int tmp;
        int j = 0;;
        for(int i = 0; i < A.length; i++) {
            if((i + A[i])%2 == 0) continue;
            if(j == 0) j = i+1;
            while(j < A.length) {
                if((i+A[j])%2 == 0 && (j+A[j])%2 != 0) break;
                j++;
            }
            tmp = A[j];
            A[j] = A[i];
            A[i] = tmp;
        }
        return A;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityII2(int[] A) {
        int tmp;
        int j = 1;
        for(int i = 0; i < A.length; i++) {
            if(A[i]%2 != 0) {
                while(j < A.length && A[j]%2 != 0) j += 2;
                tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
}
