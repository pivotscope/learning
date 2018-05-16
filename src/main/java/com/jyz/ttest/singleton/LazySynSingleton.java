package com.jyz.ttest.singleton;

/***
 * 这种写法在getInstance()方法中加入了synchronized锁。
 * 能够在多线程中很好的工作，而且看起来它也具备很好的lazy loading，
 * 但是效率很低（因为锁），并且大多数情况下不需要同步
 * @author ethan
 *
 */
public class LazySynSingleton {
		private LazySynSingleton(){};
		private static LazySynSingleton instance;
		public static synchronized LazySynSingleton getInstance(){
			if(instance == null){
				instance = new LazySynSingleton();
			}
			return instance;
		}
}
