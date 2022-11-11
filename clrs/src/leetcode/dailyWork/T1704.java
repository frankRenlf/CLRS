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
 * @createTime : 2022/11/11 9:52
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1704 {

    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int div = s.length() / 2;
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < div && set.contains(Character.toLowerCase(s.charAt(i)))) {
                ret++;
            } else if (i >= div && set.contains(Character.toLowerCase(s.charAt(i)))) {
                ret--;
            }
        }
        return ret == 0;
    }

}
