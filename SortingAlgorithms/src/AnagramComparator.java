import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Tien on 10/15/2017.
 */
public class AnagramComparator implements Comparator<String> {

    public String sortChar(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    @Override
    public int compare(String s1, String s2) {
        return sortChar(s1).compareTo(sortChar(s2));
    }

    public static void main(String[] args) {
        String[] input = {"dog", "cat", "tac", "god", "ogd", "dgo", "cta"};
        AnagramComparator anagramComparator = new AnagramComparator();

        System.out.print("Input       : ");
        for(String s: input) {
            System.out.print(s+ " ");
        }
        System.out.println();

        Arrays.sort(input);
        System.out.print("Sorted input: ");
        for(String s: input) {
            System.out.print(s+ " ");
        }
        System.out.println();

        Arrays.sort(input, anagramComparator);
        System.out.print("Anagram Sort: ");
        for(String s: input) {
            System.out.print(s+ " ");
        }


    }
}
