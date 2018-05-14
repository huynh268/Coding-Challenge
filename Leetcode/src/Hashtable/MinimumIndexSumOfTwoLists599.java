package Hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tien on 5/13/2018.
 *
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
 *
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

 You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers,
 output all of them with no order requirement. You could assume there always exists an answer.

 Example 1:
 Input:
 ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 Output: ["Shogun"]
 Explanation: The only restaurant they both like is "Shogun".

 Example 2:
 Input:
 ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 ["KFC", "Shogun", "Burger King"]
 Output: ["Shogun"]
 Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).


 Note:
 The length of both lists will be in the range of [1, 1000].
 The length of strings in both lists will be in the range of [1, 30].
 The index is starting from 0 to the list length minus 1.
 No duplicates in both lists.

 */
public class MinimumIndexSumOfTwoLists599 {

    /**
     * O(l1 + l2) Time complexity
     * O(l) Space - where l is the number of tie answers
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < list1.length; i++) hm.put(list1[i], i);

        List<String> ans = new ArrayList<>();
        int min = list1.length + list2.length;
        for(int i = 0; i < list2.length; i++) {
            if(hm.containsKey(list2[i])) {
                if(i + hm.get(list2[i]) < min) {
                    ans.clear();
                    min = i + hm.get(list2[i]);
                    ans.add(list2[i]);
                } else if(i + hm.get(list2[i]) == min) {
                    ans.add(list2[i]);
                }
            }
        }

        return ans.toArray(new String[0]);
    }
}
