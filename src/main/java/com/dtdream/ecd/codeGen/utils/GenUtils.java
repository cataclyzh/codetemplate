package com.dtdream.ecd.codeGen.utils;

import com.dtdream.ecd.codeGen.entity.Template;
import com.dtdream.ecd.codeGen.entity.gen.Schema;
import com.dtdream.ecd.codeGen.mapper.JaxbMapper;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.*;
import java.util.Map;

/**
 * 代码生成工具类
 */
public class GenUtils {

	private static Logger logger = LoggerFactory.getLogger(GenUtils.class);

	/**
	 * 获取模板路径
	 * @return
	 */
	public static String getTemplatePath(){
		try{
			File file = new DefaultResourceLoader().getResource("").getFile();
			if(file != null){
				return file.getAbsolutePath() + File.separator + StringUtils.replaceEach(GenUtils.class.getName(),
						new String[]{"util."+GenUtils.class.getSimpleName(), "."}, new String[]{"template", File.separator});
			}			
		}catch(Exception e){
			logger.error("{}", e);
		}

		return "";
	}

	/**
	 * XML文件转换为对象
	 * @param fileName
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T fileToObject(String fileName, Class<?> clazz){
		try {
			String pathName = fileName;
			InputStream is= new FileInputStream(new File(pathName));
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			StringBuilder sb = new StringBuilder();
			while (true) {
				String line = br.readLine();
				if (line == null){
					break;
				}
				sb.append(line).append("\r\n");
			}
			if (is != null) {
				is.close();
			}
			if (br != null) {
				br.close();
			}
			return (T) JaxbMapper.fromXml(sb.toString(), clazz);
		} catch (IOException e) {
			logger.warn("Error file convert: {}", e.getMessage());
		}
		return null;
	}


	/**
	 * 获取数据模型
	 * @param genScheme
	 * @return
	 */
	public static Map<String, Object> getDataModel(Schema genScheme){
		Map<String, Object> model = Maps.newHashMap();


		model.put("projectName", StringUtils.lowerCase(genScheme.getProjectName()));
		model.put("packageName", StringUtils.lowerCase(genScheme.getPackageName()));
		model.put("UIModuleName", genScheme.getUiModuleName());
		model.put("APIPath", genScheme.getApiPath());
		model.put("className", StringUtils.uncapitalize(genScheme.getTable().getClassName()));
		model.put("ClassName", StringUtils.capitalize(genScheme.getTable().getClassName()));
		model.put("CLASSNAME", StringUtils.upperCase(genScheme.getTable().getClassName()));

		model.put("functionName", genScheme.getFunctionName());
		model.put("functionNameSimple", genScheme.getFunctionNameSimple());
		model.put("functionAuthor", genScheme.getFunctionAuthor());
		model.put("functionVersion", DateUtils.getDate());
		model.put("table", genScheme.getTable());

//		model.put("moduleName", StringUtils.lowerCase(genScheme.getModuleName()));
//		model.put("subModuleName", genScheme.getSubModuleName());
//		model.put("simpleModuleName", genScheme.getSimpleModuleName());
//		model.put("SIMPLEMODULENAME",StringUtils.upperCase(genScheme.getSimpleModuleName()));
//		model.put("lastPackageName", StringUtils.substringAfterLast((String)model.get("packageName"),"."));
		return model;
	}


	/**
	 * 生成到文件
	 * @param template
	 * @param model
	 * @return
	 */
	public static String generateToFile(Template template, Map<String, Object> model, boolean isReplaceFile){
		// 获取生成文件
		String fileName = SystemPath.getSysPath()+"../../"+File.separator
				+ StringUtils.replaceEach(FreeMarkers.renderString(template.getFilePath() + "/", model),
				new String[]{"//", "/", "."}, new String[]{File.separator, File.separator, File.separator})
				+ FreeMarkers.renderString(template.getFileName(), model);
		System.out.println(fileName);
		logger.debug(" fileName === " + fileName);

		// 获取生成文件内容
		String content = FreeMarkers.renderString(StringUtils.trimToEmpty(template.getContent()), model);
		logger.debug(" content === \r\n" + content);

		// 如果选择替换文件，则删除原文件
		if (isReplaceFile){
			FileUtils.deleteFile(fileName);
		}

		// 创建并写入文件
		if (FileUtils.createFile(fileName)){
			FileUtils.writeToFile(fileName, content, true);
			logger.debug(" file create === " + fileName);
			return fileName;
		}else{
			logger.debug(" file extents === " + fileName);
			return fileName;
		}
	}
	

}
