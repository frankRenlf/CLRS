package leetcode.stage2;

import leetcode.algorithm.TreeNode;
import leetcode.algorithm.Node;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage2
 * @createTime : 2022/8/30 13:25
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day7 {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null || root.val < val) {
            return new TreeNode(val, root, null);
        }
        TreeNode par = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > val) {
                par = cur;
                cur = cur.right;
            } else {
                par.right = new TreeNode(val, cur, null);
                return root;
            }
        }
        par.right = new TreeNode(val);
        return root;
    }

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                Node cur = queue.poll();
                size--;
                if (size != 0) {
                    cur.next = queue.peek();
                } else {
                    cur.next = null;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }

    public Node connect_refined(Node root) {
        if (root == null)
            return root;
        //cur我们可以把它看做是每一层的链表
        Node cur = root;
        while (cur != null) {
            //遍历当前层的时候，为了方便操作在下一
            //层前面添加一个哑结点（注意这里是访问
            //当前层的节点，然后把下一层的节点串起来）
            Node dummy = new Node(0);
            //pre表示访下一层节点的前一个节点
            Node pre = dummy;
            //然后开始遍历当前层的链表
            while (cur != null) {
                if (cur.left != null) {
                    //如果当前节点的左子节点不为空，就让pre节点
                    //的next指向他，也就是把它串起来
                    pre.next = cur.left;
                    //然后再更新pre
                    pre = pre.next;
                }
                //同理参照左子树
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                //继续访问这一行的下一个节点
                cur = cur.next;
            }
            //把下一层串联成一个链表之后，让他赋值给cur，
            //后续继续循环，直到cur为空为止
            cur = dummy.next;
        }
        return root;
    }


    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }

    static class Node2 {
        int x;
        int y;
        int step;

        public Node2(int start, int end, int step) {
            this.x = start;
            this.y = end;
            this.step = step;
        }
    }

    int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public int shortestPathBinaryMatrix(int[][] grid) {

        Node2 node = new Node2(0, 0, 2);
        Queue<Node2> queue = new LinkedList<>();
        queue.offer(node);

        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        } else if (n <= 2) {
            return n;
        }
        while (!queue.isEmpty()) {
            Node2 cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int step = cur.step;
            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (0 <= newX && newX < n && 0 <= newY && newY < n && grid[newX][newY] == 0) {
                    //找到终点
                    if (newX == n - 1 && newY == n - 1) {
                        return step;
                    }
                    queue.offer(new Node2(newX, newY, step + 1));
                    grid[newX][newY] = 1; //标记已遍历过，避免重复
                }
            }
        }
        return -1;
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            solve_dfs(board, i, 0, row, col);
            solve_dfs(board, i, col - 1, row, col);
        }
        for (int i = 1; i < col - 1; i++) {
            solve_dfs(board, 0, i, row, col);
            solve_dfs(board, row - 1, i, row, col);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'F') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void solve_dfs(char[][] board, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'F';
        solve_dfs(board, i - 1, j, row, col);
        solve_dfs(board, i, j + 1, row, col);
        solve_dfs(board, i + 1, j, row, col);
        solve_dfs(board, i, j - 1, row, col);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ret = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        if (graph == null || graph.length == 0 || graph[0].length == 0) return ret;
        int end = graph.length-1;
        stack.push(0);
        findPath_dfs(ret, stack, graph, 0, end);
        return ret;
    }

    private void findPath_dfs(List<List<Integer>> ret, Stack<Integer> stack, int[][] graph, int i, int end) {
        if (i == end) {
            ret.add(new ArrayList<>(stack));
        }
        for (int j = 0; j < graph[i].length; j++) {
            stack.push(graph[i][j]);
            findPath_dfs(ret, stack, graph, graph[i][j], end);
            stack.pop();
        }
    }

}
