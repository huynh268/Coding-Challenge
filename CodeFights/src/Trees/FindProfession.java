package Trees;

/**
 * Created by Tien on 11/17/2017.
 * Consider a special family of Engineers and Doctors. This family has the following rules:

 Everybody has two children.
 The first child of an Engineer is an Engineer and the second child is a Doctor.
 The first child of a Doctor is a Doctor and the second child is an Engineer.
 All generations of Doctors and Engineers start with an Engineer.
 We can represent the situation using this diagram:

              E
         /         \
        E           D
      /  \        /  \
    E     D      D    E
   / \   / \    / \   / \
  E   D D   E  D   E E   D
 Given the level and position of a person in the ancestor tree above, find the profession of the person.
 Note: in this tree first child is considered as left child, second - as right.

 Example

 For level = 3 and pos = 3, the output should be
 findProfession(level, pos) = "Doctor".
 */
public class FindProfession {

    //Recursive
    public static String findProfession1(int level, int pos) {
        String  e = "Engineer",
                d = "Doctor";

        if (level == 1)
            return e;
        else if (findProfession1(level - 1, (pos+1)/2) == e)
            return pos%2 == 1 ? e : d;
        else
            return pos%2 == 1 ? d : e;
    }

    /*
    Bitwise
    Level 1: E
    Level 2: ED
    Level 3: EDDE
    Level 4: EDDEDEED
    Level 5: EDDEDEEDDEEDEDDE

    Level input is not necessary because first elements are the same
    The result is based on the count of 1's in binary representation of position-1
    If position is even, then Engineer; Else Doctor
    */
    public static String findProfession2(int level, int pos) {
        String  e = "Engineer",
                d = "Doctor";

        //return (countBit1(pos) - 1)%2 == 0 ? e : d;
        //return (countBit2(pos) - 1)%2 == 0 ? e : d;
        return (Integer.bitCount(pos) - 1)%2 == 0 ? e : d;
    }

    //Count bits
    private static int countBit1(int a) {
        int count = 0;
        while (a > 0) {
            if((a&1) == 1)
                count++;
            a>>=1;
        }
        return count;
    }

    private static int countBit2(int a) {
        int count = 0;
        while(a > 0) {
            count++;
            a &= a-1;
        }
        return count;
    }

    public static void main(String[] args) {
        Long s1 = System.nanoTime();
        System.out.println("level = 3, pos = 3: " + findProfession1(3,3));
        System.out.println("level = 30, pos = 163126329: " + findProfession1(30,163126329));
        System.out.println("Runtime1 = "+ (System.nanoTime() - s1));

        System.out.println();

        Long s2 = System.nanoTime();
        System.out.println("level = 3, pos = 3: " + findProfession2(3,3));
        System.out.println("level = 30, pos = 163126329: " + findProfession2(30,163126329));
        System.out.println("Runtime2 = "+ (System.nanoTime() - s2));

        System.out.println();

        System.out.println("count bits 31 = "+ countBit1(31));
        System.out.println("count bits 31 = "+ countBit2(31));
    }
}
