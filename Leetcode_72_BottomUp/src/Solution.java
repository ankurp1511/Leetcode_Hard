public class Solution {
    public static void main(String[] args) {

        String word1 = "horse";
        String word2 = "ros";
        System.out.println(editDistance(word1.length(), word2.length(), word1, word2, new int[word1.length()+1][word2.length()+1]));
    }

    private static int editDistance(int n, int m, String word1, String word2, int[][] t) {

        for (int i = 1; i <= word1.length() ; i++) {
            t[i][0] = i;
        }
        for (int j = 1; j <= word2.length() ; j++) {
            t[0][j] = j;
        }

        for (int i = 1 ; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    t[i][j] = t[i-1][j-1];
                } else {
                    t[i][j] = 1 + Math.min(t[i][j-1], Math.min(t[i-1][j], t[i-1][j-1]));
                }
            }
        }
        return t[n][m];
    }
}
