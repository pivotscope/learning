package com.jyz.ttest.Thread;

public class ThreadJoinTestVolatileClass {
	static class ThreadAA extends Thread {  
		  
	    private ThreadJoinTestVolatile dbtools;  
	  
	    public ThreadAA(ThreadJoinTestVolatile dbtools) {  
	        super();  
	        this.dbtools = dbtools;  
	    }  
	  
	    @Override  
	    public void run() {  
	        dbtools.methodA();  
	    }  
	}
	    
	    static class ThreadBB extends Thread {  
	    	  
	        private ThreadJoinTestVolatile dbtools;  
	      
	        public ThreadBB(ThreadJoinTestVolatile dbtools) {  
	            super();  
	            this.dbtools = dbtools;  
	        }  
	      
	        @Override  
	        public void run() {  
	            dbtools.methodB();  
	        }  
	    }
	    static class ThreadCC extends Thread {  
	        	  
	            private ThreadJoinTestVolatile dbtools;  
	          
	            public ThreadCC(ThreadJoinTestVolatile dbtools) {  
	                this.dbtools = dbtools;  
	            }  
	          
	            @Override  
	            public void run() {  
	                dbtools.methodC();  
	            } 
	        }      
            public static void main(String[] args) {  
            	ThreadJoinTestVolatile myService = new ThreadJoinTestVolatile();  
                for (int i = 0; i < 2; i++) {  
                    ThreadBB output = new ThreadBB(myService);  
                    output.start();  
                    ThreadAA input = new ThreadAA(myService);  
                    input.start();  
                    ThreadCC threadCC = new ThreadCC(myService);  
                    threadCC.start();  
                }  
            }  
}
