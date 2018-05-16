package com.jyz.ttest.singleton;

/***
 * 懒汉式
 * @author ethan
 *	这种写法lazy loading很明显，但是致命的是在多线程不能正常工作。
 */
public class LazySingleton {
	private LazySingleton(){};
	private static LazySingleton instance;
	public static LazySingleton getInstance(){
		if(instance == null){
			instance = new LazySingleton();
		}
		return instance;
	}
}
