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

    //Bubble sort
    public int[] bubbleSort(int[] a) {
        int len = a.length;
        int[] result = copyArray(a);
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
        int[] result = copyArray(a);
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

    //Copy array
    private int[] copyArray(int[] a){
        int[] copy = new int[a.length];
        System.arraycopy(a,0,copy,0,a.length);
        return copy;
    }

    public static void main(String[] args) {
        Sorting sorting = new Sorting();
        int[] array =  sorting.generateRandomArray();
        long startTime = System.nanoTime();
        int[] result = sorting.bubbleSortOptimized(array);
        long endTime = System.nanoTime();
        System.out.println("Running time(nano): " + (endTime-startTime));
        System.out.print("Random Integers: ");
        for(int i: array) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.print("After sorting: ");
        for(int i: result) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("isSorted: " + sorting.isSorted(result));
    }
}
