package Array;

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
        if(nums.length%2 == 0) return (nums[nums.length/2-1] + nums[nums.length/2])/2.0;
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
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 < n2) return findMedianSortedArrays1(nums2, nums1);

        int low = 0;
        int high = 2*n2;

        while(low <= high) {
            int mid2 = (low + high) / 2;
            int mid1 = n1 + n2 - mid2;

            int L1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[(mid1-1)/2];
            int R1 = mid1 == 2 * n1 ? Integer.MAX_VALUE : nums1[mid1/2];
            int L2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[(mid2-1)/2];
            int R2 = mid2 == 2 * n2 ? Integer.MAX_VALUE : nums2[mid2/2];

            if(L1 > R2) low = mid2 + 1;
            else if(L2 > R1) high = mid2 - 1;
            else return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
        }
        return -1;
    }
}
