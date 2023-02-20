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
 * @createTime : 2023/2/20 11:00
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T2347 {
    public String bestHand(int[] ranks, char[] suits) {
        int i = 1;
        for (; i < suits.length; i++) {
            if (suits[i - 1] != suits[i]) {
                break;
            }
        }
        if (i == suits.length) {
            return "Flush";
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int rank :
                ranks) {
            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }
        if (map.size() == 5) return "High Card";
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 2) {
                return "Three of a Kind";
            }
        }
        return "Pair";
    }
}
