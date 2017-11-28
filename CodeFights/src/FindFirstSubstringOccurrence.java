/**
 * Created by Tien on 11/12/2017.
 */
public class FindFirstSubstringOccurrence {

    //Brute force
    public static int findFirstSubstringOccurrence1(String s, String x) {
        char[] cs = s.toCharArray();
        char[] cx = x.toCharArray();

        for(int i = 0; i < cs.length; i++) {
            if(i + cx.length > cs.length) return -1;

            int j = 0;
            while(j < cx.length && cs[i+j] == cx[j])
                j++;

            if(j == cx.length)
                return i;
        }
        return -1;
    }

    //KMP Algorithm
    public static int findFirstSubstringOccurrence2(String s, String x) {

        return -1;
    }

    public static void main(String[] args) {
        String  s1 = "CodefightsIsAwesome",
                x1 = "IA",
                x2 = "IsA",
                s2 = "GTgpEYIWKIWrlEtByHryETrBeTWNkHutWKOCvVNRSGSxaynjzTatJMKSwCLSCZObaNNGCXQssfEEDDJIPBwtkMmTniKaKfqaOtvO",
                x3 = "vCLSCZObaNNGCXQssfEEDDJIPBwtkMmTniKa",
                s3 = "ATErUUeUkVFVNfxfUKtntOErKmZLUpWpHRASdxjUhzzxygmnNnKabPPgPqyvCLSCZObaNNGCXQssfEEDDJIPBwtkMmTniKapBlrd",
                x4 = "vCLSCZObaNNGCXQssfEEDDJIPBwtkMmTniKa";


        System.out.println("s1 = "+s1);
        System.out.println("x1 = "+x1);
        System.out.println("x2 = "+x2);
        System.out.println("s2 = "+s2);
        System.out.println("x3 = "+x3);
        System.out.println("s3 = "+s3);
        System.out.println("x4 = "+x4);
        System.out.println();
        System.out.println("findFirstSubstringOccurrence1 s1 x1: "+findFirstSubstringOccurrence1(s1,x1));
        System.out.println("findFirstSubstringOccurrence1 s1 x2: "+findFirstSubstringOccurrence1(s1,x2));
        System.out.println("findFirstSubstringOccurrence1 s2 x3: "+findFirstSubstringOccurrence1(s2,x3));
        System.out.println("findFirstSubstringOccurrence1 s3 x4: "+findFirstSubstringOccurrence1(s3,x4));

    }
}
