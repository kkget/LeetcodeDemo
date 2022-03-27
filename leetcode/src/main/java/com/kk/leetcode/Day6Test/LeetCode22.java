package com.kk.leetcode.Day6Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zkkstart
 * @create 2022-03-27 20:38
 */
public class LeetCode22 {
    /*
    * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例 1：

输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：

输入：n = 1
输出：["()"]


提示：

1 <= n <= 8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */
    //回溯法

}
class Solution {
    // Leetcode 22. Generate Parentheses
    // Backtracking
    // Time Complexity: Hard To Say
    // Space Complexity: Hard To Say
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(n, result, 0, 0, "");
        return result;
    }

    private void backtracking(int n, List<String> result, int left, int right, String str) {
        if (right > left) {
            return;
        }
        if (left == n && right == n) {
            result.add(str);
            return;
        }

        if (left < n) {
            backtracking(n, result, left+1, right, str+"(");
        }

        if (right < left) {
            backtracking(n, result, left, right+1, str+")");
        }
    }
}
