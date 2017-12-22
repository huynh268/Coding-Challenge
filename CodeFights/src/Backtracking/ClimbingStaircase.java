package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 12/20/2017.
 *
 * You need to climb a staircase that has n steps, and you decide to get some extra exercise by jumping up the steps.
 * You can cover at most k steps in a single jump. Return all the possible sequences of jumps that you could take to climb the staircase, sorted.

 Example

 For n = 4 and k = 2, the output should be

 climbingStaircase(n, k) =
 [[1, 1, 1, 1],
 [1, 1, 2],
 [1, 2, 1],
 [2, 1, 1],
 [2, 2]]
 There are 4 steps in the staircase, and you can jump up 2 or fewer steps at a time.
 There are 5 potential sequences in which you jump up the stairs either 2 or 1 at a time.
 */
public class ClimbingStaircase {

    int[][] climbingStaircase(int n, int k) {
        if(n==0)
            return new int[1][0];

        List<Integer> sequences = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        solve(n, k, sequences, result);

        return result.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    void solve(int steps, int maxJump, List<Integer> sequences, List<List<Integer>> result) {
        if(steps == 0) {
            result.add(new ArrayList<>(sequences));
            return;
        }

        for(int i = 1; i <= steps && i <= maxJump; i++) {
            sequences.add(i);
            solve(steps-i, maxJump, sequences, result);
            sequences.remove(sequences.size()-1);
        }
    }
}
