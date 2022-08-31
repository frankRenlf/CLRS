package leetcode.stage2;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/8/31 10:35
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day8 {

    static day8 d8 = new day8();

    public static void main(String[] args) {
        System.out.println(d8.subsetsWithDup(new int[]{1, 2, 2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(nums);
        subsetsWithDup_dfs(ret, stack, false, nums, 0);
        return ret;
    }

    private void subsetsWithDup_dfs(List<List<Integer>> ret, Stack<Integer> stack, boolean isSelectPre, int[] nums, int cur) {
        if (cur == nums.length) {
            ret.add(new ArrayList<>(stack));
            return;
        }
        subsetsWithDup_dfs(ret, stack, false, nums, cur + 1);
        if (!isSelectPre && cur >= 1 && nums[cur - 1] == nums[cur]) {
            return;
        }
        stack.push(nums[cur]);
        subsetsWithDup_dfs(ret, stack, true, nums, cur + 1);
        stack.pop();
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        subsets_dfs(ret, stack, nums, 0);

        return ret;
    }

    private void subsets_dfs(List<List<Integer>> ret, Stack<Integer> stack, int[] nums, int i) {
        if (i == nums.length) {
            ret.add(new ArrayList<>(stack));
            return;
        }
        subsets_dfs(ret, stack, nums, i + 1);
        stack.push(nums[i]);
        subsets_dfs(ret, stack, nums, i + 1);
        stack.pop();
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> s1 = new Stack<>();
        int n = pushed.length;
        for (int i = 0, j = 0; i < n; i++) {
            s1.push(pushed[i]);
            while (!s1.isEmpty() && s1.peek() == popped[j]) {
                s1.pop();
                j++;
            }
        }
        return s1.isEmpty();
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || popped.length == 0 || pushed.length == 0) return false;
        Stack<Integer> s1 = new Stack<>();
        int index_pushed = 1;
        int index_popped = 0;
        s1.push(pushed[0]);
        while (index_pushed < pushed.length) {
            if (s1.peek() != popped[index_popped]) {
                s1.push(pushed[index_pushed]);
                index_pushed++;
            } else {
                s1.pop();
                index_popped++;
            }
        }
        while (!s1.isEmpty() && s1.peek() == popped[index_popped]) {
            s1.pop();
            index_popped++;
        }
        return s1.isEmpty();
    }

}
