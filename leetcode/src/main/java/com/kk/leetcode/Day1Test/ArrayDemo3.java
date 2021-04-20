package com.kk.leetcode.Day1Test;

/**
 * @author zhaokk
 * @create 2021-04-20 20:37
 */
public class ArrayDemo3 {

    public static void main(String[] args) {

            /*  27
            * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
    不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
    元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
    *
    * 示例 1：

输入：nums = [3,2,2,3], val = 3
输出：2, nums = [2,2]
解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
示例 2：

输入：nums = [0,1,2,2,3,0,4,2], val = 2
输出：5, nums = [0,1,4,0,3]
解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。

            * */



       int[] nums = {0,1,2,2,3,0,4,2};
       int val = 2;

        //System.out.println(searchAll(nums,val));
       // int a=searchAll2(nums,val);
        System.out.println("长度为"+ removeElement(nums,val));
    }

    private static int searchAll2(int[] nums, int val) {
        //
        if (nums == null || nums.length == 0) return 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int num : nums) {
            System.out.println(num);
        }
        return j;

    }

    private static int searchAll(int[] nums, int val) {
        //双指针  放在头尾
        if(nums==null||nums.length==0){
                return 0;
        }
        int left=0;
        int right=nums.length-1;
        while (left<right){
            while (left<right && nums[left]!=val){
                left=left+1;
            }
            while (left<right && nums[right]==val){
                right=right-1;
            }
            int  temp=nums[left];
            nums[left]=nums[right];

            nums[right]=temp;
        }
        return  nums[left]==val?left:left+1;

    }


    public static  int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[index++] = nums[i];
            }
        }

        for (int num : nums) {
            System.out.println(num);
        }
        return index;
    }
}
