import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Tien on 10/22/2017.
 * 373. Find K Pairs with Smallest Sums
 */

public class kSmallestPairs373 {

    /*
        You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
        Define a pair (u,v) which consists of one element from the first array and one element from the second array.
        Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

        Example 1:
        Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
        Return: [1,2],[1,4],[1,6]
        The first 3 pairs are returned from the sequence:
        [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

        Example 2:
        Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
        Return: [1,1],[1,1]
        The first 2 pairs are returned from the sequence:
        [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
     */

    //Naive solution: Add all possible pairs into a list, then sort the list by the sum of pair
    //O(m*n) time complexity - O(m*n) space
    public static List<int[]> kSmallestPairs(int[] n1, int[] n2, int k) {
        List<int[]> list =  new ArrayList<>();

        for(int i = 0; i < n1.length; i++) {
            for(int j = 0; j < n2.length; j++) {
                list.add(new int[]{n1[i], n2[j]});
            }
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]+o1[1] - o2[0]-o2[1];
            }
        });

        if(n1.length*n2.length < k) {
            return list;
        }

        return list.subList(0,k);
    }

    public static void main(String[] args) {
        System.out.print("[ ");
        for(int[] i: kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 10)) {
            System.out.printf("[%d,%d] ", i[0], i[1]);
        }
        System.out.println("]");
    }

}


