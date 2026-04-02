class Solution {
    String res = "";
    int maxLength = 1;
    String ms = "";
    int p[];

    void manacherString() {
        ms = "@";
        for (char x : res.toCharArray()) {
            ms += "#" + x;
        }
        ms += "#$";
        p = new int[ms.length()];
    }

    void manacherAlgo() {
        int n = ms.length();
        int l = 0, r = 0;
        for (int i = 1; i < n - 1; i++) {

            int mirror = l + r - i;

            if (i < r) {
                p[i] = Math.min(p[mirror], r - i);
            }

            while (ms.charAt(i - 1 - p[i]) == ms.charAt(i + 1 + p[i])) {
                p[i]++;
            }

            if (i + p[i] > r) {
                l = i - p[i];
                r = i + p[i];
            }
        }

    }

    int getLongest(int cen, int odd) {
        int pos = 2 * cen + 2 + (odd == 0 ? 1 : 0);
        return p[pos];
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;
        res = s;
        manacherString();
        manacherAlgo();
        int maxLen = 1;
        int n = s.length();
        int bestStart = 0;

        for (int i = 0; i < n; i++) {

            int oddLen = getLongest(i, 1);
            if (oddLen > maxLen) {
                maxLen = oddLen;
                bestStart = i - maxLen / 2;
            }

            int evenLen = getLongest(i, 0);
            if (evenLen > maxLen) {
                maxLen = evenLen;
                bestStart = i - maxLen / 2 + 1;
            }
        }
        
        return s.substring(bestStart, bestStart + maxLen);
    }
}