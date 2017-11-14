import java.util.HashMap;

/**
 * Created by Tien on 11/13/2017.
 */
public class SortByString {

    //O(|s|*|t|)
    public static String sortByString1(String s, String t) {
        String r = "";
        for(int i = 0; i < t.length(); i++) {
            for(int j = 0; j < s.length(); j++) {
                if(t.charAt(i) == s.charAt(j)){
                    r += t.charAt(i);
                }
            }
        }
        return r;
    }

    public static String sortByString2(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(!hm.containsKey(s.charAt(i)))
                hm.put(s.charAt(i), 1);
            else
                hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
        }

        String r = "";
        for(int i = 0; i < t.length(); i++) {
            if(hm.containsKey(t.charAt(i))){
                int j = hm.get(t.charAt(i));
                while(j-- > 0)
                    r+=t.charAt(i);
            }
        }
        return r;
    }

    public static void main(String[] args) {
        String  s1 = "good",
                t1 = "odg",
                s2 = "weather",
                t2 = "therapyw";

        long startTime1 = System.currentTimeMillis();
        System.out.println("sortByString1: "+sortByString1(s1,t1));
        System.out.println("sortByString1: "+sortByString1(s2,t2));
        long endTime1   = System.currentTimeMillis();
        long totalTime1 = endTime1 - startTime1;
        System.out.println("runtime1: "+totalTime1);
        System.out.println();

        long startTime2 = System.currentTimeMillis();
        System.out.println("sortByString2: "+sortByString2(s1,t1));
        System.out.println("sortByString2: "+sortByString2(s2,t2));
        long endTime2  = System.currentTimeMillis();
        long totalTime2 = endTime2 - startTime2;
        System.out.println("runtime2: "+ totalTime2);
    }
}
