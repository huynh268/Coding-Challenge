package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Tien on 1/18/2018.
 *
 *https://leetcode.com/problems/relative-ranks/description/
 *
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores,
 * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

 Example 1:
 Input: [5, 4, 3, 2, 1]
 Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 For the left two athletes, you just need to output their relative ranks according to their scores.

 Note:
 - N is a positive integer and won't exceed 10,000.
 - All the scores of athletes are guaranteed to be unique.

 */
public class RelativeRanks506 {

    /**
     * O(n) Time complexity
     * O(n) Space
     * @param nums
     * @return
     */
    String[] findRelativeRanks1(int[] nums) {
        int n = nums.length;
        int max = 0;

        for(int num : nums) max = max > num ? max : num;

        int[] hash = new int[max + 1];
        for(int i = 0; i < n; i++) hash[nums[i]] = i+1;

        String[] ans = new String[n];
        int rank = 1;
        for(int i = max; i >= 0; i--) {
            if(hash[i] != 0) {
                if(rank == 1) ans[hash[i]-1] = "Gold Medal";
                else if(rank == 2) ans[hash[i]-1] = "Silver Medal";
                else if(rank == 3) ans[hash[i]-1] = "Bronze Medal";
                else ans[hash[i]-1] = ""+ rank;
                rank++;
            }
        }
        return ans;
    }

    /**
     * O(nlogn) Time complexity - Sort array
     * O(n) Space
     * @param nums
     * @return
     */
    String[] findRelativeRanks2(int[] nums) {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int j = n-1;
        while(j >= 0) {
            hashMap.put(copy[j], n-j);
            j--;
        }

        String[] ans = new String[n];
        for(int i = 0; i < n; i++) {
            int rank = hashMap.get(nums[i]);
            if(rank == 1) ans[i] = "Gold Medal";
            else if(rank == 2) ans[i] = "Silver Medal";
            else if(rank == 3) ans[i] = "Bronze Medal";
            else ans[i] = "" + rank;
        }

        return ans;
    }
}
