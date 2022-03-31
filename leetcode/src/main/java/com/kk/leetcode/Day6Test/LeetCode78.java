package com.kk.leetcode.Day6Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaozhenkun
 * @create 2022-03-31 11:05
 */
public class LeetCode78 {
    /*
    *
    * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

    解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

     

    示例 1：

    输入：nums = [1,2,3]
    输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    示例 2：

    输入：nums = [0]
    输出：[[],[0]]
     

    提示：

    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
    nums 中的所有元素 互不相同

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/subsets
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<>());
        //子集中必然包含一个空数组
        for (int num : nums) {

            List<List<Integer>> sub = new ArrayList<List<Integer>>();
            for (List<Integer> integers : result) {
                List<Integer> temp = new ArrayList<>(integers);
                temp.add(num);
                sub.add(temp);
            }
            for (List<Integer> integers : sub) {
                result.add(integers);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {
            2,6,9,8,7
        };
        System.out.println(subsets(nums));
    }
}
