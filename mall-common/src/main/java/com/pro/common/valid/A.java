package com.pro.common.valid;

import lombok.Data;
import lombok.val;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author chenyao
 * date 2021-03-03
 */
@Data
class Node{
    private String key;
    private String value;
    public   Node next;
}
public class A {
    private static int count = 20;

    public static void main(String[] args) {

        Node node = new Node();
        node.setValue("1");
        Node node1 = new Node();
        node1.setValue("2");
        Node node2 = new Node();
        node2.setValue("3");
        node.next = node1;
        node1.next = node2;
        Node node3 = new Solution().reverseList(node);
        System.out.println(node);
    }

}

class Solution {
    public Node reverseList(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
