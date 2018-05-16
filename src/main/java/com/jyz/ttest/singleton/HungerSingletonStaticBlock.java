package com.jyz.ttest.singleton;

/***
 * 表面上看起来差别挺大，其实更第三种方式差不多，都是在类初始化即实例化instance
 * @author ethan
 *
 */
public class HungerSingletonStaticBlock {
	    private static HungerSingletonStaticBlock instance = null;
	    static{
	        instance = new HungerSingletonStaticBlock();
	    }
	    private HungerSingletonStaticBlock(){}
	    public static HungerSingletonStaticBlock getInstance(){
	        return instance;
	    }
}
