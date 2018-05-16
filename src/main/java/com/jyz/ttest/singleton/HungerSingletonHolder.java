package com.jyz.ttest.singleton;

/****
 * 饿汉式会占用较多的空间，因为其在类加载时就会完成实例化，而懒汉式又存在执行速率慢的情况，
 * 双重加锁机制呢？又有执行效率差的毛病，有没有一种完美的方式可以规避这些毛病呢？
　　貌似有的，就是使用类级内部类结合多线程默认同步锁，同时实现延迟加载和线程安全。

       如代码，所谓类级内部类，就是静态内部类，这种内部类与其外部类之间并没有从属关系，
       加载外部类的时候，并不会同时加载其静态内部类，只有在发生调用的时候才会进行加载，
       加载的时候就会创建单例实例并返回，有效实现了懒加载（延迟加载），
       至于同步问题，我们采用和饿汉式同样的静态初始化器的方式，借助JVM来实现线程安全。

　　其实使用静态初始化器的方式会在类加载时创建类的实例，但是我们将实例的创建显式放置在静态内部类中，
      它会导致在外部类加载时不进行实例创建，这样就能实现我们的双重目的：延迟加载和线程安全。
 * @author ethan
 *
 */
public class HungerSingletonHolder {
	    private static class SingletonHolder{
	        private static final HungerSingletonHolder instance = new HungerSingletonHolder();
	    }
	    private HungerSingletonHolder(){}
	    public static HungerSingletonHolder getInsatance(){
	        return SingletonHolder.instance;
	    }
}
