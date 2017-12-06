package HashTables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Tien on 12/5/2017.
 * You have a collection of coins, and you know the values of the coins and the quantity of each type of coin in it.
 * You want to know how many distinct sums you can make from non-empty groupings of these coins.

 Example

 For coins = [10, 50, 100] and quantity = [1, 2, 1], the output should be
 possibleSums(coins, quantity) = 9.

 Here are all the possible sums:

 50 = 50;
 10 + 50 = 60;
 50 + 100 = 150;
 10 + 50 + 100 = 160;
 50 + 50 = 100;
 10 + 50 + 50 = 110;
 50 + 50 + 100 = 200;
 10 + 50 + 50 + 100 = 210;
 10 = 10;
 100 = 100;
 10 + 100 = 110.
 As you can see, there are 9 distinct sums that can be created from non-empty groupings of your coins.
 */
public class PossibleSums {

    int possibleSums(int[] coins, int[] quantity) {
        HashSet<Integer> sums = new HashSet<>(); //Store all sums
        sums.add(0); //Initialize

        for(int i = 0; i < quantity.length; i++) {
            //Store sums of all subsets that iteration went through
            //Then use them to calculate the sums of new subsets
            //Ex: start with [1,2] then curSum = [0,1] and sums = [0,1,2,3]
            //    add 4 into the subset [1,2] -> [1,2,4], then curSum = [0,1,2,3] sums = [0,1,2,3,4,5,6,7]
            List<Integer> curSum = new ArrayList<>(sums);
            for(int s :  curSum) {
                for(int j = 1; j <= quantity[i]; j++) {
                    //update sums - if (s+j*coins[i]) is in sums then the size does not change
                    sums.add(s + j*coins[i]);
                }
            }
        }
        return sums.size()-1; //0 is not counted
    }
}
