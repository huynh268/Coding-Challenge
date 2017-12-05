package DynamicProgramming;

/**
 * Created by Tien on 11/18/2017.
 *
 * A top secret message containing uppercase letters from 'A' to 'Z' has been encoded as numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 You are an FBI agent and you need to determine the total number of ways that the message can be decoded.

 Since the answer could be very large, take it modulo 109 + 7.

 Example

 For message = "123", the output should be

 mapDecoding(message) = 3.

 "123" can be decoded as "ABC" (1 2 3), "LC" (12 3) or "AW" (1 23), so the total number of ways is 3.
 */
public class MapDecoding {
    public static int mapDecoding1(String s) {
        int n = s.length();

        if (n <= 0) return 1;
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {

            int a = Integer.valueOf(s.substring(i-1,i)); //1 digit
            int b = Integer.valueOf(s.substring(i-2,i)); //2 digits: i and i-1

            //check if 1 digit is valid
            if (a > 0 && a < 10)
                dp[i] += dp[i-1]%(1000000007);
            //check if number with 2 digits is valid (in range [10-26])
            if (b >= 10 && b <= 26)
                dp[i] += dp[i-2]%(1000000007);
        }

        return dp[n]%(1000000007);
    }

    public static int mapDecoding2(String s) {
        int n = s.length();
        if (n <= 0) return 1;
        if (n == 1 && s.charAt(0) != '0') return 1;
        int a,b,c;
        a = b = c = 0;
        if(s.charAt(0) != '0')
            a = b = 1;

        for(int i = 1; i < n; i++) {
            c = 0;
            if(s.charAt(i) != '0')
                c += a;

            int d = Integer.valueOf(s.substring(i-1, i+1));
            if(d >=10 && d <= 26)
                c += b;

            b = a%(1000000007);
            a = c%(1000000007);
        }
        return c%(1000000007);
    }

    public static void main(String[] args) {

    }
}
