package com.kk.leetcode.Day2Test;

import java.util.*;

/**
 * @author zhaokkstart
 * @create 2021-04-21 16:00
 */
public class nextMaxDuce {

        /*
        * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。

请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。

nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。

 

示例 1:

输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
输出: [-1,3,-1]
解释:
    对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
    对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
    对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
示例 2:

输入: nums1 = [2,4], nums2 = [1,2,3,4].
输出: [3,-1]
解释:
    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 

提示：

1 <= nums1.length <= nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 104
nums1和nums2中所有整数 互不相同
nums1 中的所有整数同样出现在 nums2 中
 

进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？

        * */

    public static void main(String[] args) {
        //思路
        //先把num2的值放入栈中
        //遍历num1的值
        //定义临时栈  发现标识boolean isFound max=-1表示没找到
        //遍历stack 并且没找到时
        //拿出一个值  top
        //如果拿出来的值>num max=num
        //如果等与 标识已找到
        // 并放入临时栈
        //遍历临时栈放回原栈，以便下次遍历
        //时间复杂度O(M * N)
        nextMaxDuce();
    }

    public static int[] nextMaxDuce() {
        int[] arr1 = {4, 1, 2};
        int[] arr2 = {1, 3, 4, 2};
        int[] res = new int[arr1.length];
        Stack<Integer> stack = new Stack<>();
        for (int i : arr2) {
            stack.push(i);
        }

        for (int i = 0; i < arr1.length; i++) {
            Stack<Integer> temp = new Stack<>();
            boolean isFound = false;
            int cur = arr1[i];
            int max = -1;
            while (!stack.isEmpty() && !isFound) {
                int top = stack.pop();
                if (top > cur) {
                    max = top;
                } else if (top == cur) {
                    isFound = true;
                }
                temp.push(top);
            }
            res[i] = max;
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }
        return res;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 先处理 nums2，把对应关系存入哈希表
        for (int i = 0; i < len2; i++) {
            while (!stack.isEmpty() && stack.peekLast() < nums2[i]) {
                map.put(stack.removeLast(), nums2[i]);
            }
            stack.addLast(nums2[i]);
        }

        // 遍历 nums1 得到结果集
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
        /*
        * 复杂度分析：
        时间复杂度：O(N + M)O(N+M)，分别遍历数组 nums1 和数组 nums2 各一次即可，对于 nums2 中的每个元素，进栈一次，出栈一次；
        空间复杂度：O(N)O(N)。我们在遍历 nums2 时，需要使用栈，以及哈希映射用来临时存储答案
    。
        * */
}
