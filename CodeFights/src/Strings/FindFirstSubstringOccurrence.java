package Strings;

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

    //Rabin-Karp Algorithm
    public static int findFirstSubstringOccurrence(String txt, String pat) {
        int d = 256;
        int q = 101;
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M-1; i++)
            h = (h*d)%q;

        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++)
        {
            p = (d*p + pat.charAt(i))%q;
            t = (d*t + txt.charAt(i))%q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++)
        {

            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters on by one
            if ( p == t )
            {
                /* Check for characters one by one */
                for (j = 0; j < M; j++)
                {
                    if (txt.charAt(i+j) != pat.charAt(j))
                        break;
                }

                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M){
                    System.out.println("Pattern found at index " + i);
                    return i;
                }
            }

            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if ( i < N-M )
            {
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q;

                // We might get negative value of t, converting it
                // to positive
                if (t < 0)
                    t = (t + q);
            }
        }
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
