package leetcode.algorithm;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.algorithm
 * @createTime : 2022/8/14 14:27
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class KMP {

    public int kmp(String str, String sub, int pos) {
        // judge
        if (str == null || sub == null) return -1;
        int strLen = str.length(), subLen = sub.length();
        if (strLen == 0 || subLen == 0) return -1;
        if (pos < 0 || pos > strLen) return -1;
        //build next array
        int[] next = new int[strLen];
        Next(sub, next);
        NextVal(sub, next);
        // main part of kmp
        int i = pos, j = 0;
        while (i < strLen) {
            if (j == -1 || str.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
                if (j == subLen) {
                    return i - j;
                }
            } else {
                j = next[j];
            }
        }
        return -1;
    }

    private void NextVal(String sub, int[] next) {
        for (int i = 1; i < sub.length(); i++) {
            if (sub.charAt(i) == sub.charAt(next[i])) {
                next[i] = next[next[i]];
            }
        }
    }

    private void Next(String sub, int[] next) {
        next[0] = -1;
        next[1] = 0;
        int k = 0;
        int i = 2;
        while (i < sub.length()) {
            if (k == -1 || sub.charAt(k) == sub.charAt(i - 1)) {
                next[i] = k + 1;
                k++;
                i++;
            } else {
                k = next[k];
            }
        }
    }

}
