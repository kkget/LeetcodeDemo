package com.kk.leetcode.Day4Test;

/**
 * @author zhaokk
 * @create 2021-04-26 20:07
 */
public class BinarySearch74 {

            /*
            *搜索二维矩阵
            *编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
            每行中的整数从左到右按升序排列。
            每行的第一个整数大于前一行的最后一个整数。
                提示：
            m == matrix.length
            n == matrix[i].length
            1 <= m, n <= 100
            -104 <= matrix[i][j], target <= 104。
            * */

            //解析  从左到右，升序排列
            //行
            //列
            //(x,y) =x * colunm +y
            // 11/2 =x  11%2 =y
            //伪代码
            //边界值判断
            //row = matrix.length
            //col =matrixp[0].length
            //初始化  left=0 right=row * col -1
            //找到element =matrix[m/col][m%col]
            //与目标值比较
            //大于 right=mid
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row =matrix.length,col =matrix[0].length;
        int left=0,right = row * col -1;
        int mid,element=0;
        while (left <= right) {
            mid=left+(right - left)/2;
            element =matrix[mid/col][mid%col];
            if(element == target){
                return true;
            }else if (element > target) {
                right=mid-1;
            }else {
                left = mid+1;
            }
        }
        return false;

    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        int row = 0, col = matrix[0].length-1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] < target)
                row++;
            else if(matrix[row][col] > target)
                col--;
            else
                return true;
        }
        return false;
    }
}
