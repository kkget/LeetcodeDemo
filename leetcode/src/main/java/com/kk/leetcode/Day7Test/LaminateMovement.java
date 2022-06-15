package com.kk.leetcode.Day7Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhaozhenkun
 * @create 2022-06-14 14:13
 */
public class LaminateMovement {
    /*
    *
    * 描述： 给定一个高度为 2000mm 的柜子空间，以及 n 个层板距离柜子底部高度，满足移动层板位置 使得层板等分衣柜的空间。
    * 计算所有移动层板的顺序。 层板号自下向上依次排列，1，2..n。层板需要考虑空间位置，不能跨层板移动。
    * 示例 1
    * 输入：n = 3，zs = 50，60，1000
    * 输出： 3 2 1
    * 示例 2
    * 输入：n = 4，zs = 50，600，700，1000
    * 输出：
    * 1，4，3，2
    * 4，1，3，2
    * 4，3，1，2
    * 4，3，2，1
    * 提示 1：1 <= n <= 10 提示 2：输出结果需要按小到大排序
    * */
    //思路确认目标值:target = 2000/ (n+1)

    //入参  total,n,list<>,resultList
    //返回的是下标

    public static List<Integer> calcMovement(Integer total,Integer n,List<Integer> list,List<Integer> reslout,List<Integer> resultList){

        //木板只能从第一层或者第n层开始移动
        //示例 1
        //如果从第一层开始
        //50 < 目标值 500 看第二层 60 < 500 故如果连续不满足的条件比如50,60,因为不能跨层所以不能这样移动,遍历跳出
        //从第三层(最顶层)开始
        //1000(最顶层) <  目标值的最大值1500  则1000向上移动
        //60(最顶层-1) <  (目标值的最大值-1) 1000  则60向上移动
        //50(最顶层-2) <  (目标值的最大值-2) 500  则50向上移动


        //示例 2
        //目标值为400,800,1200,1600   木板为 50，600，700，1000
        //如果从第一层开始
        //50(最底层 0 ) < 目标值.get(0) 400 向上移动
        // 600(最底层 0+1 ) < 目标值.get(0+1) 800 向上移动
        // 700(最底层 0+2 ) < 目标值.get(0+2) 1200 向上移动
        // 1000(最底层 0+3 ) < 目标值.get(0+3) 1600 向上移动
        //连续移动的时候出现了600<800  700<800 连续小于目标值就会出现跨层



        //从第四层(最顶层)开始
        //1000(最顶层) <  目标值的最大值1600  则1000向上移动
        //700(最顶层-1) <  (目标值的最大值-1) 1200  则700向上移动
        //600(最顶层-2) <  (目标值的最大值-2) 800  则600向上移动
        //50(最顶层-3) <  (目标值的最大值-3) 400  则50向上移动

        //也就是说最顶层开始时只需要考虑下面三层的移动情况


        // {
            //也可以尝试一下当n= 4开始时剩下的3,2,1的全排列

             //当n = 1开始时剩下的3,4的全排列
        // }

        // {
            //也可以尝试一下当n= 3开始时剩下的2,1的全排列
            //当n = 1开始时剩下的2,3,4的全排列
        // }
        //不满足条件?的去掉排列


        List<Integer> temp = new ArrayList<>();

        Integer target = total / (n+1);

        for (int i = 0; i < n; i++) {
            //每个模板应该在的位置
            temp.add(target * (i+1));
        }


        List<Integer> list1 = new ArrayList<>();


        for (int i = 0; i <= n; i++) {
           if( i > 1 ){
               list1.add(i);
           }
        }


        List<List<Integer>> permute1 = permute(list1);




        for (List<Integer> integers : permute1) {
            integers.add(1);
            resultList.add(1);
            Collections.swap(integers, 1, 0);
            for (int i = 0; i < integers.size(); i++) {
                if(i + 1 < integers.size()){
                    if(list.get(i) < temp.get(i) && list.get(i+1) < temp.get(i+1)){
                        continue;
                    }else{
                        resultList.add(i+1);
                    }
                    //顶端
                }else if (i + 1 == integers.size()){
                    if(list.get(i-1) > temp.get(n-1) && list.get(i) > temp.get(n)){
                        continue;
                    }else{
                        resultList.add(i+1);
                    }
                }
            }
        }
        //当第一个位置为1时,第二个位置为




        List<Integer> listN = new ArrayList<>();


        for (int i = 1; i < n; i++) {
            if( i < n ){
                listN.add(i);
            }
        }

        List<List<Integer>> permuteN = permute(listN);

        for (List<Integer> integers : permuteN) {
            integers.add(n);
            Collections.swap(integers, n, 0);
            for (int i = 0; i < integers.size(); i++) {
                if(i + 1 < integers.size()){
                    if(list.get(i) < temp.get(i) && list.get(i+1) < temp.get(i+1)){
                        continue;
                    }else{
                        resultList.add(i+1);
                    }
                    //顶端
                }else if (i + 1 == integers.size()){
                    if(list.get(i-1) > temp.get(n-1) && list.get(i) > temp.get(n)){
                        continue;
                    }else{
                        resultList.add(i+1);
                    }
                }
            }
        }
        return resultList;
    }






    public  static  List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.size();
        backtrack(n, output, res, 0);
        return res;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

















    public static List<Integer> calcLaminateMovement(Integer total,Integer n,List<Integer> list,List<Integer> reslout,List<Integer> resultList){

        List<Integer> temp = new ArrayList<>();

        Integer target = total / (n+1);

        for (int i = 0; i < n; i++) {
            //每个模板应该在的位置
           temp.add(target * (i+1));
        }
        for (int i = 0; i < n; i++) {
            //大于目标值可以移动
            if(list.get(i) > temp.get(i)){
                if( i == 0){
                    if(!temp.contains(list.get(i))){
                        reslout.add(i);
                    }
                }else{
                    //50 < 1000
                    if(list.get(i-1) < temp.get(i)){
                        if(!temp.contains(list.get(i))) {
                            reslout.add(i);
                        }
                    }

                }
            }else if(list.get(i) < temp.get(i)){
                if(i==(n-1)){
                    if(!temp.contains(list.get(i))) {
                        reslout.add(i);
                    }
                }else{
                    if(!temp.contains(list.get(i))) {
                        if(list.get(i+1) > temp.get(i)){
                            resultList.add(i);
                        }
                    }
                }
            }
        }
        return resultList;
    }




    public static boolean isMove(Integer total,List<Integer> list,Integer size){
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if(list.get(i) == total){
                return true;
            }
        }
        return flag;
    }


    public static Integer isNext(List<Integer> list){
       Integer a = 0;

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) != -1){
               a++;
            }
        }
        return a;
    }

    public static Integer isMoveNext(Integer n,List<Integer> list,List<Integer> tempList,List<Integer> resultList){
        Integer k = tempList.get(n);

        k = tempList.get(n) - 1;
        resultList.add(tempList.get(n));
        for (int i = 0; i < list.size(); i++) {
            if(i == k ){
                //list.get(k) = tempList.get(k);
            }
        }
        //tempList.get(n) = -1;
        //calcLaminateMovement();
        return k;
    }

    public static Integer calcResult(List<Integer> list,List<Integer> tempList,List<Integer> resultList){
        boolean help1 = false;
        Integer flag1= 0;

        boolean help2 = false;

        Integer flag2= 0;
        for (int i = 0; i < tempList.size(); i++) {
            if( tempList.get(i)!=-1){

               Integer k = tempList.get(i) - 1;

                resultList.add(tempList.get(i));
                //tempList.get(i) = -1;
                //calcLaminateMovement();
                if(isNext(tempList) > 1){
                    help1 = true;
                    flag1 = i;
                }
                for (int j = 0; j < tempList.size(); j++) {
                    if(help1){
                        if (tempList.get(flag1) != -1) isMoveNext(flag1,list,tempList,resultList);
                    }
                    if (tempList.get(flag1) != -1){
                        isMoveNext(flag1,list,tempList,resultList);
                        if(isNext(tempList) > 1){
                            help2 = true;
                            flag2 = i;
                        }
                    }
                    for (int s = 0; s < tempList.size(); s++) {


                    }
                }

            }

        }
        return 0;
    }


    public static void main(String[] args) {
        //Integer total,Integer n,List<Integer> list,List<Integer> reslout,List<Integer> resultList
        List<Integer> list = new ArrayList<>();
        list.add(50);
        list.add(60);
        list.add(1000);
        List<Integer> integers = calcMovement(2000, 3, list, new ArrayList<>(), new ArrayList<>());


    }

}
