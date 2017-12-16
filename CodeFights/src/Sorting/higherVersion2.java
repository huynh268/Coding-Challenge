package Sorting;

/**
 * Created by Tien on 12/16/2017.
 *
 * You have two version strings composed of several non-negative decimal fields that are separated by periods (".").
 * Both strings contain an equal number of numeric fields. Return 1 if the first version is higher than the second version,
 * -1 if it is smaller, and 0 if the two versions are the same.

 The syntax follows the regular semver (semantic versioning) ordering rules:

 1.0.5 < 1.1.0 < 1.1.5 < 1.1.10 < 1.2.0 < 1.2.2
 < 1.2.10 < 1.10.2 < 2.0.0 < 10.0.0
 Example

 For ver1 = "1.2.2" and ver2 = "1.2.0", the output should be
 higherVersion2(ver1, ver2) = 1;
 For ver1 = "1.0.5" and ver2 = "1.1.0", the output should be
 higherVersion2(ver1, ver2) = -1;
 For ver1 = "1.0.5" and ver2 = "1.00.05", the output should be
 higherVersion2(ver1, ver2) = 0.
 */
public class higherVersion2 {

    int higherVersion2(String ver1, String ver2) {
        String[] s1 = ver1.split("\\.");
        String[] s2 = ver2.split("\\.");
        for(int i = 0; i < s1.length; i++){
            if(Integer.parseInt(s1[i]) > Integer.parseInt(s2[i])) return 1;
            if(Integer.parseInt(s1[i]) < Integer.parseInt(s2[i])) return -1;
        }
        return 0;
    }
}
