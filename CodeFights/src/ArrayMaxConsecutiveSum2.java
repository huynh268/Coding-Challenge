/**
 * Created by Tien on 11/21/2017.
 * Given an array of integers, find the maximum possible sum you can get from one of its contiguous subarrays. The subarray from which this sum comes must contain at least 1 element.

 Example

 For inputArray = [-2, 2, 5, -11, 6], the output should be
 arrayMaxConsecutiveSum2(inputArray) = 7.

 The contiguous subarray that gives the maximum possible sum is [2, 5], with a sum of 7.
 */
public class ArrayMaxConsecutiveSum2 {

    //Kadane's Algorithm
    public static int arrayMaxConsecutiveSum1(int[] a) {
        int max = Integer.MIN_VALUE;
        int maxValueInclCurrentIndex = 0;

        for(int i = 0; i < a.length; i++) {
            maxValueInclCurrentIndex += a[i];
            if(max < maxValueInclCurrentIndex)
                max = maxValueInclCurrentIndex;
            if(maxValueInclCurrentIndex < 0)
                maxValueInclCurrentIndex = 0;
        }
        return max;
    }


    public static int arrayMaxConsecutiveSum2(int[] a) {
        int max = a[0];
        int maxValueInclCurrentIndex = a[0];

        for(int i = 1; i < a.length; i++) {
            maxValueInclCurrentIndex = Math.max(a[i], maxValueInclCurrentIndex + a[i]);
            max = Math.max(max, maxValueInclCurrentIndex);
        }
        return max;
    }
    public static void main(String[] args) {
        int[]   a1 = {-2, 2, 5, -11, 6},
                a2 = {-3, -2, -1, -4},
                a3 = {89, 96, 60, 10, 24, 30, 72, 40, 74, 49, 38, 87, 55, 46, 44, 14, 49, 88, 93, 11},
                a4 = {11, -2, 1, -4, 5, -3, 2, 2, 2};

        System.out.println("A1: "+arrayMaxConsecutiveSum2(a1));
        System.out.println("A2: "+arrayMaxConsecutiveSum2(a2));
        System.out.println("A3: "+arrayMaxConsecutiveSum2(a3));
        System.out.println("A4: "+arrayMaxConsecutiveSum2(a4));
    }
}
