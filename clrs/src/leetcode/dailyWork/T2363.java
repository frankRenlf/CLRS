package leetcode.dailyWork;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/2/28 9:56
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ret = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] i1 : items1) {
            map.put(i1[0], i1[1]);
        }
        for (int[] i2 : items2) {
            map.put(i2[0], map.getOrDefault(i2[0], 0) + i2[1]);
        }
        for (Map.Entry<Integer, Integer> el : map.entrySet()) {
            List<Integer> list = new ArrayList<>();
            list.add(el.getKey());
            list.add(el.getValue());
            ret.add(list);
        }
        ret.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        });
        return ret;
    }
}
