package com.jyz.ttest.string;

public class StringReverse {

static String reverse(String s){
		String ss = new StringBuffer(s).reverse().toString();
		System.out.println(ss);
		return ss;
	}
static String reverse1(String s){
	String tt="";
	for(int i=s.length()-1;i>=0;i--){
		tt += s.charAt(i);
	}
	System.out.println(tt);
	return tt;
//	char[] cc = s.toCharArray();
//	String tt="";
//	for(int i=cc.length-1;i>=0;i--){
//		tt += cc[i];
//	}
//	System.out.println(tt);
//	return tt;
}
static String reverse2(String s){
		char[] cc = s.toCharArray();
		for(int i=0;i<=(cc.length-1)/2;i++){
			char temp ;
			temp = cc[i];
			cc[i] = cc[cc.length-1];
			cc[cc.length-1] = temp;
		}
		String a = new String(cc);
		System.out.println(a);
		return a;
	}


public static int[] twoSum(int[] nums, int target) {
    int[] arr_new = new int[2];
    for(int i=0;i<nums.length-1;i++){
        if(nums[i]+nums[i+1]==target){
        	arr_new[0] = i;
        	arr_new[1] = i+1;
        }
    }
    for(int i=0;i<arr_new.length;++i){
    	System.out.println(arr_new[i]);
    }
    return arr_new;
}
public static void main(String[] args) {
	String s = "Hello , world ~!";
//	reverse(s);
	reverse1(s);
	int[] a ={1,2,7, 11, 15};
	twoSum(a, 9);
}
}
