package leetcode.dailyWork;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/27 22:10
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T2309 {

    public String greatestLetter(String s) {
        char ret = '0';
        Set<Character> map = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!map.contains(c)) {
                if ((Character.toLowerCase(c) != c && map.contains(Character.toLowerCase(c)))
                        || (Character.toUpperCase(c) != c && map.contains(Character.toUpperCase(c)))) {
                    char x = Character.toUpperCase(c);
                    if (x > ret) {
                        ret = x;
                    }
                } else {
                    map.add(c);
                }
            }
        }
        return ret == '0' ? "" : String.valueOf(ret);
    }

    static T2309 t2309 = new T2309();

    public static void main(String[] args) {
        System.out.println(t2309.greatestLetter("arRAzFif"));
    }

}
