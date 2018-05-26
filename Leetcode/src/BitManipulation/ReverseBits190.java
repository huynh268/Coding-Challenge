package BitManipulation;

/**
 * Created by Tien on 4/4/2018.
 *
 * https://leetcode.com/problems/reverse-bits/description/
 *
 * Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 return 964176192 (represented in binary as 00111001011110000010100101000000).

 Follow up:
 If this function is called many times, how would you optimize it?
 */
public class ReverseBits190 {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            ans <<= 1;
            ans += n&1;
            n >>= 1;
        }
        return ans;
    }
}
