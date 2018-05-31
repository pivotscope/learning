package com.jyz.ttest.list_set_map;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	/**
	 * 与set最大区别是可以随机访问元素
	 * @param args
	 */
public static void main(String[] args) {
	List<Integer> list = new ArrayList<Integer>() ;
	list.add(1);
	list.add(1);
	list.add(1);
	list.add(1);
	list.add(1);
	list.add(2);
	System.out.println(list.get(2));
	System.out.println(list);
}
}
