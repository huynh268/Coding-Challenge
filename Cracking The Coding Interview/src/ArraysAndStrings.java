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

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
     * NOTE: One or two additional variables are fine. An extra copy of the array is not.
     FOLLOW UP
     Write the test cases for this method.
     1- Empty string
     2- String does not contain duplicate
     3- String contains all duplicates
     4- String with all continuous duplicates, e.g.: aaabbbb
     5- String with non-contiguous duplicates, e.g.: abababa
     * @param s
     */
    public void removeDuplicates1(char[] s) { // C-Style
        if(s == null || s.length < 2) return;

        int seen = 0;

        for(int i = 0; i < s.length; i++) {
            if((seen & (1 << s[i])) != 0) {
                s[i] = '\0'; //null value
            } else {
                seen |= (1<<s[i]);
            }
        }
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
     * NOTE: One or two additional variables are fine. An extra copy of the array is not.
     FOLLOW UP
     Write the test cases for this method.
     * @param s
     */
    public String removeDuplicates2(String s) {
        if(s.isEmpty() || s.length() < 2) return s;

        int seen = 0;
        char[] c = s.toCharArray();

        for(int i = 0; i < c.length; i++) {
            if((seen & (1 << c[i])) > 0) {
                c[i] = '\0';
            } else {
                seen |= (1 << c[i]);
            }
        }

        return new String(c);
    }


    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * Write a method to decide if two strings are anagrams or not.
     * @param s
     * @param t
     * @return
     */
    public boolean anagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] seen = new int[256];

        for(int i = 0; i < s.length(); i++) {
            seen[s.charAt(i)]++;
        }

        for(int i = 0; i < t.length(); i++) {
            seen[t.charAt(i)]--;
            if(seen[t.charAt(i)] < 0) return false;
        }
        return true;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * Write a method to replace all spaces in a string with ‘%20’.
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        if(s.isEmpty()) return s;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') sb.append(s.charAt(i));
            else sb.append("%20");
        }
        return sb.toString();
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
     * write a method to rotate the image by 90 degrees. Can you do this in place?
     * @param matrix
     */
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        int tmp;

        //top -> left and right -> bottom
        //swap diagonal
        for(int i = 0; i < n; i ++) {
            for(int j = i; j < n; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        //left -> right
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n/2; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
     * write a method to rotate the image by 90 degrees. Can you do this in place?
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        int tmp;

        for(int i = 0; i < n/2; i++) {
            for(int j = i; j < n-1-i; j++) {
                tmp = matrix[i][j]; //save top
                matrix[i][j] = matrix[n-1-j][i]; //left -> top
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j]; //bottom -> left
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i]; //right -> bottom
                matrix[j][n-1-i] = tmp; //saved top -> right
            }
        }
    }

    /**
     * Time complexity: O(M*N)
     * Space complexity: O(M + N)
     *
     * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
     * @param matrix
     */
    public void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; i < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(row[i] || col[j]) matrix[i][j] = 0;
            }
        }
    }

    /**
     * Time complexity: O(m*n) where n and m are the length of the search string and pattern respectively.
     * Space complexity: O(m)
     *
     * Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2,
     * write code to check if s2 is a rotation of s1 using only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
     * @param s1
     * @param s2
     * @return
     */
    public boolean isRotation(String s1, String s2) {
        String s = s1 + s1;
        return s.indexOf(s2) >= 0;
    }
}
