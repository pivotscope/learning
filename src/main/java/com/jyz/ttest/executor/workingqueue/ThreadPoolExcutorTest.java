package com.jyz.ttest.executor.workingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/***
 *  1.初始的poolSize小于corePoolSize，提交的runnable任务，会直接做为new一个Thread的参数，立马执行 。
	2.当提交的任务数超过了corePoolSize，会将当前的runable提交到一个block queue中,。
	3.有界队列满了之后，如果poolSize < maximumPoolsize时，会尝试new 一个Thread的进行救急处理，
		立马执行对应的runnable任务。
	4.如果3中也无法处理了，就会走到第四步执行reject操作。
	
	ThreadPoolExecutor（corePoolSize,maxPoolSize,keepAliveTime,timeUnit,workQueue,threadFactory,handle);   
方法参数：
　  corePoolSize：核心线程数
　  maxPoolSize：最大线程数
     keepAliveTime：线程存活时间（在corePore<*<maxPoolSize情况下有用）
     timeUnit：存活时间的时间单位
     workQueue：阻塞队列（用来保存等待被执行的任务）

注：关于workQueue参数的取值,JDK提供了4种阻塞队列类型供选择：
　　      ArrayBlockingQueue：基于数组结构的有界阻塞队列，按FIFO排序任务；//有界
　　      LinkedBlockingQuene：基于链表结构的阻塞队列，按FIFO排序任务，吞吐量通常要高于  //无界
    SynchronousQuene：一个不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除操作，//是无界的
    	否则插入操作一直处于阻塞状态，吞吐量通常要高于ArrayBlockingQuene；
　　      PriorityBlockingQuene：具有优先级的无界阻塞队列；
 *
 */
//有界队列
public class ThreadPoolExcutorTest implements Runnable {
	public String name;  
    
    public ThreadPoolExcutorTest(String name) {  
        this.name = name;  
    }  
      
    public void run() {  
        System.out.println(name);  
        try {  
            Thread.sleep(1000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
          
    }  
      
    public static void main(String[] args) {  
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(3);  
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(  
                            1, //corePoolSize  
                            2,  //maximumPoolSize  
                            1L,  
                            TimeUnit.SECONDS,  
                            workQueue  
                            );  
        threadPool.execute(new ThreadPoolExcutorTest("任务1"));  
        threadPool.execute(new ThreadPoolExcutorTest("任务2"));  
        threadPool.execute(new ThreadPoolExcutorTest("任务3"));  
        threadPool.execute(new ThreadPoolExcutorTest("任务4"));  
        threadPool.execute(new ThreadPoolExcutorTest("任务5"));  
        threadPool.execute(new ThreadPoolExcutorTest("任务6"));  
        threadPool.shutdown();  
          
    }  
}
