/**
 * Copyright &copy; 2018-2019 DtDream ECD. All rights reserved.
 */
package com.dtdream.ecd.codeGen.entity;


/**
 * Author: gumi
 * Modified: gumi
 * Date: 2018-08-01
 * Description: 数据库管理表
 **/
public class Database {

	private static final long serialVersionUID = 1L;
	private String driverClassName;		// JDBC驱动类
	private String databaseName;		// 数据库名称
	private String databaseType;		// 数据库类型
	private String databaseIp;		// 数据库服务器地址
	private String port;		// 数据库服务端口
	private String userName;		// 登录用户名
	private String userPwd;		// 登录密码
	private String typeName;		// 数据库类型名，例如：公安，人社，国税
	private String inetType;		// 网段类型，例如：内网，外网
	private String accessKey;		// AccessKey
	private String secret;		// secret
	public Database() {
		super();
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}


	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}


	public String getDatabaseType() {
		return databaseType;
	}

	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}


	public String getDatabaseIp() {
		return databaseIp;
	}

	public void setDatabaseIp(String databaseIp) {
		this.databaseIp = databaseIp;
	}


	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}


	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public String getInetType() {
		return inetType;
	}

	public void setInetType(String inetType) {
		this.inetType = inetType;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
}
