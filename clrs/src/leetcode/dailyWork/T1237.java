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
 * @createTime : 2023/2/18 18:44
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */

class CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public int f(int x, int y) {
        return x + y;
    }
};

public class T1237 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int x = 1, y = 1000; x <= 1000 && y >= 1; x++) {
            while (y >= 1 && customfunction.f(x, y) > z) {
                y--;
            }
            if (y >= 1 && customfunction.f(x, y) == z) {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(x);
                pair.add(y);
                res.add(pair);
            }
        }
        return res;
    }
}
