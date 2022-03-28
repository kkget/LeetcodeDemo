package com.kk.leetcode.Day6Test;

import com.kk.leetcode.Day1Test.ListNode;

/**
 * @author zkkstart
 * @create 2022-03-27 21:25
 */
public class LeetCode24 {
    /*
    * 24. 两两交换链表中的节点
给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。



示例 1：


输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]


提示：

链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100
    * */

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode();
        res.next = head;
        ListNode cur = res;
        while (cur.next != null && cur.next.next != null) {
            ListNode next = head.next;
            ListNode temp = next.next;
            cur.next = next;
            next.next = head;
            head.next = temp;
            cur = head;
            head = head.next;
        }
        return res.next;
    }
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs2(head.next.next);
        next.next = head;
        return next;
    }
}
