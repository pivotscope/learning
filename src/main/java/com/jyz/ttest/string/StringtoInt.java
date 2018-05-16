package com.jyz.ttest.string;

public class StringtoInt {
	 public static void main(String[] args) {
	        int i = parseInt("abc");
	        System.out.println(i);
	    }
	 
	    public static int parseInt(String s) {
	        if (s == null || s.equals(""))
	            throw new IllegalArgumentException("参数不能为null或空串！");
	 
	        int result = 0;
	        for (int i = 0, len = s.length(); i < len; i++) {
	            char c = s.charAt(i);
	            if (c >= '0' && c <= '9') {
	                result = result * 10 + (int) (c - '0');
	            } else {
	                throw new IllegalArgumentException("s中只能包含数字");
	            }
	        }
	 
	        return result;
	    }
}
