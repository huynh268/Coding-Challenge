/**
 * Created by Tien on 1/31/2018.
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays4 {

    /**
     * Merge 2 sorted arrays
     * O(n+m) Time complexity
     * O(n+m) Space
     * @param nums1
     * @param nums2
     * @return
     */
    double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] nums = merge(nums1, nums2);
        if(nums.length%2 == 0) return (double) (nums[nums.length/2-1] + nums[nums.length/2])/2;
        return nums[nums.length/2];
    }

    //O(n+m) time complexity, O(m+n) Space
    int[] merge(int[] a, int[] b) {
        int m = 0, n = 0, k = 0;
        int[] c = new int[a.length+b.length];
        while(m < a.length && n < b.length) {
            c[k++] = a[m] < b[n] ? a[m++] : b[n++];
        }
        while(m < a.length) c[k++] = a[m++];
        while(n < b.length) c[k++] = b[n++];

        return c;
    }

    /**
     * O(log(n+m)) Time complexity
     * @param nums1
     * @param nums2
     * @return
     */
    double findMedianSortedArrays2(int[] nums1, int[] nums2) {

    }
}
