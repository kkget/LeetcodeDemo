package com.kk.leetcode.Day2Test;

import org.springframework.util.StringUtils;

import java.util.Stack;

/**
 * @author zhaokkstart
 * @create 2021-04-21 15:20
 */
public class Leecode20Question {

    /*
    * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
 

示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false
示例 4：

输入：s = "([)]"
输出：false
示例 5：

输入：s = "{[]}"
输出：true
 

提示：

1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
    * */

    public static void main(String[] args) {

        //思路
        //把所有左括号先入栈，如果遇到右括号则pop出来，
        //最后看栈的长度啊哈哈哈哈哈哈，多一个不匹配的是单身狗
        //伪代码
        //入参函数，字符串
        String s = "()[]{}";
        final Boolean valid = isValid(s);
        System.out.println(valid);
    }

    public static Boolean isValid(String s) {
        if (StringUtils.isEmpty(s)) {
            return true;
        }
        final Stack<Character> stack = new Stack();
        //遍历每一个字符
        //如果是左边的符号  入栈
        //else  如果栈为空  false  不为空pop()
        //if  右括号  判断pop出来的是不是左括号  是为true  否 false
        //其他类括号同理
        //最后判断栈的长度
        final char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if ('(' == aChar || '[' == aChar || '{' == aChar) {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char temp = stack.pop();
                    if (aChar == ')') {
                        if (temp != '(') {
                            return false;
                        }
                    } else if (aChar == ']') {
                        if (temp != ']') {
                            return false;
                        }
                    } else if (aChar == '}') {
                        if (temp != '}') {
                            return false;
                        }
                    }
                }

            }
        }
        return  stack.isEmpty()?true:false;
    }

    /*
    * 思路二
    * */
    public boolean isValid2(String s) {
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }

        return s.length() == 0;
    }
}
