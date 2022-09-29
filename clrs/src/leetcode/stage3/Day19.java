package leetcode.stage3;

import leetcode.algorithm.TreeNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/29 8:11
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day19 {

    public int countNodes(TreeNode root) {
        return calNode(root);
    }

    private int calNode(TreeNode root) {
        if (root == null) return 0;
        int cnt = 0;
        cnt += calNode(root.left) + calNode(root.right) + 1;
        return cnt;
    }


    public boolean isFlipedString(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 != l2) return false;
        String s3 = s2 + s2;
        return s3.contains(s1);
    }

    static Day19 day19 = new Day19();

    public static void main(String[] args) {
        System.out.println(day19.isFlipedString("waterbottle",
                "erbottlewat"));
    }

}
