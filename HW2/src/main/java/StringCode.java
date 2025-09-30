import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     *
     * @param str
     * @return max run length
     */
    public static int maxRun(String str) {
        int max = 1;
        int temp = 1;
        int n = str.length();
        for (int i = 1; i < n; i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                temp++;
            } else {
                temp = 1;
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     *
     * @param str
     * @return blown up string
     */
    public static String blowup(String str) {
        StringBuilder s = new StringBuilder();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int k = c - '0';
                if (i + 1 < str.length()) {
                    for (int j = 0; j < k; j++) {
                        s.append(str.charAt(i + 1));
                    }
                }
            } else s.append(str.charAt(i));
        }
        return s.toString();
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= a.length() - len; i++) {
            set.add(a.substring(i, i + len));
        }
        for (int j = 0; j + len <= b.length() - len; j++) {
            if (set.contains(b.substring(j, j + len))) return true;
        }
        return false;
    }
}
