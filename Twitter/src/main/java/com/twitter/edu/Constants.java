package com.twitter.edu;

public interface Constants {

	String CONSUMERKEY = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
	String CONSUMERSECRET = "xxxxxxxxxxxxxxxxxxxxxxxxxx";
	String ACCESSTOKEN = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
	String ACCESSSECRET = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
	
	String dbName = "comxxxx";
	String serverip = "192.xxx.xx.xx";
	String serverport = "1433";
	
	String DRIVE = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String URL = "jdbc:sqlserver://" + serverip + "\\SQLEXPRESS:" + serverport + ";databaseName=" + dbName + "";
	String USER = "sa";
	String PASS = "123456";	
	
}
