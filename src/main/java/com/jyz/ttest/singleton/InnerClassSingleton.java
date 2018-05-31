package com.jyz.ttest.singleton;

/***
 * 最安全的单例实现
 * @author ethan
 *
 */
public class InnerClassSingleton {

	private InnerClassSingleton(){};
	
	private static class Inner{
		private static final InnerClassSingleton instance = new InnerClassSingleton();
	}
	
	public static InnerClassSingleton getInstance(){
		return Inner.instance;
	}
	
	public static void main(String[] args) {  
		InnerClassSingleton singleton = InnerClassSingleton.getInstance();//这样同样可以获取到singleton的单例  
		}
}
