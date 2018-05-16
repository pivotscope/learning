package com.jyz.ttest.maplistTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
	private static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
	public static void main(String[] args) {
		map.put(1, 1);
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("1");
		Collections.synchronizedList(list);
//		ConcurrentMap<Integer, Integer> map = new ConcurrentMap<Integer, Integer>();
		
	}
	public List<String> removeDupicate(){
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("1");
		System.out.println(list);
		List<String> newLis = new ArrayList<String>(new HashSet<String>(list));
		System.out.println(newLis);
		List<String> newList = new ArrayList<String>(new TreeSet<String>(list));
		System.out.println(newList);
		return list;
	}

	public static List<String> secureRemove(){
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		 Iterator<String> iter = list.iterator();
	        while (iter.hasNext()) {
	            String item = iter.next();
	            if (item.equals("3")) {
	                iter.remove();
	            }
	        }
	        return list;
	    }
	
	public static List<String> remove22(ArrayList<String> list, String target) {
        final CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<String>(list);
        for (String item : cowList) {
            if (item.equals(target)) {
                cowList.remove(item);
            }
        }
        return list;
    }
	public static void Vectortt(){
		Vector v1 = new Vector(); 
		Integer integer1= new Integer(1); 
		//加入为字符串对象 
		v1.addElement("one"); 
		//加入的为integer的对象 
		v1.addElement(integer1); 
		v1.addElement(integer1); 
		v1.addElement("two"); 
		v1.addElement(new Integer(2)); 
		v1.addElement(integer1); 
		v1.addElement(integer1);
		v1.get(0);
		System.out.println(v1);
		
	}
	
	public static void linkedlisttt(){
		List li = new LinkedList<String>();
		li.add("a");
		li.add("b");
		li.get(0);
	}
	}
