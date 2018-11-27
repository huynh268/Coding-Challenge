package BinarySearch;

import java.util.Random;

/**
 * Created by Tien on 8/30/2018.
 *
 *
 *
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

 Note:
 1 <= w.length <= 10000
 1 <= w[i] <= 10^5
 pickIndex will be called at most 10000 times.

 Example 1:
 Input:
 ["Solution","pickIndex"]
 [[[1]],[]]
 Output: [null,0]

 Example 2:
 Input:
 ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 [[[1,3]],[],[],[],[],[]]
 Output: [null,0,1,1,1,0]

 Explanation of Input Syntax:
 The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
public class RandomPickWithWeight528 {
    class Solution {
        int[] wSum;
        Random random;

        public Solution(int[] w) {
            for(int i = 1; i < w.length; i++) {
                w[i] += w[i-1];
            }
            this.wSum = w;
            this.random = new Random();
        }

        public int pickIndex() {
            int len = wSum.length;

            int index = random.nextInt(wSum[len-1]) + 1;
            int left = 0, right = len;

            while(left < right) {
                int mid = left + (right - left)/2;
                if(wSum[mid] == index) {
                    return mid;
                } else if(wSum[mid] < index) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(w);
     * int param_1 = obj.pickIndex();
     */
}
