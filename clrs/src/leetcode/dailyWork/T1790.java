package leetcode.dailyWork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/10/11 10:48
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1790 {

    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                list.add(i);
            }
        }
        if (list.size() == 0) return true;
        if (list.size() != 2) return false;
        int p1 = list.get(0), p2 = list.get(1);
        return s1.charAt(p1) == s2.charAt(p2)
                && s1.charAt(p2) == s2.charAt(p1);
    }

}
