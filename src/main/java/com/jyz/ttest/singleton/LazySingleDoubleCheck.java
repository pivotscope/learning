package com.jyz.ttest.singleton;
/***
 * 在JDK1.5之后，双重检查锁定才能够正常达到单例效果
 * 在意的是volatile的使用，volatile关键字的含义是：
 * 被其所修饰的变量的值不会被本地线程缓存，所有对该变量的读写都是直接操作共享内存来实现，
 * 从而确保多个线程能正确的处理该变量。
 * 当一个变量被volatile修饰后，表示着线程本地内存无效，当一个线程修改共享变量后他会立即被更新到主内存中，
 * 当其他线程读取共享变量时，它会直接从主内存中读取。
 * 该关键字可能会屏蔽掉虚拟机中的一些代码优化，所以其运行效率可能不是很高，
 * 所以，一般情况下，并不建议使用双重加锁机制，酌情使用才是正理！
 * @author ethan
 *
 */
public class LazySingleDoubleCheck {
	    private volatile static LazySingleDoubleCheck LazySingleDoubleCheck;
	    private LazySingleDoubleCheck(){}
	    public static LazySingleDoubleCheck getSingletonDemo7(){
	        if (LazySingleDoubleCheck == null) {
	            synchronized (LazySingleDoubleCheck.class) {			//1
	                if (LazySingleDoubleCheck == null) {				//2
	                	LazySingleDoubleCheck = new LazySingleDoubleCheck();//3
	                }
	            }
	        }
	        return LazySingleDoubleCheck;
	    }
}
