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
 * @createTime : 2022/10/17 11:17
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T904 {

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int max = 0;
        for (; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                int cnt = map.get(fruits[left]);
                if (cnt - 1 == 0) {
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], cnt - 1);
                }
                left++;
            }
            max = Math.max(right - left + 1, max);
        }
        return max;
    }

    static T904 t904 = new T904();

    public static void main(String[] args) {
        System.out.println(t904.totalFruit(new int[]{1, 0, 1, 4, 1, 4, 1, 2, 3}));
    }

}
