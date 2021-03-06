package Hashtable;

import java.util.HashMap;

/**
 * Created by Tien on 9/16/2018.
 *
 *
 *
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 You start at any tree of your choice, then repeatedly perform the following steps:
 Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.

 You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 What is the total amount of fruit you can collect with this procedure?



 Example 1:
 Input: [1,2,1]
 Output: 3
 Explanation: We can collect [1,2,1].

 Example 2:
 Input: [0,1,2,2]
 Output: 3
 Explanation: We can collect [1,2,2].
 If we started at the first tree, we would only collect [0, 1].

 Example 3:
 Input: [1,2,3,2,2]
 Output: 4
 Explanation: We can collect [2,3,2,2].
 If we started at the first tree, we would only collect [1, 2].

 Example 4:
 Input: [3,3,3,1,2,1,1,2,3,3,4]
 Output: 5
 Explanation: We can collect [1,2,1,1,2].
 If we started at the first tree or the eighth tree, we would only collect 4 fruits.


 Note:
 1 <= tree.length <= 40000
 0 <= tree[i] < tree.length
 */
public class FruitIntoBaskets904 {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param tree
     * @return
     */
    public int totalFruit1(int[] tree) {
        int max = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int j = 0;

        for(int i = 0; i < tree.length; i++) {
            hashMap.put(tree[i], hashMap.getOrDefault(tree[i], 0) + 1);
            while(hashMap.size() > 2) {
                hashMap.put(tree[j], hashMap.get(tree[j]) - 1);
                if(hashMap.get(tree[j]) == 0) hashMap.remove(tree[j]);
                j++;
            }
            max = Math.max(max, i - j + 1);
        }

        return max;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param tree
     * @return
     */
    public int totalFruit2(int[] tree) {
        int max = 0;
        int a = 0, b = 0, curLen = 0, count_b = 0;

        for(int c : tree){
            if(c == b) {
                curLen++;
                count_b++;
            } else if (c == a) {
                curLen++;
                count_b = 1;
                a = b;
                b = c;
            } else {
                curLen = count_b + 1;
                count_b = 1;
                a = b;
                b = c;
            }
        }
    }
}
