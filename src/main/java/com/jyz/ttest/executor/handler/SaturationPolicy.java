package com.jyz.ttest.executor.handler;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SaturationPolicy {
	/** 
     * 线程池工作队列已满时，在不同饱和策略下表现 
     * @param handler 线程池工作队列饱和策略 
     * 线程池的饱和策略，当阻塞队列满了，且没有空闲的工作线程，如果继续提交任务，必须采取一种策略处理该任务，线程池提供了4种策略：
	1、AbortPolicy：直接抛出异常，默认策略；
	2、CallerRunsPolicy：用调用者所在的线程来执行任务；
	3、DiscardOldestPolicy：丢弃阻塞队列中靠最前的任务，并执行当前任务；
	4、DiscardPolicy：直接丢弃任务；
	当然也可以根据应用场景实现RejectedExecutionHandler接口，自定义饱和策略，
     */  
    public static void policy(){  
        //基本线程2个，最大线程数为3，工作队列容量为5  
        ThreadPoolExecutor executor=new ThreadPoolExecutor(2,3,0L,TimeUnit.MILLISECONDS,
        		new LinkedBlockingQueue<Runnable>(5));
        	
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//设置饱和策略 用调用者所在的线程来执行任务  
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());//：直接抛出异常，默认策略；);
        for (int i = 0; i < 10; i++) {  
        	executor.submit(new Task());//提交任务  
        }  
        executor.shutdown();  
    }  
  
    public static void main(String[] args) {  
//        policy(new ThreadPoolExecutor.AbortPolicy());  
//        policy((new ThreadPoolExecutor.CallerRunsPolicy()));  
//        policy(new ThreadPoolExecutor.DiscardPolicy());  
//        policy(new ThreadPoolExecutor.DiscardOldestPolicy());  
    }  
  
    //自定义任务  
    static class Task implements Runnable {  
        private static int count = 0;  
        private int id = 0;//任务标识  
        public Task() {  
            id = ++count;  
        }  
        public  void run() {  
            try {  
                TimeUnit.SECONDS.sleep(3);//休眠3秒  
            } catch (InterruptedException e) {  
                System.err.println("线程被中断" + e.getMessage());  
            }  
            System.out.println(" 任务：" + id + "\t 工作线程: "+ Thread.currentThread().getName() + " 执行完毕");  
        }  
    }   
}
