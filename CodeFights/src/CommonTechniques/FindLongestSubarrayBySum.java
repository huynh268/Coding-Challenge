package CommonTechniques;

/**
 * Created by Tien on 11/22/2017.
 * You have an unsorted array arr of non-negative integers and a number s. Find a longest contiguous subarray in arr that has a sum equal to s. Return two integers that represent its inclusive bounds. If there are several possible answers, return the one with the smallest left bound. If there are no answers, return [-1].

 Your answer should be 1-based, meaning that the first position of the array is 1 instead of 0.

 Example

 For s = 12 and arr = [1, 2, 3, 7, 5], the output should be
 findLongestSubarrayBySum(s, arr) = [2, 4].

 The sum of elements from the 2nd position to the 4th position (1-based) is equal to 12: 2 + 3 + 7.

 For s = 15 and arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], the output should be
 findLongestSubarrayBySum(s, arr) = [1, 5].

 The sum of elements from the 1st position to the 5th position (1-based) is equal to 15: 1 + 2 + 3 + 4 + 5.

 For s = 15 and arr = [1, 2, 3, 4, 5, 0, 0, 0, 6, 7, 8, 9, 10], the output should be
 findLongestSubarrayBySum(s, arr) = [1, 8].

 The sum of elements from the 1st position to the 8th position (1-based) is equal to 15: 1 + 2 + 3 + 4 + 5 + 0 + 0 + 0
 */
public class FindLongestSubarrayBySum {

    //Brute Force
    public static int[] findLongestSubarrayBySum1(int s, int[] arr) {
        if(arr.length == 1 && arr[0] == s) return new int[]{1,1};
        int[] r = new int[]{-1,-1};
        for(int i = 0; i < arr.length-1; i++){
            int sum = arr[i];
            for(int j = i+1; j < arr.length; j++) {
                sum += arr[j];
                if(sum == s) {
                    if(r[1] == -1) {
                        r[0] = i;
                        r[1] = j;
                    } else {
                        if(r[1]  < j && r[0] == i)
                            r[1] = j;
                    }
                }
            }
        }

        return r[1] != -1 ? new int[] {r[0]+1, r[1]+1} : new int[]{-1};
    }


    public static int[] findLongestSubarrayBySum2(int v, int[] arr) {
        int n = arr.length;
        if(n == 1 && arr[0] == v) return new int[]{1,1};

        int sum = 0;
        int p = 0;
        int l = 0, r = 0;
        for(int i = 0; i < n; i++) {
            sum += arr[i];

            while(sum > v) {
                sum -= arr[p];
                p++;
            }

            if(sum == v && ((r == 0) || (i - p > r - l))){
                l = p+1;
                r = i+1;
            }
        }

        return r == 0 ? new int[]{-1} :  new int[]{l,r};
    }
}
