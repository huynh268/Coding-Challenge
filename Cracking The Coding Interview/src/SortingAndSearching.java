import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Tien on 8/21/2018.
 */
public class SortingAndSearching {

    /**
     * 9.1
     *
     * Time complexity: O(n+m);
     * Space complexity: O(1)
     *
     * You are given two sorted arrays, A and B, and A has a large enough buffer at the end to hold B. Write a method to merge B into A in sorted order.
     * @param a
     * @param b
     * @param n
     * @param m
     */
    public void merge(int[] a, int[] b, int n, int m) {
        int k = m+n-1;
        int i = m-1;
        int j = n-1;

        while(i >= 0 && j >= 0) {
            a[k--] = a[i] > b[j] ? a[i--] : b[j--];
        }

        while(j >= 0) {
            a[k--] = b[j--];
        }
    }

    /**
     * 9.2
     *
     * Write a method to sort an array of strings so that all the anagrams are next to each other.
     * @param array
     */
    public void sortAnagram(String[] array) {
        Arrays.sort(array, new Comparator<String>(){
            public String sortChars(String s) {
                char[] c = s.toCharArray();
                Arrays.sort(c);
                return new String(c);
            }

            @Override
            public int compare(String s1, String s2) {
                return sortChars(s1).compareTo(sortChars(s2));
            }
        });
    }
}
