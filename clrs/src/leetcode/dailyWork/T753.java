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
 * @createTime : 2023/1/10 10:05
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T753 {

    public String crackSafe(int n, int k) {
        Map<String, Integer> map = new HashMap<>();
        int kn = (int) Math.pow(k, n);//路径数量
        int kn_1 = (int) Math.pow(k, n - 1);//结点数量
        StringBuilder ans = new StringBuilder();
        //初始结点为000...
        ans.append("0".repeat(Math.max(0, n - 1)));
        if (ans.length() == 0) {
            for (int i = 0; i < k; i++) {
                ans.append(i);
            }
            return ans.toString();
        }
        //遍历所有的路
        while (kn != 0) {
            String substring = ans.substring(ans.length() - n + 1, ans.length());
            if (!map.containsKey(substring))
                map.put(substring, k - 1);
            ans.append(map.get(substring));
            map.put(substring, map.get(substring) - 1);
            kn--;
        }
        return ans.toString();
    }
}
