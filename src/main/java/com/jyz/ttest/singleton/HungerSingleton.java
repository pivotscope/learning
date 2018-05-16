package com.jyz.ttest.singleton;

/***
 * 饿汉式 在类加载时就实例化
 * @author ethan
 * 这种方式基于classloder机制避免了多线程的同步问题，
 * 不过，instance在类装载时就实例化，这时候初始化instance显然没有达到lazy loading的效果。
 */
public class HungerSingleton {
	private HungerSingleton(){};
	private static HungerSingleton instance =  new HungerSingleton();
	public static HungerSingleton getInstance()	{
		return instance;
	}
}
