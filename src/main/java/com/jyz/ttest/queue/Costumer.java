package com.jyz.ttest.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Costumer extends Thread {
	private BlockingQueue<String> blockingQueue;

    public Costumer(ArrayBlock arrayBlock) {
        blockingQueue = arrayBlock.getBlockingQueue();
        this.setName("Costumer");
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                Thread.sleep(6000);
                String str = blockingQueue.take();
                System.out.println(getName() + " 取出数据 " + str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
    	ArrayBlock a = new ArrayBlock();
		Producer p = new Producer(a);
		Costumer c = new Costumer(a);
		p.start();
		c.start();
	}
}
