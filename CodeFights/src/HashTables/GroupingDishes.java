package HashTables;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Tien on 12/5/2017.
 * You have a list of dishes. Each dish is associated with a list of ingredients used to prepare it.
 * You want to group the dishes by ingredients, so that for each ingredient you'll be able to find all
 * the dishes that contain it (if there are at least 2 such dishes).
 *
 * Return an array where each element is a list with the first element equal to the name of the ingredient
 * and all of the other elements equal to the names of dishes that contain this ingredient.
 * The dishes inside each list should be sorted lexicographically.
 * The result array should be sorted lexicographically by the names of the ingredients in its elements.

 * Example
 For
 dishes = [["Salad", "Tomato", "Cucumber", "Salad", "Sauce"],
 ["Pizza", "Tomato", "Sausage", "Sauce", "Dough"],
 ["Quesadilla", "Chicken", "Cheese", "Sauce"],
 ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]]

 the output should be

 groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
 ["Salad", "Salad", "Sandwich"],
 ["Sauce", "Pizza", "Quesadilla", "Salad"],
 ["Tomato", "Pizza", "Salad", "Sandwich"]]
 */
public class GroupingDishes {

    String[][] groupingDishes1(String[][] dishes) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < dishes.length; i++) {
            for(int j = 1; j < dishes[i].length; j++) {
                ArrayList<String> temp = new ArrayList<>();
                if(hm.containsKey(dishes[i][j])){
                    temp = hm.get(dishes[i][j]);
                    temp.add(dishes[i][0]);
                    hm.put(dishes[i][j], temp);
                }
                else{
                    temp.add(dishes[i][0]);
                    hm.put(dishes[i][j], temp);
                    list.add(dishes[i][j]);
                }
            }
        }

        int size = list.size();
        Collections.sort(list);

        ArrayList<String[]> l = new ArrayList<>();

        for(int i = 0 ; i < size; i++) {
            if(hm.get(list.get(i)).size() > 1) {
                ArrayList<String> temp = hm.get(list.get(i));
                Collections.sort(temp);
                temp.add(0, list.get(i));
                l.add(temp.toArray(new String[0]));
            }
        }

        return l.toArray(new String[0][0]);
    }

    //Functional Programming
    //Credit: helfper https://codefights.com/profile/helfper
    String[][] groupingDishes2(String[][] dishes) {
        return Arrays.stream(dishes)
                .flatMap(d -> Arrays.stream(d).skip(1).map(i -> new AbstractMap.SimpleEntry(i, d[0])))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey, TreeMap::new, Collectors.mapping(Map.Entry::getValue, Collectors.toList())))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .map(e -> Stream.concat(Stream.of(e.getKey()), e.getValue().stream().sorted()).toArray(String[]::new))
                .toArray(String[][]::new);
    }

}
