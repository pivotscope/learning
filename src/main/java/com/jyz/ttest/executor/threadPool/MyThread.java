package com.jyz.ttest.executor.threadPool;

public class MyThread extends Thread {
	@Override
    public void run() {
        // TODO Auto-generated method stub
//        super.run();
    System.out.println(Thread.currentThread().getName()+"正在执行....");
    } 
}
