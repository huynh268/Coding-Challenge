/**
 * Created by Tien on 10/24/2017.
 */
public class SubsetSum {

    //Using DP
    static boolean isSubetSum(int[] nums, int sum) {
        int len = nums.length;

        boolean[][] subset = new boolean[len+1][sum+1];

        //Sum != 0 and nums is empty
        for(int i = 0; i < sum+1; i++) {
            subset[0][i] = false;
        }

        //Sum == 0, then initialize True since empty set is the subset of every set.
        for(int i = 1; i < len+1; i++) {
            subset[i][0] = true;
        }

        for(int i = 1; i < len+1; i++) {
            for(int j = 1; j < sum+1; j++) {
                if(j < nums[i-1]) { //if value at index i-1 is larger than sum j
                    //subset[i][j] equals to subset[i-1][j] the one already stored from last iteration
                    subset[i][j] = subset[i-1][j];
                } else {
                    //if value at index i-1 is smaller than sum j
                    //subset[i][j] equals to subset[i-1][j] the one already stored from last iteration
                    //OR subset[i][j] equals to subset[i-1][j - nums[i-1]] which is the sum of other numbers in nums
                    //   and already went through from last iteration
                    subset[i][j] = subset[i-1][j] || subset[i-1][j - nums[i-1]];
                }
            }
        }

        ///Print out dp table
        for (int j = 0; j <= sum;j++)
            System.out.printf("%10d",j);
        System.out.println();
        for (int i = 0; i <= len; i++)
        {
            System.out.printf("%d", i);
            for (int j = 0; j <= sum;j++)
                System.out.printf("%10b",subset[i][j]);
            System.out.println();
        }

        return subset[len][sum];
    }


    public static void main(String[] args) {
        int arr1[] = {2, 3, 7, 8};
        System.out.print(isSubetSum(arr1, 11));
    }
}
