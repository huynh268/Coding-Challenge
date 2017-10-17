/**
 * Created by Tien on 10/16/2017.
 */
public class CodeFights {

    /*
     * Several friends live along a straight street. They are friends, thus they enjoy visiting each other.
     * However, they are lazy so none of them wants to visit a friend living more than maxDist meters away from them.
     * Given array houses representing coordinates of points where the friends live (in meters) and an integer maxDist,
     * return an array representing the number of friends each person would be willing to visit.
     *
     * Example
     *      For houses = [1, 2, 4, 8, 10] and maxDist = 5, the output should be
     *      lazyFriends(houses, maxDist) = [2, 2, 3, 2, 1].
     */

    //The time complexity for this algorithm is O(n^2) and O(n) space
    public static int[] lazyFriends(int[] houses, int maxDist) {
        int l = houses.length, m, n;
        int res[] = new int[l];
        for(int i: res)
            res[i] = 0;

        for(m = 0; m < l-1; m++)
            for(n = m+1; n < l; n++)
                if(houses[n]-houses[m]<= maxDist) {
                    res[m]++;
                    res[n]++;
                }
        return res;
    }

    public static void main(String[] args) {
        int[] houses1 = {1, 2, 4, 8, 10},
              houses2 = {-5, 0, 5, 10, 15},
              houses3 = {1, 2, 3, 4, 5, 6};

        System.out.print("houses1 and maxDist = 5 : ");
        for(int i: lazyFriends(houses1, 5)) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("houses2 and maxDist = 10: ");
        for(int i: lazyFriends(houses2, 10)) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("houses3 and maxDist = 3 : ");
        for(int i: lazyFriends(houses3, 3)) {
            System.out.print(i + " ");
        }
    }

}
