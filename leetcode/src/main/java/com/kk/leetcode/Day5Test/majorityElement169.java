package com.kk.leetcode.Day5Test;

import java.util.Arrays;

/**
 * @author zhaokkstart
 * @create 2021-04-28 16:06
 */
public class majorityElement169 {



    /*
    *
    * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

        你可以假设数组是非空的，并且给定的数组总是存在多数元素。

         

        示例 1：

        输入：[3,2,3]
        输出：3
        示例 2：

        输入：[2,2,1,1,1,2,2]
        输出：2
 
    * */
    public int majorityElement(int[] nums) {
    /*
    * 一分为2    大数组分为小数组
    * 数组的大小，起始位置，终止位置
    * 终止条件  只有一个数时终止
    *
    * */
    /*摩尔投票法思路
    * 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
    当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
    当票数count为0时，更换候选人，并将票数count重置为1。
    遍历完数组后，cand_num即为最终答案。
    为何这行得通呢？
    投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
    且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
    因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
    这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。

    无论数组是1 2 1 2 1，亦或是1 2 2 1 1，总能得到正确的候选人
    * */
            int cand_num = nums[0], count = 1;
            for (int i = 1; i < nums.length; ++i) {
                if (cand_num == nums[i])
                    ++count;
                else if (--count == 0) {
                    cand_num = nums[i];
                    count = 1;
                }
            }
            return cand_num;



    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
