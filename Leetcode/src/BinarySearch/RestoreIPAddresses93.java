package BinarySearch;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 Example:
 Input: "25525511135"
 Output: ["255.255.11.135", "255.255.111.35"]
 */

public class RestoreIPAddresses93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) return ans;
        backtrack(s, 0, "", ans);
        return ans;
    }

    private void backtrack(String s, int count, String cur, List<String> ans) {
        if(count == 3 && s.length() > 0 && s.length() <= 3 && Integer.valueOf(s) <= 255) {
            if(s.length() > 1 && s.charAt(0) == '0') return;
            ans.add(cur + "." + s);
            return;
        }

        for(int i = 1; i < s.length() && i <= 3; i++) {
            if(Integer.valueOf(s.substring(0, i)) > 255) continue;
            if(i > 1 && s.charAt(0) == '0') continue;
            if(count == 0) backtrack(s.substring(i), count+1, s.substring(0, i), ans);
            else backtrack(s.substring(i), count+1, cur + "." + s.substring(0, i), ans);
        }
    }
}
