package com.kk.leetcode.Day4Test;

/**
 * @author zhaokk
 * @create 2021-04-26 20:33
 */
public class minSubArrayLen209 {

    /*
    * 给定一个含有 n 个正整数的数组和一个正整数 target 。

        找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
        * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
        示例 1：

        输入：target = 7, nums = [2,3,1,2,4,3]
        输出：2
        解释：子数组 [4,3] 是该条件下的长度最小的子数组。
        示例 2：

        输入：target = 4, nums = [1,4,4]
        输出：1
        示例 3：

        输入：target = 11, nums = [1,1,1,1,1,1,1,1]
        输出：0
         

        提示：

        1 <= target <= 109
        1 <= nums.length <= 105
        1 <= nums[i] <= 105
。
    * */
    //解析  滑动窗口 Sliding  Window
          /*1+2+3=6
            6-1+6=11    = 2+3+6  6-移除的数+加入的数
            11-2+4=13  =3+6+4
            13-3+5=15  =6+4+5
            数组定长
            *
            * */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = 0, result = nums.length + 1, total = 0;
        while (j < nums.length) {
            total += nums[j];
            j++;
            while (total >= s) {
                result = Math.min(result, j - i);
                total -= nums[i];
                i++;
            }

        }
        return result == nums.length + 1 ? 0 : result;
    }

}
