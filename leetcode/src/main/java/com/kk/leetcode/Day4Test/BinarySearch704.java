package com.kk.leetcode.Day4Test;

import java.util.Arrays;

/**
 * @author zhaokkstart
 * @create 2021-04-26 9:54
 */
public class BinarySearch704 {
            /*
            * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。


示例 1:

输入: nums = [-1,0,3,5,9,12], target = 9
输出: 4
解释: 9 出现在 nums 中并且下标为 4
示例 2:

输入: nums = [-1,0,3,5,9,12], target = 2
输出: -1
解释: 2 不存在 nums 中因此返回 -1
 

提示：

你可以假设 nums 中的所有元素是不重复的。
n 将在 [1, 10000]之间。
nums 的每个元素都将在 [-9999, 9999]之间
            * */
    //

    public int search(int[] nums, int target) {
        //伪代码
        //左边  右边指针
        //if(左边小于右边的指针)  return left+(r-l)/2
        //if(mind == target) return
        //if(mind > target)  return mind-1
        //mind =1
        //都没有  没dei~ -1

        if (nums == null || nums.length == 0) return -1;
       /* for (int i = 0; i < nums.length; i++) {
           if(nums[i] == target){
               return i;
           }

        }*/
       //保险起见
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return mid - 1;
            } else {
                return mid + 1;
            }
        }

        return -1;
    }
}
