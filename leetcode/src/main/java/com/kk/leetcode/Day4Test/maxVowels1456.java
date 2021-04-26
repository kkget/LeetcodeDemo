package com.kk.leetcode.Day4Test;

import java.util.HashSet;

/**
 * @author zhaokk
 * @create 2021-04-26 21:42
 */
public class maxVowels1456 {

            /*
            * 给你字符串 s 和整数 k 。

            请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。

            英文中的 元音字母 为（a, e, i, o, u）。

             

            示例 1：

            输入：s = "abciiidef", k = 3
            输出：3
            解释：子字符串 "iii" 包含 3 个元音字母。
            示例 2：

            输入：s = "aeiou", k = 2
            输出：2
            解释：任意长度为 2 的子字符串都包含 2 个元音字母。
            示例 3：

            输入：s = "leetcode", k = 3
            输出：2
            解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
            示例 4：

            输入：s = "rhythms", k = 4
            输出：0
            解释：字符串 s 中不含任何元音字母。
            示例 5：

            输入：s = "tryhard", k = 4
            输出：1

            * */

    public int maxVowels(String s, int k) {
        //4个为一组
        //伪代码  边界值判断
        //hashSet  加入元音字母
        //如果在集合内  count++
        //res= max(res,count)
        //处理滑动窗口值
        HashSet<Object> set = new HashSet<>();
            set.add("a");
            set.add("e");
            set.add("i");
            set.add("o");
            set.add("u");
            int res=0,count=0;
        for (int i = 0; i < k; i++) {
            char temp = s.charAt(i);
            if(set.contains(temp)){
                count++;
            }
        }
        res=Math.max(res, count);
        for (int i = k; i < s.length(); i++) {
            char out = s.charAt(i - k);
            char in = s.charAt(i);
            if (set.contains(out)) {
                count--;
            }
            if(set.contains(in)){
                count++;
            }
            res=Math.max(res, count);
        }
        return res;
    }

}
