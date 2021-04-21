package com.kk.leetcode.Day2Test;

/**
 * @author zhaokk
 * @create 2021-04-21 20:36
 */
public class HashMapDemo389 {

    /*
    * 给定两个字符串 s 和 t，它们只包含小写字母。

字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

请找出在 t 中被添加的字母。

 

示例 1：

输入：s = "abcd", t = "abcde"
输出："e"
解释：'e' 是那个被添加的字母。
示例 2：

输入：s = "", t = "y"
输出："y"
示例 3：

输入：s = "a", t = "aa"
输出："a"
示例 4：

输入：s = "ae", t = "aea"
输出："a"
 

提示：

0 <= s.length <= 1000
t.length == s.length + 1

    * */
    public char findTheDifference1(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

    public static char findTheDifference(String s, String t) {
        //转ASII码表是不是问题复杂化了
        //直接还是list去重不就得了
        return '1';

    }

    public static void main(String[] args) {

    }
}
