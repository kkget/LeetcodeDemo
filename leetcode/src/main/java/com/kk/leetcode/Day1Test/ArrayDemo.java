package com.kk.leetcode.Day1Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author zhaokk
 * @create 2021-04-20 19:56
 */
public class ArrayDemo {


    public static void main(String[] args) {
        //创建数组
        int[] a={1,2,3,4};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 110; i++) {
            //O(1)
            list.add(i+1);
        }
        //O(N)
        list.add(3,88);
        //访问 一定是通过下标的
        list.get(1);
        //更新 O(1)
        list.set(1,22);
        //删除元素
        list.remove(1);
        //O(1)
        list.size();
        //排序
        Collections.sort(list,Collections.reverseOrder());

        list.clear();
        //最大连续1的个数  485
        String str="1,2,1,1,1,1,1,2,3,4,3,1,2,1,1,1,1,1,1";
        String[] split = str.split(",");
        for (String s : split) {
           list.add(Integer.parseInt(s));
        }

        int count=0;
        int result=0;
        //判空返回
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(1)){
                count=count+1;
            }else{
               result=max(result,count);
               count=0;
            }
        }
        System.out.println(max(result,count));
    }

    private static int max(int result, int count) {

        if(result>count){
            return result;
        }else{
            return count;
        }
    }


}
