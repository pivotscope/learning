package com.jyz.ttest.executor.workingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/***
 * 与有界队列相比，除非系统资源耗尽，否则无界的任务队列不存在任务入队失败的情况。
 * 当有新的任务到来，系统的线程数小于corePoolSize时，则新建线程执行任务。
 * 当达到corePoolSize后，就不会继续增加，若后续仍有新的任务加入，
 * 而没有空闲的线程资源，则任务直接进入队列等待。若任务创建和处理的速度差异很大，
 * 无界队列会保持快速增长，直到耗尽系统内存。
 * @author ethan
 *
 */
public class ThreadPoolExecutorWuJie implements Runnable{
		  
	    public Integer count;  
	      
	    public ThreadPoolExecutorWuJie(Integer count) {  
	        this.count = count;  
	    }  
	      
	    @Override  
	    public void run() {  
	        System.out.println("任务" + count);  
	        try {  
	            Thread.sleep(2000);  
	        } catch (InterruptedException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	      
	    public static void main(String[] args) throws InterruptedException {  
	        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();  
	          
	        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 1L, TimeUnit.SECONDS, workQueue);  
	        for (int i = 1; i <= 20; i++) {  
	            pool.execute(new ThreadPoolExecutorWuJie(i));  
	        }  
	        Thread.sleep(1000);  
	        System.out.println("线程池中队列中的线程数量：" + workQueue.size());  
	          
	          
	        pool.shutdown();  
	    }  
}
