package com.jyz.ttest.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlock {
	private BlockingQueue<String> blockingQueue;

	public ArrayBlock() {
		blockingQueue = new ArrayBlockingQueue<String>(3);
	}

	public BlockingQueue<String> getBlockingQueue() {
		return blockingQueue;
	}
}
