package com.kk.leetcode.Day6Test;

import com.kk.leetcode.Day1Test.ListNode;

/**
 * @author zkkstart
 * @create 2022-03-27 20:05
 */
public class LeetCode21 {

    /*
    *
    * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

 

示例 1：


输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
示例 2：

输入：l1 = [], l2 = []
输出：[]
示例 3：

输入：l1 = [], l2 = [0]
输出：[0]
 

提示：

两个链表的节点数目范围是 [0, 50]
-100 <= Node.val <= 100
l1 和 l2 均按 非递减顺序 排列
    * */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode res = new ListNode();
        ListNode cur = res;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                cur.next = list1;
                list2 = list2.next;
            } else {
                cur.next = list2;
                list2 = list2.next;

            }
            cur = cur.next;
        }
        if (list1 == null) {

            cur.next = list2;

        }
        if (list2 == null) {

            cur.next = list1;

        }
        return res.next;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;

        }
    }
}
