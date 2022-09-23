package leetcode.stage3;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/23 11:02
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */

class MyLinkedList {

    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }
    }

    Node root;
    Node last;

    public MyLinkedList() {
        root = new Node(0);
        last = root;
    }

    public int get(int index) {
        Node cur = root.next;
        int i = 0;
        for (; i < index && cur != null; i++) {
            cur = cur.next;
        }
        return i == index && cur != null ? cur.val : -1;
    }

    public void addAtHead(int val) {
        Node next = root.next;
        root.next = new Node(val);
        root.next.next = next;
        if (last == root) last = root.next;
    }

    public void addAtTail(int val) {
        last.next = new Node(val);
        last = last.next;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
        }
        Node pre = root;
        int i = 0;
        for (; i < index && pre.next != null; i++) {
            pre = pre.next;
        }
        if (i < index) return;
        Node next = pre.next;
        pre.next = new Node(val);
        pre.next.next = next;
        if (next == null) last = pre.next;
    }

    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        }
        Node pre = root;
        int i = 0;
        for (; i < index && pre.next != null; i++) {
            pre = pre.next;
        }
        if (i < index || pre.next == null) return;
        Node next = pre.next.next;
        pre.next = next;
        if (next == null) last = pre;
    }
}

public class Day14 {


}
