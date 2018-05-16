package com.jyz.ttest.tokenize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/***
 * 令牌化：令牌化是指在分隔符的基础上将一个字符串分割为若干个子字符串。
 * 例如，分隔符；分割字符串ac;bd;def;e为四个子字符串ac，bd，def和e。
 * 分隔符自身也可以是一个常见正则表达式。
	String.split(regex)函数将regex作为参数。
 * @author ethan
 */
public class Tokenize {
	private static void tokenizeUsingScanner(String string,String regex) {
	    Scanner scanner = new Scanner(string);
	    scanner.useDelimiter(regex);
	    List<String> list = new ArrayList<String>();
	    while(scanner.hasNext()){
	    	list.add(scanner.next());
	    }
	    System.out.println(list);
	}
	public static void main(String[] args) {
		tokenizeUsingScanner("ac;bd;def;e",";");
		System.out.println(11 >> 2);
		Map<String,String> map = new HashMap<String,String>();
	}
}
