package leetcode;

import leetcode.algorithm.KMP;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode
 * @createTime : 2022/8/14 13:42
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day6 {

    // it can reduce the variables to cut down space complexity
    public int maxScore(String s) {
        int left = 0;
        int right = 1;
        int maxVal = 0;
        if (s.charAt(left) == '0') {
            maxVal++;
        }
        int len = s.length();
        for (int i = right; i < len; i++) {
            if (s.charAt(i) == '1') {
                maxVal++;
            }
        }
        int ret = maxVal;
        for (int i = right; i < len - 1; i++) {
            if (s.charAt(i) == '1') {
                maxVal--;
            } else {
                maxVal++;
            }
            ret = Math.max(ret, maxVal);
        }
        return ret;
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 1) {
            return 1;
        }
        int sum = 0;
        int ret = 0;
        int index = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                sum++;
                ret = Math.max(ret, sum);
            } else {
                while (index < len && set.contains(s.charAt(i))) {
                    set.remove(s.charAt(index));
                    index++;
                    sum--;
                }
                i--;
            }
        }
        return ret;
    }

    public boolean checkInclusion(String s1, String s2) {
        KMP Kmp = new KMP();
        return Kmp.kmp(s1, s2, 0) != -1;
    }

    public static void main(String[] args) {
        day6 d6 = new day6();
        System.out.println(d6.lengthOfLongestSubstring("aab"));
    }

}
