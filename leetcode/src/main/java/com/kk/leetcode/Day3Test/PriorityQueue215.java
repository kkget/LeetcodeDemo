package com.kk.leetcode.Day3Test;


import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author zhaokkstart
 * @create 2021-04-25 10:27
 */
public class PriorityQueue215 {
    /*
    * 215. 数组中的第K个最大元素
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
    * */
    PriorityQueue<Integer>  minheap=new  PriorityQueue<>();

    PriorityQueue<Integer>  maxheap=new  PriorityQueue<>(Collections.reverseOrder());

    //peek

    //poll
    //最大堆！！！

    public static void main(String[] args) {



    }

    public int findKthLargest(int[] nums, int k) {
        for (int num : nums) {
            maxheap.add(num);
        }

        while (k<1){

            maxheap.poll();
            k=k-1;
        }
        return minheap.poll();
    }


}
