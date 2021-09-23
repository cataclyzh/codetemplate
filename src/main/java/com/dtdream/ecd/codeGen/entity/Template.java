package com.dtdream.ecd.codeGen.entity;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * 生成方案Entity
 */
@XmlRootElement(name= "template")
public class Template {
	
	private static final long serialVersionUID = 1L;
	private String name; 	// 名称
	private String filePath;		// 生成文件路径
	private String fileName;		// 文件名
	private String content;		// 内容

	public Template() {
		super();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

//	private String category;		// 分类
//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}
//
//	@XmlTransient
//	public List<String> getCategoryList() {
//		if (category == null){
//			return Lists.newArrayList();
//		}else{
//			return Lists.newArrayList(StringUtils.split(category, ","));
//		}
//	}
//
//	public void setCategoryList(List<String> categoryList) {
//		if (categoryList == null){
//			this.category = "";
//		}else{
//			this.category = ","+StringUtils.join(categoryList, ",") + ",";
//		}
//	}
	
}


