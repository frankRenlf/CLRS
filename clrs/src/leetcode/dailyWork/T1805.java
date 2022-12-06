package leetcode.dailyWork;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/12/6 9:42
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1805 {

    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        int left = 0, right = 0;
        int len = word.length();
        while (right < len) {
            while (left < len && !Character.isDigit(word.charAt(left))) {
                left++;
            }
            if (left == len) break;
            right = left;
            while (right < len && Character.isDigit(word.charAt(right))) {
                right++;
            }
            while (right - left > 1 && word.charAt(left) == '0') left++;
            set.add(word.substring(left, right));
            left = right;
        }
        return set.size();
    }

}
