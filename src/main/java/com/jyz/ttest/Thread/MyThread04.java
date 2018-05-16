package com.jyz.ttest.Thread;

public class MyThread04 extends Thread {
	public MyThread04(String threadName) {
		super(threadName);
	}

	@Override
	public void run() {
		// try{
		for (int j = 0; j < 20; j++) {
			if (this.isInterrupted())
				System.out.println(Thread.currentThread().getName() + ":" + j);
			try {
				System.out.println(Thread.currentThread().getName() + ":" + j);
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + "after sleep:" + j);
			} catch (InterruptedException e) {
				this.interrupt();//由于处于sleep状态的线程被终止后会将标志位复位，所以需要重设一次
				// e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		MyThread04 t = new MyThread04("A");
		t.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.interrupt();
	}
}
