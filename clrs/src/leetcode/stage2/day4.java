package leetcode.stage2;

import leetcode.algorithm.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/8/27 10:22
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day4 {


    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer, Integer> levelMin = new HashMap<Integer, Integer>();
        return dfs(levelMin, root, 1, 1);
    }

    public int dfs(Map<Integer, Integer> levelMin, TreeNode node, int depth, int index) {
        if (node == null) {
            return 0;
        }
//        if(!levelMin.containsKey(depth))
        levelMin.putIfAbsent(depth, index); // 每一层最先访问到的节点会是最左边的节点，即每一层编号的最小值
        return Math.max(index - levelMin.get(depth) + 1,
                Math.max(dfs(levelMin, node.left, depth + 1, index * 2),
                        dfs(levelMin, node.right, depth + 1, index * 2 + 1)));
    }


    public List<Integer> findAnagrams(String s, String p) {

    }

}
