package leetcode.dailyWork;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/11 16:46
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T2283 {
    public boolean digitCount(String num) {
        int len = num.length();
        Map<Integer, Integer> map = new HashMap<>();
        char[] crr = num.toCharArray();
        for (char c : crr) {
            int digit = c - '0';
            map.put(digit, map.getOrDefault(digit, 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            if (crr[i] - '0' != map.getOrDefault(i, 0)) {
                return false;
            }
        }
        return true;
    }
}
