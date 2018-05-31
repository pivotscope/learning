package com.jyz.ttest.maplistTest;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkHashMapTest {
public static void main(String[] args) {
	int initialCapacity = 10;//初始化容量
    float loadFactor = 0.75f;//加载因子，一般是 0.75f
    boolean accessOrder = true;//排序方式 false 基于插入顺序  true  基于访问顺序
    Map<String, Integer> map = new LinkedHashMap<>(initialCapacity, loadFactor, accessOrder);
    
    for (int i = 0; i < 10; i++) {
        map.put(String.valueOf(i), i);
    }
    //访问前顺序
    for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
        Map.Entry<String, Integer> next = it.next();
        System.out.println("linkedMap--before-->" + next.getKey());
    }

    //模拟访问
    map.get("5");

    //访问后数据
    for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
        Map.Entry<String, Integer> next = it.next();
        System.out.println("linkedMap--after-->" + next.getKey());
    }
}
}
