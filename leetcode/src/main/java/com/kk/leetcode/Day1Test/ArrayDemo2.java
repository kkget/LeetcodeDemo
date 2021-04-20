package com.kk.leetcode.Day1Test;

/**
 * @author zhaokk
 * @create 2021-04-20 20:25
 */
public class ArrayDemo2 {

    public static void main(String[] args) {
        //283给定一个nums数组，编写一个函数将所有的0移动到数组的末尾，同时保持非0元素的相对于顺序
        //[0,1,0,3,12]     得到[1,3,12,0,0]
        int[] arr={0,1,0,3,12};
        int index =0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                arr[index]=arr[i];
                index=index+1;
            }

        }
        for (int i = index; i < arr.length; i++) {
            arr[i]=0;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
