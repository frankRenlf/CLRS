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
 * @createTime : 2022/12/18 9:57
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1703 {

    public int minMoves(int[] nums, int k) {
        List<Integer> g = new ArrayList<Integer>();
        List<Integer> preSum = new ArrayList<Integer>();
        preSum.add(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                g.add(i - g.size());
                preSum.add(preSum.get(preSum.size() - 1) + g.get(g.size() - 1));
            }
        }
        int m = g.size(), res = Integer.MAX_VALUE;
        for (int i = 0; i <= m - k; i++) {
            int mid = i + k / 2;
            int r = g.get(mid);
            res = Math.min(res, (1 - k % 2) * r + (preSum.get(i + k) - preSum.get(mid + 1)) - (preSum.get(mid) - preSum.get(i)));
        }
        return res;
    }

}
