package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

/**
 * Created by Tien on 12/20/2017.
 */
public class CombinationSum {

    String combinationSum(int[] a, int sum) {
        if(a.length == 0) return "";
        Arrays.sort(a);
        List<String> subset = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();

        solve(a, sum, 0, subset, result);

        if(result.size() == 0) return "Empty";
        Collections.sort(result, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> l1, List<String> l2){
                int size1 = l1.size();
                int size2 = l2.size();
                int len = size1 > size2? size2:size1;

                for(int i = 0; i < len; i++) {
                    if(!l1.get(i).equals(l2.get(i)))
                        return Integer.parseInt(l1.get(i))-Integer.parseInt(l2.get(i));
                }
                return l2.size()-l1.size();
            }
        });

        String s = "";
        for(List<String> l : result) {
            String ss = String.join(" ", l);
            s+= "("+ss+")";
        }
        return s;
    }

    void solve(int[] a, int sum, int start, List<String> subset, List<List<String>> result) {
        if(sum < 0) return;
        if(sum == 0) {
            Collections.sort(subset);
            if(!result.contains(subset)){
                result.add(new ArrayList<>(subset));
            }
            return;
        }

        for(int i = start;i < a.length; i++) {
            subset.add(""+a[i]);
            solve(a, sum - a[i], i, subset, result);
            subset.remove(subset.size() - 1);
        }
    }

}
