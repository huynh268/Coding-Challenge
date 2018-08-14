/**
 * Created by Tien on 8/13/2018.
 */
public class ArraysAndStrings {

    /**
     * Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param s
     * @return
     */
    public boolean uniqueCharacters1(String s) {
        int[] chars = new int[256];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(chars[c] != 0) return false;
            chars[c]++;
        }
        return true;
    }

    /**
     * Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param s
     * @return
     */
    public boolean uniqueCharacters2(String s) {
        int chars = 0;
        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if((chars & (1<<c)) != 0) return false;
            chars |= (1<<c);
        }
        return true;
    }

    /**
     * Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     * @param s
     * @return
     */
    public boolean uniqueCharacters3(String s) {
        for(int i = 0; i < s.length()-1; i++) {
            for(int j = i+1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) return false;
            }
        }
        return true;
    }

    /**
     * Write code to reverse a C-Style String. (C-String means that “abcd” is represented as five characters, including the null character.)
     *
     * void reverse(char *s) {
     *     char * nd = s;
     *     char tmp;
     *
     *     if(str) {
     *         while(*end) {
     *             end++;
     *         }
     *         end--;
     *
     *         char *tmp;
     *         while(s < end) {
     *             tmp = *end;
     *             *s++ = *end;
     *             *end-- = tmp;
     *         }
     *     }
     * }
     * @param s
     * @return
     */
    public String reverse(String s) {
        if (s.isEmpty())
            return s;

        char[] c = s.toCharArray();
        int i = 0, j = s.length()-1;
        char tmp;

        while(i < j) {
            tmp = c[i];
            c[i++] = c[j];
            c[j--] = tmp;
        }

        return c.toString();
    }

    public void removeDuplicate(String s) {
        if(s.isEmpty() || s.length() < 2) return;

        char[] c = s.toCharArray();
        int check = 0;
        
    }
}
