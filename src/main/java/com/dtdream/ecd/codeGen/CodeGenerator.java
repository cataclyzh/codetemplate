package com.dtdream.ecd.codeGen;

import com.dt.gen.conf.DtdataPackageConfigBuilder;
import com.dt.gen.conf.PackageConfigBuilder;
import com.dt.gen.service.CodeGenService;
import com.dtdream.ecd.codeGen.config.DataSourceConfigBuilder;
import com.dtdream.ecd.codeGen.entity.Template;
import com.dtdream.ecd.codeGen.entity.gen.Schema;
import com.dtdream.ecd.codeGen.entity.gen.Table;
import com.dtdream.ecd.codeGen.entity.gen.TableColumn;
import com.dtdream.ecd.codeGen.mapper.JsonMapper;
import com.dtdream.ecd.codeGen.utils.GenUtils;
import com.dtdream.ecd.codeGen.utils.FileUtils;
import com.dtdream.ecd.codeGen.utils.JDBCTemplateUtils;
import com.dtdream.ecd.codeGen.utils.StringUtils;
import com.dtdream.ecd.codeGen.utils.SystemPath;
import com.google.common.collect.Lists;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Author: gaowenxin
 * Modified: gaowenxin
 * Date: 2018/7/19
 * Description:
 **/
public class CodeGenerator {

	private static final String definitionDir ="/"+
			SystemPath.getSysPath()+"../../entityDefinition/";
	private static final String targerDir ="/"+
			SystemPath.getSysPath()+"../../genResult/";
	private static final String templateFilePath ="/"+
			SystemPath.getSysPath()+"template/crud";
	private static final String treeTemplateFilePath ="/"+
			SystemPath.getSysPath()+"../../templates/tree";


	public static void main(String[] args) throws IOException {
		FileUtils.deleteDirectory(targerDir);


		String dirPath=generateDefinitionFilePath("GA");
		File dir=new File(dirPath);
		if (dir.exists()){
			for (File file : dir.listFiles()) {
				if(file.getAbsolutePath().toLowerCase().endsWith("json")){
					generateCode(file.getAbsolutePath(),"crud");
				}
			}
		}
	}


	public static List<Table> tableList= Lists.newArrayList();


	private static String generateDefinitionFilePath(String fileName){
		String result=definitionDir+fileName;
		System.out.println(result);
		return result;
	}

	private static String generateCode(String path,String type) throws IOException {
		List<String> fileNames=getAllDefininedFileNames(CodeGenerator.definitionDir);
		for (String name : fileNames) {
			String content1 = FileUtils.readFileToString(new File(name), "utf-8");
			Schema genScheme1 = JsonMapper.getInstance().fromJson(content1, Schema.class);
			CodeGenerator.tableList.add(genScheme1.getTable());
		}
		String templatePath=templateFilePath;
		if(type.equalsIgnoreCase("tree")){
			templatePath=treeTemplateFilePath;
		}
		StringBuilder result = new StringBuilder();
		String content= FileUtils.readFileToString(new File(path),"utf-8");
		Schema genScheme=JsonMapper.getInstance().fromJson(content,Schema.class);
		Table table=genScheme.getTable();
		List<TableColumn> columns=table.getColumnList();
		for (TableColumn column : columns) {
			if(StringUtils.isNotBlank(column.getIsFk())&&column.getIsFk().equalsIgnoreCase("1")){
				String fileName=column.getForeign();
				for (String name : fileNames) {
					if (name.endsWith(fileName)){
						String content1= FileUtils.readFileToString(new File(name),"utf-8");
						Schema genScheme1=JsonMapper.getInstance().fromJson(content1,Schema.class);
						genScheme1.getTable().setSchema(genScheme1);
						column.setForeignTable(genScheme1.getTable());
					}
				}
			}
		}
		//生成构建Freeker的模型
		Map<String, Object> model = GenUtils.getDataModel(genScheme);
		//生成代码
		generateCode(templatePath,result, model, "/sql_plugin");
		String sqlFile=result.toString();
		JdbcTemplate jdbcTemplate= JDBCTemplateUtils.genJdbcTemplate(genScheme.getDatabaseName());
		String sql=FileUtils.readFileToString(new File(sqlFile));
		for (String s : sql.split(";")) {
			if(StringUtils.isNotEmpty(s.trim())) {
				jdbcTemplate.update(s.trim());
			}
		}
		DataSourceConfigBuilder builder = new DataSourceConfigBuilder(genScheme.getDatabaseName(),genScheme.getModuleName());
		String tableName="t"+genScheme.getTable().getNumber()+"_"+genScheme.getTable().getName();
		if(genScheme.getTable().getTree()!=null&&genScheme.getTable().getTree()) {
			new CodeGenService("/template/tree/").execute(builder.buildPackageConfig(), builder.buildDataSourceConfig(), tableName);
		}else{
			new CodeGenService("/template/").execute(builder.buildPackageConfig(), builder.buildDataSourceConfig(), tableName);
		}
		if(genScheme.getTable().getIsUserView() ||  genScheme.getTable().getIsOrgView() || genScheme.getTable().getIsTableJoinView()) {
			String viewName = "v" + genScheme.getTable().getNumber() + "_" + genScheme.getTable().getName();
			if(genScheme.getTable().getTree()!=null&&genScheme.getTable().getTree()) {
				new CodeGenService("/template_v/tree/").execute(builder.buildPackageConfig(), builder.buildDataSourceConfig(), viewName);
			}else{
				new CodeGenService("/template_v/").execute(builder.buildPackageConfig(), builder.buildDataSourceConfig(), viewName);
			}
		}
		generateCode(templatePath,result, model, "/model");
		generateCode(templatePath,result, model, "/modelConverter");
		if(genScheme.getTable().getIsUserView() ||  genScheme.getTable().getIsOrgView() || genScheme.getTable().getIsTableJoinView()) {
			generateCode(templatePath, result, model, "/vmodel");
			generateCode(templatePath, result, model, "/vmodelConverter");
		}
		generateCode(templatePath,result, model, "/postman");
		generateCode(templatePath,result, model, "/test");
		if(genScheme.getTable().getTree()!=null&&genScheme.getTable().getTree()) {
			generateCode(templatePath,result, model, "/sql_mapper");
		}
		return result.toString();
	}

	private static void generateCode(String path,StringBuilder result, Map <String, Object> model, String s) {
		Template templateSQL = GenUtils.fileToObject
				(path +
						s +
						".xml", Template.class);
		String sqlResultFilePath = GenUtils.generateToFile(templateSQL, model, true);
		result.append(sqlResultFilePath);
	}


	private static List<String> getAllDefininedFileNames(String path){
		List<String> list= Lists.newArrayList();
		File file=new File(path);
		if(file.exists()){
			File[] children=file.listFiles();
			for (File child : children) {
				if (child.isFile()){
					list.add(child.getAbsolutePath());
				}else{
					list.addAll(getAllDefininedFileNames(child.getAbsolutePath()));
				}
			}
		}
		return list;
	}
}