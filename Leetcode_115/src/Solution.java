public class Solution {

    public static void main(String[] args) {

        System.out.println(numDistinct("rabbbit", "rabbit"));
    }

    public static int numDistinct(String s, String t) {

        return distinctSubsequenceCount(s, t, s.length(), t.length());
    }

    private static int distinctSubsequenceCount(String s, String t, int m, int n) {

        if (n == 0) {
            return 1;
        }
        if (m == 0) {
            return 0;
        }

        if (s.charAt(m-1) == t.charAt(n-1)) {
            return distinctSubsequenceCount(s, t, m-1, n-1) + distinctSubsequenceCount(s, t, m-1, n);
        }
        else {
            return distinctSubsequenceCount(s, t, m-1, n);
        }
    }
}
