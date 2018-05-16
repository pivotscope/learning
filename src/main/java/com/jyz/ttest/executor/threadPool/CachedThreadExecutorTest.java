package com.jyz.ttest.executor.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/***
 * 使用线程池好处：
 * 1、降低资源消耗；2、提高响应速度；3、提高线程的可管理性。
 * Java1.5引入的Executor框架把任务的提交和执行进行解耦，只需要定义好任务，然后提交给线程池，
 * 而不用关心该任务是如何执行、被哪个线程执行，以及什么时候执行
 * 
 * Java提供了4钟线程池：
	newCachedThreadPool
	newFixedThreadPool
	newSingleThreadExecutor
	newScheduledThreadPool
	你可以通过Executors来实例化这四种线程池。
	查看源码会发现，这四种线程池都直接或者间接获取的ThreadPoolExecutor实例 ，
	只是实例化时传递的参数不一样。所以如果java提供的四种线程池满足不了我们的需求，我们可以创建自定义线程池。
 * @author ethan
 *
 */
public class CachedThreadExecutorTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 创建一个可重用固定线程数的线程池
		ExecutorService pool = Executors.newCachedThreadPool();

		// 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口;

		Thread t1 = new MyThread();

		Thread t2 = new MyThread();

		Thread t3 = new MyThread();

		Thread t4 = new MyThread();

		Thread t5 = new MyThread();

		// 将线程放到池中执行；

		pool.execute(t1);

		pool.execute(t2);

		pool.execute(t3);

		pool.execute(t4);

		pool.execute(t5);

		// 关闭线程池

		pool.shutdown();

	}

}
