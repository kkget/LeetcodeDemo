package com.kk.leetcode.Day3Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhaokkstart
 * @create 2021-04-25 10:57
 */
public class HeapTest692 {
    /*
    * 给一非空的单词列表，返回前 k 个出现次数最多的单词。

返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。

示例 1：

输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
输出: ["i", "love"]
解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    注意，按字母顺序 "i" 在 "love" 之前。
 

示例 2：

输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
输出: ["the", "is", "sunny", "day"]
解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
    出现次数依次为 4, 3, 2 和 1 次。
 

注意：

假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
输入的单词均由小写字母组成。
//字幕小的可以自定义comprator比较字母的ASII码表
    *
    * */

    public List<String> topKFrequent(String[] words, int k) {
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.getValue().equals(o2.getValue())) {
                        return o1.getKey().compareTo(o2.getKey());
                    } else {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                })
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
    }

    //伪代码
    //遍历每一个单词
    //初始化hashMap
    //如果不在map则加入
    //堆中比较
    //反转集合
    public List<String> topKFrequent2(String[] words,int k){

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {

            if(!map.containsKey(word)){
                map.put(word,0);
            }
            int count=map.get(word)+1;
            map.put(word,count);
        }
        PriorityQueue<String> minheap=new  PriorityQueue<>((w1, w2)->map.get(w1).equals(map.get(w2))?w2.compareTo(w1):map.get(w1)-map.get(w2));
        for (String s : map.keySet()) {
            minheap.add(s);
            if(minheap.size() > k){
                minheap.poll();
            }
        }
        ArrayList<String> list = new ArrayList<>();
        while(!minheap.isEmpty()){
            list.add(minheap.poll());

        }
        Collections.reverse(list);
        return list;
    }
}
