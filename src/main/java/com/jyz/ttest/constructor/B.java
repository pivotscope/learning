package com.jyz.ttest.constructor;

public class B extends A{
	public B(){
		System.out.println("B");
	}
	
	
	public static void main(String[] args) {
		A a = new B();
		a = new A();
		System.out.println(a);
	}
}
