package Array;

/**
 * Created by Tien on 1/5/2018.
 *
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 The number of elements initialized in nums1 and nums2 are m and n respectively.


 */
public class MergeSortedArray88 {

    void merge1(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1, i = m-1, j = n-1;
        while(i >= 0 && j >= 0) {
            nums1[k--] =  nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    void merge2(int[] nums1, int m, int[] nums2, int n) {
        while(n > 0) {
            nums1[n+m-1] = (m == 0 || nums2[n-1] > nums1[m-1]) ? nums2[--n] : nums1[--m];
        }
    }

}
