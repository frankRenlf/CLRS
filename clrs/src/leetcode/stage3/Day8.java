package leetcode.stage3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/19 10:37
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day8 {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            list.add(x);
        }
        list.sort((a, b) -> {
            int x = map.get(a), y = map.get(b);
            return x != y ? x - y : b - a;
        });
//        Integer[] arr = (Integer[]) list.toArray();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
