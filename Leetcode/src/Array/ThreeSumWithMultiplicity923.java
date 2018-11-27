package Array;

/**
 * https://leetcode.com/problems/3sum-with-multiplicity/description/
 *
 * Given an integer array A, and an integer target, return the number of tuples i, j, k  such that i < j < k and A[i] + A[j] + A[k] == target.
 As the answer can be very large, return it modulo 10^9 + 7.



 Example 1:

 Input: A = [1,1,2,2,3,3,4,4,5,5], target = 8
 Output: 20
 Explanation:
 Enumerating by the values (A[i], A[j], A[k]):
 (1, 2, 5) occurs 8 times;
 (1, 3, 4) occurs 8 times;
 (2, 2, 4) occurs 2 times;
 (2, 3, 3) occurs 2 times.
 Example 2:

 Input: A = [1,1,2,2,2,2], target = 5
 Output: 12
 Explanation:
 A[i] = 1, A[j] = A[k] = 2 occurs 12 times:
 We choose one 1 from [1,1] in 2 ways,
 and two 2s from [2,2,2,2] in 6 ways.


 Note:

 3 <= A.length <= 3000
 0 <= A[i] <= 100
 0 <= target <= 300
 */
public class ThreeSumWithMultiplicity923 {

    /**
     * Time complexity: O(N^2)
     * Space complexity: O(N)
     * @param A
     * @param target
     * @return
     */
    public int threeSumMulti(int[] A, int target) {
        int MOD = 1_000_000_007;
        long ans = 0;

        long[] count = new long[101];
        int uniq = 0;
        for(int i : A) {
            count[i]++;
            if(count[i] == 1) uniq++;
        }

        int[] keys = new int[uniq];
        for(int i = 0, j = 0; i < count.length; i++) {
            if(count[i] > 0) keys[j++] = i;
        }

        for(int i = 0; i < keys.length-2; i++) {
            int l = i, r = keys.length-1;
            while(l <= r) {
                int sum = keys[i] + keys[l] + keys[r];
                if(sum == 0) {
                    if(keys[i] != keys[l] && keys[l] != keys[r]) {
                        ans += count[keys[i]] * count[keys[l]] * count[keys[r]];
                    } else if(keys[i] == keys[l] && keys[l] != keys[r]) {
                        ans += count[keys[i]] * (count[keys[i]] - 1) / 2 * count[keys[r]];
                    } else if(keys[i] != keys[l] && keys[l] == keys[r]) {
                        ans += count[keys[i]] * count[keys[l]] * (count[keys[l]] - 1) / 2;
                    } else {
                        ans += count[keys[i]] * (count[keys[i]] - 1) * (count[keys[i]] - 2) / 6;
                    }
                    ans %= MOD;
                    l++;
                    r--;
                } else if(sum < 0){
                    l++;
                } else {
                    r--;
                }
            }
        }

        return (int)ans;
    }
}
