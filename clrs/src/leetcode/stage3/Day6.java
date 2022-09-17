package leetcode.stage3;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/17 11:33
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day6 {

    public int maxLengthBetweenEqualCharacters(String s) {
        if (s == null || s.length() < 2) return -1;
        int n = s.length();
        int[] cnt = new int[26];
        Arrays.fill(cnt, -1);
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int pos = s.charAt(i) - 'a';
            if (cnt[pos] == -1) {
                cnt[pos] = i;
            } else {
                maxLen = Math.max(maxLen, i - cnt[pos] - 1);
            }
        }
        return maxLen;
    }

}
