package leetcode.dailyWork;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/1/20 10:52
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T1817 {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> activeMinutes = new HashMap<Integer, Set<Integer>>();
        for (int[] log : logs) {
            int id = log[0], time = log[1];
            activeMinutes.putIfAbsent(id, new HashSet<Integer>());
            activeMinutes.get(id).add(time);
        }
        int[] answer = new int[k];
        for (Set<Integer> minutes : activeMinutes.values()) {
            int activeCount = minutes.size();
            answer[activeCount - 1]++;
        }
        return answer;
    }

}
