package com.jyz.ttest.list_set_map;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
	public static void main(String[] args) {
		hashsetTest();
	}
	/***
	 * Set类继承了Conllection类，是一种集合类。Set的实现类有三个:HashSet,LinkedHashSet,TreeSet
	 * 采用hash表算法来实现的，其中的元素没有按顺序排列，主要有add()、remove()以及contains()等方法
	 * HashSet类按照哈希算法来存取集合中的对象，存取速度比较快。
     *    1.Set中是不能出现重复数据的。
     *    2.Set中可以出现空数据。
     *    3.Set中的数据是无序的。
	 */
	public static void hashsetTest(){
		Set<String> set = new HashSet<String>();  
	    for(int i= 0;i<6;i++){  
	    set.add(i+"");  
	    }  
	    set.add("3");       //重复数据，不会写入  
	    set.add(null);      //可以写入空数据  
	    Iterator<String> iter = set.iterator();  
	    while(iter.hasNext()){  
	    	System.out.println(iter.next());        //输出是无序的  
	    } 
	    System.out.println(set);
	}
	
	/***LinkedHashSet正好介于HashSet和TreeSet之间，它也是一个hash表，但它同时维护了一个双链表来记录插入的顺序，基本方法的复杂度为O(1)
	 * 
	 * 相对于HashSet来说有一个很大的不一样是LinkedHashSet是有序的。
	 * LinkedHashSet在迭代访问Set中的全部元素时，性能比HashSet好，但是插入时性能稍微逊色于HashSet
	 */
	public static void LinkedHashSetTest(){
		Set<String> set = new LinkedHashSet<String>();  
		for(int i= 0;i<6;i++){  
		    set.add(i+"");  
		}  
		set.add("3");       //重复数据，不会写入  
		set.add(null);      //可以写入空数据  
		Iterator<String> iter = set.iterator();  
		while(iter.hasNext()){  
		    System.out.println(iter.next());        //输出是有序的  
		}  
	}
	
	/***TreeSet采用树结构实现(称为红黑树算法)，元素是按顺序进行排列，主要有add()、remove()以及contains()等方法，
	 * 它们都是复杂度为O(log (n))的方法；它还提供了一些处理排序的set方法，如first(), last(), headSet(), tailSet()等
	 * 	  1.不能写入空数据
     *    2.写入的数据是有序的。
     *    3.不写入重复数据
	 */
	public static void TreeSetTest(){
		Set<String> set = new TreeSet<String>();  
		for(int i= 0;i<6;i++){  
		    set.add(i+"");  
		}  
		set.add("3");       //重复数据，不会写入  
		//set.add(null);        //不可以写入空数据        
		Iterator<String> iter = set.iterator();  
		while(iter.hasNext()){  
		    System.out.println(iter.next());        //输出是有序的  
		}  
	}
}
