import java.util.*;
/**
 * Created by Tien on 11/11/2017.
 */
public class SumOfTwo {

    //O(nlogn) Time comlexity
    public static boolean sumOfTwo1(int[] a, int[] b, int v) {
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = b.length-1;
        while(i < a.length && j >= 0) {
            if(a[i] + b[j] == v){
                System.out.print("a = "+a[i]+", b = "+b[j]+ " ,");
                return true;
            }
            else if(a[i] + b[j] < v) i++;
            else j--;
        }
        return false;
    }

    //O(n) Time comlexity
    public static boolean sumOfTwo2(int[] a, int[] b, int v) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0 ; i < a.length; i++) {
            hs.add(v- a[i]);
        }
        for(int i = 0; i < b.length; i++) {
            if(hs.contains(b[i])){
                System.out.print("a = "+(v - b[i])+", b = "+b[i]+ " ,");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {17, 72, 18, 72, 73, 15, 83, 90, 8, 18};
        int[] b = {100, 27, 33, 51, 2, 71, 76, 19, 16, 43};
        int v1 = 37, v2 = 10, v3 = 11;
        System.out.print("a = {");
        for(int i = 0; i< a.length; i++)
            System.out.print(a[i]+" ");
        System.out.println("}");
        System.out.print("b = {");
        for(int i = 0; i< b.length; i++)
            System.out.print(b[i]+" ");
        System.out.println("}");
        System.out.println();


        System.out.println("sumOfTwo1 "+v1+" : "+sumOfTwo1(a,b,v1));
        System.out.println("sumOfTwo2 "+v1+" : "+sumOfTwo2(a,b,v1));
        System.out.println();

        System.out.println("sumOfTwo1 "+v2+" : "+sumOfTwo1(a,b,v2));
        System.out.println("sumOfTwo2 "+v2+" : "+sumOfTwo2(a,b,v2));
        System.out.println();


        long startTime1 = System.currentTimeMillis();
        System.out.println("sumOfTwo1 "+v3+" : "+sumOfTwo1(a,b,v3));
        long endTime1   = System.currentTimeMillis();
        long totalTime1 = endTime1 - startTime1;

        long startTime2 = System.currentTimeMillis();
        System.out.println("sumOfTwo2 "+v3+" : "+sumOfTwo2(a,b,v3));
        long endTime2   = System.currentTimeMillis();
        long totalTime2 = endTime2 - startTime2;

        System.out.println("Runtime1 = "+totalTime1+" , Runtime2 = "+ totalTime2);
    }
}
