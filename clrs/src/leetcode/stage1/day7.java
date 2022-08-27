package leetcode.stage1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode
 * @createTime : 2022/8/16 10:43
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class day7 {

    class MyCircularDeque {
        int[] elem;
        int front;
        int rear;
        int capacity;

        public MyCircularDeque(int k) {
            capacity = k + 1;
            rear = 0;
            front = 0;
            elem = new int[capacity];
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            front = (front - 1 + capacity) % capacity;
            elem[front] = value;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            elem[rear] = value;
            rear = (rear + 1) % capacity;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % capacity;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            rear = (rear - 1 + capacity) % capacity;
            return true;
        }

        public int getFront() {
            return isEmpty() ? -1 : elem[front];
        }

        public int getRear() {
            return isEmpty() ? -1 : elem[(rear - 1 + capacity) % capacity];
        }

        public boolean isEmpty() {
            return rear == front;
        }

        public boolean isFull() {
            return (rear + 1) % capacity == front;
        }
    }

    class OrderedStream {
        String[] elem;
        int ptr;

        public OrderedStream(int n) {
            ptr = 1;
            elem = new String[n + 1];
        }

        public List<String> insert(int idKey, String value) {
            elem[idKey] = value;
            List<String> list = new ArrayList<>();
            if (elem[ptr] != null) {
                while (ptr < elem.length && elem[ptr] != null) {
                    list.add(elem[ptr]);
                    ptr++;
                }
            }
            return list;
        }
    }



}
