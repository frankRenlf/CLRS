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
 * @createTime : 2023/2/1 20:09
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T2325 {

    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char a = 'a';
        for (char c :
                key.toCharArray()) {
            if (c != ' ' && !map.containsKey(c)) {
                map.put(c, a++);
            }
        }
        StringBuilder ret = new StringBuilder();
        for (char c :
                message.toCharArray()) {
            ret.append(map.getOrDefault(c, ' '));
        }
        return ret.toString();
    }

}
