package leetcode.stage3;

import leetcode.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/27 10:24
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day18 {

    public boolean CheckPermutation(String s1, String s2) {
        int[] arr = new int[58];
        for (char x : s1.toCharArray()) {
            arr[x - 'A'] += 1;
        }
        for (char x : s2.toCharArray()) {
            arr[x - 'A'] -= 1;
            if (arr[x - 'A'] < 0) {
                return false;
            }
        }
        return true;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuilder pathSB = new StringBuilder(path);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }

}
