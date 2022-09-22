package leetcode.stage3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/22 10:36
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day12 {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length, m = pieces.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(pieces[i][0], i);
        }
        for (int i = 0; i < n; ) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            int index = map.get(arr[i]), len = pieces[index].length;
            for (int j = 1; j < len; j++) {
                if (arr[i + j] != pieces[index][j]) return false;
            }
            i += len;
        }
        return true;
    }

}
