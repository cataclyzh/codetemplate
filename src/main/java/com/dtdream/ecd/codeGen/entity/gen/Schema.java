package com.dtdream.ecd.codeGen.entity.gen;

import java.util.List;

/**
 * 模式
 */
public class Schema {

	private String projectName;		//	生成项目名
	private String databaseName;		//	生成项目名
	private String packageName;		// 生成包路径

	private String UIModuleName;		// ui的模块名，应该和类名相同，待处理
	private String functionName;		// 生成功能名，模型基本名称
	private String functionNameSimple;		// 生成功能名（简写），用于部分页面提示信息，默认是functionName
	private String functionAuthor;		// 生成功能作者
	private Table genTable;		// 业务表名

	private List<Table> tables;		// 业务表名
	private String apiPath;
	private String apiVersion;		// 版本号符号

	private Boolean replaceFile;	// 是否替换现有文件    0：不替换；1：替换文件

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getApiPath() {
		return apiPath;
	}

	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}

	public String getUiModuleName() {
		return UIModuleName;
	}

	public void setUiModuleName(String UIModuleName) {
		this.UIModuleName = UIModuleName;
	}


	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}



	public String getFunctionName() {
		return functionName;
	}

	public String getApiVersion() {
		return "${apiVersion}";
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getFunctionNameSimple() {
		return functionNameSimple;
	}

	public void setFunctionNameSimple(String functionNameSimple) {
		this.functionNameSimple = functionNameSimple;
	}

	public String getFunctionAuthor() {
		return functionAuthor;
	}

	public void setFunctionAuthor(String functionAuthor) {
		this.functionAuthor = functionAuthor;
	}

	public Table getTable() {
		return genTable;
	}

	public void setTable(Table genTable) {
		this.genTable = genTable;
		this.genTable.setSchema(this);
	}

	public Boolean getReplaceFile() {
		return replaceFile;
	}

	public void setReplaceFile(Boolean replaceFile) {
		this.replaceFile = replaceFile;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	//	private String moduleName;		// 生成模块名
//	private String simpleModuleName;		// 生成模块名
//	private String subModuleName;		// 生成子模块名
//	public String getSimpleModuleName() {
//		return simpleModuleName;
//	}
//
//	public void setSimpleModuleName(String simpleModuleName) {
//		this.simpleModuleName = simpleModuleName;
//	}
//	public String getModuleName() {
//		return moduleName;
//	}
//
//	public void setModuleName(String moduleName) {
//		this.moduleName = moduleName;
//	}
//
//	public String getSubModuleName() {
//		return subModuleName;
//	}
//
//	public void setSubModuleName(String subModuleName) {
//		this.subModuleName = subModuleName;
//	}
}


