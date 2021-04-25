package com.kk.leetcode.Day3Test;

/**
 * @author zhaokkstart
 * @create 2021-04-25 9:38
 */
public class HashSet705 {
            /*
            * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。

实现 MyHashSet 类：

void add(key) 向哈希集合中插入值 key 。
bool contains(key) 返回哈希集合中是否存在这个值 key 。
void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 
示例：

输入：
["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
输出：
[null, null, null, true, false, null, true, null, false]

解释：
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // 返回 True
myHashSet.contains(3); // 返回 False ，（未找到）
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // 返回 True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // 返回 False ，（已移除）
 

提示：

0 <= key <= 106
最多调用 104 次 add、remove 和 contains 。
 
            * */

    /** Initialize your data structure here. */

    //伪代码
    //利用数组的特性  把每个数组存在的元素置为true  不存在false

    boolean[] hashSet=null;
    public HashSet705() {
        hashSet=new boolean[1000001];
    }

    public void add(int key) {
        hashSet[key] =true;
    }

    public void remove(int key) {
        hashSet[key] =false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return   hashSet[key];
    }

    public static void main(String[] args) {



    }
}
