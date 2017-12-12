import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Tien on 10/12/2017.
 */
public class Sorting {
    public int n = 1000;

    //Generate an array of random integers
    public int[] generateRandomArray() {
        int[] array = new int[n];
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            array[i] = random.nextInt(n);
        }
        return array;
    }

    //Check result
    public boolean isSorted(int[] a) {
        for(int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                return false;
            }
        }
        return true;
    }
    ////////////////////////////////////////////////////////////////////////
    //Bubble sort
    public int[] bubbleSort(int[] a) {
        int len = a.length;
        int[] result = copyArray(a, 0, len);
        int temp;

        for(int i = 0; i < len-1; i++) {
            for(int j = 0; j < len - i - 1; j++) {
                if(result[j] > result[j+1]) {
                    temp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = temp;
                }
            }
        }
        return result;
    }

    //Bubble sort optimized
    public int[] bubbleSortOptimized(int[] a) {
        int len = a.length;
        int[] result = copyArray(a, 0, len);
        boolean swapped =  true;
        int temp;
        int i = 0;
        while(swapped) {
            swapped = false;
            for(int j = 0; j < len - i - 1; j++) {
                if(result[j] > result[j+1]) {
                    temp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = temp;
                    swapped = true;
                }
            }
        }
        return result;
    }

    ////////////////////////////////////////////////////////////////////////

    //Merge sort
    public int[] mergeSort(int[] a) {
        int len = a.length;
        if(len <= 1) return a;
        int middle = len/2;
        int[] left = copyArray(a, 0, middle);
        int[] right = copyArray(a, middle, len);

        return merge2(mergeSort(left),mergeSort(right));
    }


    //Merge 2 arrays
    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length+right.length];
        int l = 0, r = 0;

        for(int i = 0; i < result.length; i++) {
            if(r >= right.length) result[i] = left[l++];
            else if(l >= left.length) result[i] = right[r++];
            else if(left[l] > right[r]) result[i] = right[r++];
            else result[i] = left[l++];
        }
        return result;
    }

    //Merge 2 arrays using while
    public int[] merge2(int[] A, int[] B) {
        int m = A.length - 1;
        int n = B.length - 1;
        int[] result = new int[A.length + B.length];
        int k = result.length - 1;

        while (m >= 0 && n >= 0) {
            if(A[m] > B[n]) {
                result[k--] = A[m--];
            } else {
                result[k--] = B[n--];
            }
        }

        while (m >= 0) {
            result[k--] = A[m--];
        }
        while (n >= 0) {
            result[k--] = B[n--];
        }

        return result;
    }

    ////////////////////////////////////////////////////////////////////////


    //Copy array
    private int[] copyArray(int[] a, int start, int end){
        int[] copy = new int[end - start];
        int length = end - start;
        System.arraycopy(a,start,copy,0,length);
        return copy;
    }

    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        int[] array =  sorting.generateRandomArray();

        System.out.print("Random Integers: ");
        for(int i: array) {
            System.out.print(i+" ");
        }
        System.out.println();

        long startTime = System.nanoTime();
        int[] result = sorting.bubbleSortOptimized(array);
        long endTime = System.nanoTime();
        System.out.println("isSorted (Bubble sort): " + sorting.isSorted(result));

        long startTime2 = System.nanoTime();
        int[] result2 = sorting.mergeSort(array);
        long endTime2 = System.nanoTime();
        System.out.println("isSorted (Merge sort) : " + sorting.isSorted(result2));

        System.out.println("Runtime Bubble sort: " + (endTime-startTime));
        System.out.println("Runtime Merge sort : " + (endTime2-startTime2));
    }
}
