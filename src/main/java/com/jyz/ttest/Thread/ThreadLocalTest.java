package com.jyz.ttest.Thread;

import java.util.Random;

public class ThreadLocalTest {
	private static ThreadLocal<Integer> tl = new ThreadLocal<Integer>();
	
	public static void main(String[] args) {
	for(int i=0;i<2;i++){
		new Thread(new Runnable() {
			
			public void run() {
				int data = new Random().nextInt(6);
				System.out.println(Thread.currentThread().getName()+"put data:"+data);
				tl.set(data);
				new A().get();
				new B().get();
			}
		}).start();;
		}
	}
	static class A{
		public void get(){
			 int data = tl.get();
			 System.out.println("A from "+Thread.currentThread().getName()
					 +"get data:"+data);
		}
	}
	
	static class B{
		public void get(){
			 int data = tl.get();
			 System.out.println("B from "+Thread.currentThread().getName()
					 +"get data:"+data);
		}
	}
}
