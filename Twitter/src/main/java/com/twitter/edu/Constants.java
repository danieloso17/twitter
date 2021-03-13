package com.twitter.edu;

public interface Constants {

	String CONSUMERKEY = "5hHlRxBdDBoGNCnXiFob0V5uh";
	String CONSUMERSECRET = "rNFFfpYMNkizFnRhVFGsWaaga0eV5vHSxzvsNNxg19P9wbaGyv";
	String ACCESSTOKEN = "1364771370832433158-60eg2Bl3uu4zi4umfiRBofAMMM3o0B";
	String ACCESSSECRET = "68RBuOg1rIKutyj7fHH8uhQJf6TBS4JedCkTVJgmOE0ou";
	
	String dbName = "compensar";
	String serverip = "192.168.0.16";
	String serverport = "1433";
	
	String DRIVE = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String URL = "jdbc:sqlserver://" + serverip + "\\SQLEXPRESS:" + serverport + ";databaseName=" + dbName + "";
	String USER = "sa";
	String PASS = "123456";	
	
}
