package com.jyz.ttest.singleton;

public class DBConnection {
	public static void main(String[] args) {
        DBConnection con1 = DataSourceEnum.DATASOURCE.getConnection();
        DBConnection con2 = DataSourceEnum.DATASOURCE.getConnection();
        System.out.println(con1 == con2);
        System.exit(0);
    }
}
