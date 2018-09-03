package DynamicProgramming;

import java.util.HashSet;

/**
 * Created by Tien on 9/2/2018.
 *
 * https://leetcode.com/problems/bitwise-ors-of-subarrays/description/
 *
 * We have an array A of non-negative integers.
 For every (contiguous) subarray B = [A[i], A[i+1], ..., A[j]] (with i <= j), we take the bitwise OR of all the elements in B, obtaining a result A[i] | A[i+1] | ... | A[j].
 Return the number of possible results.  (Results that occur more than once are only counted once in the final answer.)



 Example 1:
 Input: [0]
 Output: 1
 Explanation:
 There is only one possible result: 0.

 Example 2:
 Input: [1,1,2]
 Output: 3
 Explanation:
 The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
 These yield the results 1, 1, 2, 1, 3, 3.
 There are 3 unique values, so the answer is 3.

 Example 3:
 Input: [1,2,4]
 Output: 6
 Explanation:
 The possible results are 1, 2, 3, 4, 6, and 7.


 Note:
 1 <= A.length <= 50000
 0 <= A[i] <= 10^9
 */
public class BitwiseORsOfSubarrays898 {

    public int subarrayBitwiseORs1(int[] A) {
        HashSet<Integer> ans = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();

        for(int i : A) {
            HashSet<Integer> set2 = new HashSet<>();
            set2.add(i);
            for(int j : set1) set2.add(i|j);
            set1 = set2;
            ans.addAll(set1);
        }

        return ans.size();
    }

    public int subarrayBitwiseORs2(int[] A) {
        HashSet<Integer> ans = new HashSet<>();

        int max = 0;
        for(int i : A) {
            max |= i;
            ans.add(max);
        }

        for(int i = 1; i < A.length; i++) {
            if((A[i]&A[i-1]) != A[i-1]) {
                int or = 0;
                for(int j = i; j < A.length; j++) {
                    or |= A[j];
                    ans.add(or);
                    if((or & A[i-1]) == A[i-1] || or == max) break;
                }
            }
        }

        return ans.size();
    }
}
