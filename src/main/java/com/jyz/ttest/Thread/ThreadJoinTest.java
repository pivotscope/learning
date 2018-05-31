package com.jyz.ttest.Thread;

/***
 * join是Thread类的一个方法，启动线程后直接调用。在很多情况下，主线程生成并起动了子线程，
 * 如果子线程里要进行大量的耗时的运算，主线程往往将于子线程之前结束，但是如果主线程处理完其他的事务后，
 * 需要用到子线程的处理结果，也就是主线程需要等待子线程执行完成之后再结束，这个时候就要用到join()方法了。
 * join()的作用是：“等待该线程终止”，这里需要理解的就是该线程是指的主线程等待子线程的终止。
 * 也就是在子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行。
 *
 */
public class ThreadJoinTest {
	public static void main(String[] args) throws InterruptedException {    
        Thread t1 = new Thread(new Runner("A"));    
        Thread t2 = new Thread(new Runner("B"));    
        Thread t3 = new Thread(new Runner("C"));    
        t1.start();    
//        t1.join();    
        t2.start();    
//        t2.join();    
        t3.start();    
//        t3.join();    
        
    }    
        
}    
    
class Runner implements Runnable{   
    public String name;  
      
    Runner(String name)  
    {  
        this.name=name;  
    }  
    
    @Override    
    public void run() { 
    	synchronized (Runner.class) {
			
    		for(int i=0;i<10;i++){
    			System.out.println(name+""+i);    
    		}
		}
            
    }    
}
