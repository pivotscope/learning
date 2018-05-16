package com.jyz.ttest.syncdemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
		  
	    public static void main(String[] arg){  
	        Runnable t1=new MyThread();  
	        new Thread(t1,"t1").start();  
	        new Thread(t1,"t2").start();  
	    }  
	    
	    
	    static class MyThread implements Runnable {  
	    	
	    	private Lock lock=new ReentrantLock();  
	    	public void run() {  
	    		lock.lock();  
	    		try{  
	    			for(int i=0;i<5;i++)  
	    				System.out.println(Thread.currentThread().getName()+":"+i);  
	    		}finally{  
	    			lock.unlock();  
	    		}  
	    	}  
	    	
	    } 
	}  