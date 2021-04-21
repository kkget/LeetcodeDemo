package com.kk.leetcode.Day2Test;

import java.util.*;

/**
 * @author zhaokk
 * @create 2021-04-21 20:08
 */
public class HashMapdemo217 {

    /*
    * 给定一个整数数组，判断是否存在重复元素。
如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。

示例 1:

输入: [1,2,3,1]
输出: true
示例 2:

输入: [1,2,3,4]
输出: false
示例 3:

输入: [1,1,1,3,3,4,3,2,4,2]
输出: true
    * */
    public static boolean containsDuplicate(int[] nums) {
        //我肯定这么干
        /*
        * 提交时间	提交结果	运行时间	内存消耗	语言
            几秒前	  通过	        11 ms	45.6 MB	    Java
        * */
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Set<Integer> set = new HashSet<>(list);
        if(set.size()!=list.size()){
            return true;
        }else{
            return false;
        }
    }


    public static boolean containsDuplicate2(int[] nums) {

        /*
        * 提交时间	提交结果	运行时间	内存消耗	语言
            几秒前	通过	12 ms	44.8 MB	Java
        *
        * */
        HashMap<Object, Integer> map = new HashMap<>();
        for (int num : nums) {
           if(map.containsKey(num)){
               map.put(num,map.get(num)+1);
           }else{
               map.put(num,1);
           }
        }
        for (Object o : map.keySet()) {
            if(map.get(o)>1)
            {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        boolean b = containsDuplicate2(nums);
        System.out.println(b);
    }
}
