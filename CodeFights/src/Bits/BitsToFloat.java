package Bits;

/**
 * Created by Tien on 12/15/2017.
 *
 * You have a float number stored in a integer in a following format:

 The fractional part is stored in bits 0-15 (counting from the least significant bit)
 The integer part is stored in bits 16-30
 Return the input converted to a regular float (integer part.fractional part).
 Example

 For bits = 65539, the output should be
 bitsToFloat(bits) = 1.3.

 6553910 = 00000000 00000001 00000000 000000112, so the integer part is 1 and the fractional part is 112 = 310.
 */
public class BitsToFloat {

    double bitsToFloat1(int bits) {
        double intp = (double)((bits & (0xFFFF<<16))>>16);
        double frap = (double)(bits & 0xFFFF);
        while (frap >= 1.) {
            frap /= 10.;
        }
        return intp + frap;
    }

    double bitsToFloat2(int bits) {
        double intp = (double)(bits >>16);
        double frap = (double)(bits & 0xFFFF);
        while (frap >= 1.) {
            frap /= 10.;
        }
        return intp + frap;
    }
}
