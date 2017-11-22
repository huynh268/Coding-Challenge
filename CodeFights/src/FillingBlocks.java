/**
 * Created by Tien on 11/20/2017.
 * https://codefights.com/interview-practice/task/yWF4MmhvtmzfKNWgt
 * You have a block with the dimensions 4 × n. Find the number of different ways you can fill this block with smaller blocks that have the dimensions 1 × 2. You are allowed to rotate the smaller blocks.

 Example

 For n = 1, the output should be
 fillingBlocks(n) = 1.

 There is only one possible way to arrange the smaller 1 × 2 blocks inside the 4 × 1 block.

 For n = 4, the output should be
 fillingBlocks(n) = 36.
 */
public class FillingBlocks {

    //https://math.stackexchange.com/questions/664113/count-the-ways-to-fill-a-4-times-n-board-with-dominoes
    //F(n) = F(n-1) + 5F(n-2) + F(n-3) - F(n-4)
    //O(n) Time complexity - O(n) Space
    public static int fillingBlocks1(int n) {
        switch (n) {
            case 1: return 1;
            case 2: return 5;
            case 3: return 11;
            case 4: return 36;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 5;
        dp[3] = 11;
        dp[4] = 36;

        int i = 5;
        while(i <= n) {
            //F(n) = F(n-1) + 5F(n-2) + F(n-3) - F(n-4)
            dp[i] = dp[i-1] + 5*dp[i-2] + dp[i-3] - dp[i-4];
            i++;
        }

        return dp[n];
    }

    //F(n) = F(n-1) + 5F(n-2) + F(n-3) - F(n-4)
    //O(n) Time complexity - O(1) Space
    public static int fillingBlocks2(int n) {
        if(n == 1) return 1;
        if(n == 2) return 5;
        if(n == 3) return 11;
        if(n == 4) return 36;

        //Initialize a,b,c,d,f ~ dp[1],dp[2],dp[3],dp[4],dp[n]
        int a = 1, b = 5, c = 11, d = 36, f = 0;

        for(int i = 0; i <= n; i++) {
            f = 0;

            //F(n) = F(n-1) + 5F(n-2) + F(n-3) - F(n-4)
            f = d + 5*c + b - a;

            //Update a,b,c,d
            a = b;
            b = c;
            c = d;
            d = f;
        }

        return f;
    }
}
