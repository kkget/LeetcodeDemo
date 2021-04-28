package com.kk.leetcode.Day5Test;

import com.kk.leetcode.Day1Test.ListNode;

/**
 * @author zhaokkstart
 * @create 2021-04-28 15:44
 */
public class Recurtion206 {

            /*
            * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 

            示例 1：


            输入：head = [1,2,3,4,5]
            输出：[5,4,3,2,1]
            示例 2：


            输入：head = [1,2]
            输出：[2,1]
            示例 3：

            输入：head = []
            输出：[]
 
            *
            * */
            /*
            * L =L.next.next;
            * L.next=null;
            *
            *
            * */

    public ListNode reverseList1(ListNode head) {
        /*
        * 临界点判断
        * */
        ListNode listNode = reverseList1(head.next);
        listNode.next.next=head;
        head.next.next = null;
        return listNode;
    }


    public ListNode reverseList(ListNode head) {
        ListNode listNode = new ListNode();
        listNode.next=head;
        while (head!=null&&head.next != null) {
             ListNode next = head.next;
            ListNode temp = listNode.next;
            listNode.next = next;
            next.next = temp;
        }
        return listNode.next;
    }

}
