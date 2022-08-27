package leetcode.stage1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode
 * @createTime : 2022/8/19 12:21
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day11 {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                count++;
            }
        }
        return count;
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combine_dfs(1, n, k, list, ret);
        return ret;
    }

    private void combine_dfs(int i, int n, int k, List<Integer> list, List<List<Integer>> ret) {
        if (list.size() + n - i + 1 < k) {
            return;
        }
        if (list.size() == k) {
            ret.add(new ArrayList<>(list));
            return;
        }
        list.add(i);
        combine_dfs(i + 1, n, k, list, ret);
        list.remove(list.size() - 1);
        combine_dfs(i + 1, n, k, list, ret);
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permute_dfs(nums, list, ret);
        return ret;
    }

    private void permute_dfs(int[] nums, List<Integer> list, List<List<Integer>> ret) {
        if (list.size() == nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) continue;
            list.add(num);
            permute_dfs(nums, list, ret);
            list.remove(list.size() - 1);
        }
    }

    public List<String> letterCasePermutation1(String s) {
        List<String> ret = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        letterCasePermutation_dfs1(0, s, str, ret);
        return ret;
    }

    private void letterCasePermutation_dfs1(int cur, String s, StringBuilder str, List<String> ret) {
        if (cur == s.length()) {
            ret.add(new String(str.toString()));
            return;
        }
        char c = s.charAt(cur);
        if (Character.isDigit(c)) {
            str.append(c);
            letterCasePermutation_dfs1(cur + 1, s, str, ret);
        } else {
            str.append(c);
            letterCasePermutation_dfs1(cur + 1, s, str, ret);
            str.deleteCharAt(str.length() - 1);
            if (c < 91) {
                str.append(Character.toLowerCase(c));
            } else {
                str.append(Character.toUpperCase(c));
            }
            letterCasePermutation_dfs1(cur + 1, s, str, ret);
        }
        str.deleteCharAt(str.length() - 1);
    }

    public List<String> letterCasePermutation(String s) {
        List<String> ret = new ArrayList<>();
        char[] charList = s.toCharArray();
        StringBuilder str = new StringBuilder();
        int len = s.length();
        letterCasePermutation_dfs(0, len, str, charList, ret);
        return ret;
    }
    // compared with first method, refine the time complexity
    private void letterCasePermutation_dfs(int cur, int end, StringBuilder str, char[] charList, List<String> ret) {
        if (cur == end) {
            ret.add(str.toString());
            return;
        }
        if (Character.isDigit(charList[cur])) {
            letterCasePermutation_dfs(cur + 1, end, str.append(charList[cur]), charList, ret);
        } else {
            letterCasePermutation_dfs(cur + 1, end, str.append(charList[cur]), charList, ret);
            str.deleteCharAt(str.length() - 1);
            letterCasePermutation_dfs(cur + 1, end, str.append((char) (charList[cur] ^ 32)), charList, ret);
        }
        str.deleteCharAt(str.length() - 1);
    }


    public static void main(String[] args) {
        day11 d11 = new day11();
        System.out.println(d11.combine(4, 2));
    }

}
