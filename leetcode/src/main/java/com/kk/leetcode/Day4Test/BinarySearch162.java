package com.kk.leetcode.Day4Test;

/**
 * @author zhaokk
 * @create 2021-04-26 19:52
 */
public class BinarySearch162 {

                /*
                * 峰值元素是指其值大于左右相邻值的元素。

给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞ 。

 

示例 1：

输入：nums = [1,2,3,1]
输出：2
解释：3 是峰值元素，你的函数应该返回其索引 2。
示例 2：

输入：nums = [1,2,1,3,5,6,4]
输出：1 或 5
解释：你的函数可以返回索引 1，其峰值元素为 2；
     或者返回索引 5， 其峰值元素为 6。
 

提示：

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
对于所有有效的 i 都有 nums[i] != nums[i + 1]
 
                * */

    public int findPeakElement(int[] nums) {
            //伪代码
            //如果nums[mid]>nums[mid+1]  right移动到m的位置
            //else left=m+1

        if (nums == null || nums.length == 0) return 0;
        int left=0,ritht=nums.length-1;
        while (left<ritht) {
            int  mid=left+(ritht-left)/2;
            if(nums[mid]>nums[mid+1]){
                ritht=mid;
            }else{
                left=mid+1;
            }
        }
        return  left;
    }
}
