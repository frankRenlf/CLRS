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
 * @createTime : 2023/2/23 10:28
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T1238 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(start);
        for (int i = 1; i <= n; i++) {
            int m = ret.size();
            for (int j = m - 1; j >= 0; j--) {
                ret.add(((ret.get(j) ^ start) | (1 << (i - 1))) ^ start);
            }
        }
        return ret;
    }
}
