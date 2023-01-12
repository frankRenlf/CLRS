package leetcode.dailyWork;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/12 9:44
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1807 {

    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder ans = new StringBuilder();
        Map<String, String> dict = new HashMap<String, String>();
        for (List<String> kd : knowledge) {
            dict.put(kd.get(0), kd.get(1));
        }
        int index = 0, r = 0;
        int n = s.length();
        while (index < n) {
            if (s.charAt(index) == '(') {
                r = index + 1;
                while (s.charAt(r) != ')') {
                    r++;
                }
                String frag = s.substring(index + 1, r);
                String add = dict.getOrDefault(frag, null);
                ans.append(add == null ? "?" : add);
                index = r;
            } else {
                ans.append(s.charAt(index));
            }
            index++;
        }
        return ans.toString();
    }

}
