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
 * @createTime : 2022/11/13 15:51
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T791 {

    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char o : order.toCharArray()) {
            if (map.containsKey(o)) {
                int val = map.get(o);
                while (val != 0) {
                    sb.append(o);
                    val--;
                }
                map.remove(o);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            char c = entry.getKey();
            while (val != 0) {
                sb.append(c);
                val--;
            }
        }
        return sb.toString();
    }

}
