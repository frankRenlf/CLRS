package leetcode.stage2;

import com.sun.source.tree.Tree;
import leetcode.algorithm.TreeNode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/9/5 9:37
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day13 {

    Set<TreeNode> set = new HashSet<>();
    Map<String, TreeNode> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        find_dfs(root);
        return new ArrayList<>(set);
    }

    private String find_dfs(TreeNode root) {
        if (root == null) return "";
        String str = "" + root.val + "(" + find_dfs(root.left) + ")" + "(" + find_dfs(root.right) + ")";
        if (map.containsKey(str)) {
            set.add(map.get(str));
        } else {
            map.put(str, root);
        }
        return str;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        int left = 0, right = -1;
        for (int i = 0; i < length; i++) {
            int l1 = calLen(s, i, i);
            int l2 = calLen(s, i, i + 1);
            int len = Math.max(l1, l2);
            if (len > right - left + 1) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    private int calLen(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
