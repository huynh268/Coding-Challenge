package CommonTechniques;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Tien on 12/16/2017.
 *
 * Given an array of integers, write a function that determines whether the array contains any duplicates.
 * Your function should return true if any element appears at least twice in the array, and it should return false if every element is distinct.

 Example

 For a = [1, 2, 3, 1], the output should be
 containsDuplicates(a) = true.

 There are two 1s in the given array.

 For a = [3, 1], the output should be
 containsDuplicates(a) = false.

 The given array contains no duplicates.
 */
public class ContainsDuplicates {

    boolean containsDuplicates1(int[] a) {
        HashMap<Integer,Boolean> hash = new HashMap<>();
        for(int i : a){
            if(hash.containsKey(i))
                return true;
            else
                hash.put(i, true);
        }
        return false;
    }

    boolean containsDuplicates2(int[] a) {
        HashSet<Integer> hs = new HashSet<>();

        for(int i : a) {
            if(hs.contains(i))
                return true;
            else
                hs.add(i);
        }
        return false;
    }

    boolean containsDuplicates3(int[] a) {
        HashSet<Integer> hs = new HashSet<>();

        for(int i : a) {
            hs.add(i);
        }
        System.out.println(hs.size());
        return hs.size() != a.length;
    }
}
