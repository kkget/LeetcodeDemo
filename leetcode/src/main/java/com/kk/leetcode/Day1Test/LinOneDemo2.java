package com.kk.leetcode.Day1Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhaokk
 * @create 2021-04-20 21:54
 */
public class LinOneDemo2 {

    /*
    * 反转一个单链表。

    示例:

    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
    *
    * */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Collections.reverse(list);
        list.forEach(vo->{
            System.out.println(vo);
        });
    }
}



