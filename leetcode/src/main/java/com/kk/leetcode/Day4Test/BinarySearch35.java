package com.kk.leetcode.Day4Test;

/**
 * @author zhaokkstart
 * @create 2021-04-26 11:17
 */
public class BinarySearch35 {

    /*
    * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1
示例 3:

输入: [1,3,5,6], 7
输出: 4
示例 4:

输入: [1,3,5,6], 0
输出: 0
    * */
    public int searchInsert(int[] nums, int target) {
        //伪代码
        //边界值判断
        //left   right
        //如果m==target  return m
        //如果m>target  将r移动到m位置上
        //小于的话  left移动到m+1
        //if nums[left] > target return left
        //else return left +1
        if (nums == null || nums.length == 0) return 0;
        int left=0,ritht=nums.length-1;
        while (left<ritht) {
            int  mid=left+(ritht-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                ritht=mid;
            }else{
                left=mid+1;
            }
        }
        return  nums[left] <target?left+1:left;
    }

}
