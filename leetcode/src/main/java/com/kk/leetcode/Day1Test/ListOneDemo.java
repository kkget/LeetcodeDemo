package com.kk.leetcode.Day1Test;

import lombok.val;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author zhaokk
 * @create 2021-04-20 21:13
 */
public class ListOneDemo {
    public static void main(String[] args) {
        LinkedList<Object> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(6);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.removeIf(vo -> vo.equals(6));
        list.forEach(vo -> {
            System.out.println(vo);
        });

    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            if (head.val == val) {
                prev.next = dummy.next;
            } else {
                prev = head;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }


}
