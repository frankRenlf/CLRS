package leetcode.dailyWork;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/2/16 10:23
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T2341 {

    public int[] numberOfPairs(int[] nums) {
        int n = nums.length;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int x :
                nums) {
            if (set.contains(x)) {
                count++;
                set.remove(x);
            } else {
                set.add(x);
            }
        }
        return new int[]{count, n - 2 * count};
    }

}
