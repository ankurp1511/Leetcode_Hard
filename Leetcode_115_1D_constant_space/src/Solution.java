public class Solution {

    public static void main(String[] args) {

        System.out.println(numDistinct("bagbbag", "bag"));
    }

    public static int numDistinct(String s, String t) {
        return distinctSubsequenceCount(s, t, s.length(), t.length());
    }

    private static int distinctSubsequenceCount(String s, String t, int m, int n) {

        int[] prev = new int[n+1];
        prev[0] = 1;

        for (int a = 1 ;a < m +1; a++) {
            for (int b = n; b >= 1; b--) {
                if (s.charAt(a-1) == t.charAt(b-1)) {
                    prev[b] = prev[b-1] + prev[b];
                }
            }
        }
        return prev[n];
    }
}
