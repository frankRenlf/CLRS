package leetcode.dailyWork;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/2/7 10:17
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; ++i) {
            String name = keyName[i];
            String time = keyTime[i];
            int t = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
            map.computeIfAbsent(name, k -> new ArrayList<>()).add(t);
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> el : map.entrySet()) {
            List<Integer> count = el.getValue();
            int n = count.size();
            if (n > 2) {
                Collections.sort(count);
                for (int i = 0; i < n - 2; ++i) {
                    if (count.get(i + 2) - count.get(i) <= 60) {
                        ans.add(el.getKey());
                        break;
                    }
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
