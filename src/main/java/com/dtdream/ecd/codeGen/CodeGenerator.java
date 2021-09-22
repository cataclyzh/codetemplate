package com.dtdream.ecd.codeGen;

import com.dtdream.ecd.codeGen.entity.Template;
import com.dtdream.ecd.codeGen.entity.gen.Schema;
import com.dtdream.ecd.codeGen.entity.gen.Table;
import com.dtdream.ecd.codeGen.entity.gen.TableColumn;
import com.dtdream.ecd.codeGen.mapper.JsonMapper;
import com.dtdream.ecd.codeGen.util.GenUtils;
import com.dtdream.ecd.codeGen.utils.FileUtils;
import com.dtdream.ecd.codeGen.utils.StringUtils;
import com.dtdream.ecd.codeGen.utils.SystemPath;
import com.google.common.collect.Lists;

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
	private static final String definitionFile ="/"+
			SystemPath.getSysPath()+"../../entityDefinition/" +
					"Tag.json";
	private static final String parentDefinitionFile ="/"+
			SystemPath.getSysPath()+"../../entityDefinition/" +
			"TagCatalog.json";
	private static final String templateFilePath ="/"+
			SystemPath.getSysPath()+"../../templates/newcrud";
	private static final String treeTemplateFilePath ="/"+
			SystemPath.getSysPath()+"../../templates/tree";
	public static void main(String[] args) throws IOException {
//		generateCode(definitionFile,"tree");
//		generateCode(definitionFile,"crud");
//		generateCode(generateDefinitionFilePath("TagCatalog.json"),"tree");
//		generateCode(generateDefinitionFilePath("SYS/HotWire.json"),"crud");
		generateCode(generateDefinitionFilePath("GA/t129.json"),"crud");
//		generateCode(generateDefinitionFilePath("ParamString.json"),"crud");
//		generateRelateCode(definitionFile,parentDefinitionFile,"crud","tree");
//		generateRelateCode(generateDefinitionFilePath("GA/HotWire.json"),generateDefinitionFilePath("SYS/Organization.json"),"","");
	}


	public static List<Table> tableList= Lists.newArrayList();

	private static String generateDefinitionFilePath(String fileName){
		String result=definitionDir+fileName;
		return result;
	}

	private static String generateRelateCode(String path,String parentPath,String type,String parentType) throws IOException {

		String templatePath=templateFilePath;
		if(type.equalsIgnoreCase("tree")){
			templatePath=treeTemplateFilePath;
		}
		StringBuilder result = new StringBuilder();
		String content= FileUtils.readFileToString(new File(path),"utf-8");
		Schema genScheme=JsonMapper.getInstance().fromJson(content,Schema.class);
		String parentContent= FileUtils.readFileToString(new File(parentPath),"utf-8");
		Schema parentSchema=JsonMapper.getInstance().fromJson(parentContent,Schema.class);
		genScheme.getTable().setParent(parentSchema.getTable());
		//生成构建Freeker的模型
		Map<String, Object> model = GenUtils.getDataModel(genScheme);

		//生成代码
		generateCode(templatePath,result, model, "/sql");
		generateCode(templatePath,result, model, "/entity");
		generateCode(templatePath,result, model, "/entityExample");
		generateCode(templatePath,result, model, "/dao");
		generateCode(templatePath,result, model, "/mapper");
		generateCode(templatePath,result, model, "/service");
		generateCode(templatePath,result, model, "/controller");
		generateCode(templatePath,result, model, "/entityVO");
		generateCode(templatePath,result, model, "/controllerTest");
		generateCode(templatePath,result, model, "/vue/api_js");
		generateCode(templatePath,result, model, "/vue/index");
		generateCode(templatePath,result, model, "/vue/view");
		return result.toString();
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
		generateCode(templatePath,result, model, "/sql");
		generateCode(templatePath,result, model, "/sql_plugin");
		generateCode(templatePath,result, model, "/entity");
		generateCode(templatePath,result, model, "/entityExample");
		generateCode(templatePath,result, model, "/dao");
		generateCode(templatePath,result, model, "/mapper");
		generateCode(templatePath,result, model, "/crudservice");
		generateCode(templatePath,result, model, "/service");
		generateCode(templatePath,result, model, "/crudcontroller");
		generateCode(templatePath,result, model, "/controller");
		generateCode(templatePath,result, model, "/entityVO");
		generateCode(templatePath,result, model, "/controllerTest");

		generateCode(templatePath,result, model, "/gavue/list");
		generateCode(templatePath,result, model, "/gavue/page");
		generateCode(templatePath,result, model, "/gavue/detail");

		generateCode(templatePath,result, model, "/vue/api_js");
		generateCode(templatePath,result, model, "/vue/index");
		generateCode(templatePath,result, model, "/vue/view");
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