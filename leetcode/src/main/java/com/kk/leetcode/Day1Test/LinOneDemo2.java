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
    /**
     * 迭代方法
     * 1 -> 2 -> 3 -> 4 -> null
     * null <- 1 <- 2 <- 3 <- 4
     *
     * @param head
     * @return
     */
    public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null; //前指针节点
        ListNode curr = head; //当前指针节点
        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while (curr != null) {
            ListNode nextTemp = curr.next; //临时节点，暂存当前节点的下一节点，用于后移
            curr.next = prev; //将当前节点指向它前面的节点
            prev = curr; //前指针后移
            curr = nextTemp; //当前指针后移
        }
        return prev;
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



