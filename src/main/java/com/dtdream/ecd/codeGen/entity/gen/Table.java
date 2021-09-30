package com.dtdream.ecd.codeGen.entity.gen;

import com.dtdream.ecd.codeGen.utils.StringUtils;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * 数据表
 */
public class Table  {
	private Schema schema;											//外部信息
	private String name; 											// 表名称
	private String number; 											// 表名称
	private String comments;										// 表描述
	private String className;										// 实体类名称
	private Boolean isTree;

	public Boolean getTree() {
		return isTree;
	}

	public void setIsTree(Boolean tree) {
		isTree = tree;
	}

	private List<TableColumn> columnList = Lists.newArrayList();	// 列信息

	private Table parent;											// 父表对象
	private List<Table> childList = Lists.newArrayList();			// 子表列表
	
//	private List<String> pkList; // 当前表主键列表

	public Boolean getIsUserView(){
		for (TableColumn tableColumn : this.columnList) {
			if (tableColumn.getName().toLowerCase().endsWith("user_id")){
				return true;
			}
		}
		return false;
	}

	public Boolean getIsTableJoinView(){
		for (TableColumn tableColumn : this.columnList) {
			if (StringUtils.isNotEmpty(tableColumn.getJoinTableName())){
				return true;
			}
		}
		return false;
	}
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Boolean getIsOrgView(){
		for (TableColumn tableColumn : this.columnList) {
			if (tableColumn.getName().toLowerCase().endsWith("org_id")){
				return true;
			}
		}
		return false;
	}


	public Table() {
		super();
	}

	public Schema getSchema() {
		return schema;
	}

	public void setSchema(Schema schema) {
		this.schema = schema;
	}

	public String getName() {
		return StringUtils.toCamelCase(name).toLowerCase();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

//	public List<String> getPkList() {
//		return pkList;
//	}
//
//	public void setPkList(List<String> pkList) {
//		this.pkList = pkList;
//	}

	public String getFullName(){
		if(StringUtils.isNotEmpty(this.number)) {
			return "t" + this.number + "_" + this.name;
		}else{
			return "t_"+this.name;
		}
	}

	public Table getParent() {
		return parent;
	}

	public void setParent(Table parent) {
		this.parent = parent;
	}

	public List<TableColumn> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<TableColumn> columnList) {
		this.columnList = columnList;
	}

	public List<Table> getChildList() {
		if(childList!=null&&!childList.isEmpty()){
			return childList;
		}else{
			for (TableColumn tableColumn : columnList) {
				if(tableColumn.getForeignTable()!=null){
					childList.add(tableColumn.getForeignTable());
				}
			}
		}
		return childList;
	}

	public void setChildList(List<Table> childList) {
		this.childList = childList;
	}
	
	/**
	 * 获取列名和说明
	 * @return
	 */
	public String getNameAndComments() {
		return getName() + (comments == null ? "" : "  :  " + comments);
	}

	/**
	 * 获取导入依赖包字符串
	 * @return
	 */
	public List<String> getImportList(){
		List<String> importList = Lists.newArrayList(); // 引用列表
		for (TableColumn column : getColumnList()){
			if (column.getIsNotBaseField() || ("1".equals(column.getIsQuery()) && "between".equals(column.getQueryType())
							&& ("createDate".equals(column.getSimpleJavaField()) || "updateDate".equals(column.getSimpleJavaField())))){
				// 导入类型依赖包， 如果类型中包含“.”，则需要导入引用。
				if (StringUtils.indexOf(column.getJavaType(), ".") != -1 && !importList.contains(column.getJavaType())){
					importList.add(column.getJavaType());
				}
			}
			if (column.getIsNotBaseField()){
				// 导入JSR303、Json等依赖包
				for (String ann : column.getAnnotationList()){
					if (!importList.contains(StringUtils.substringBeforeLast(ann, "("))){
						importList.add(StringUtils.substringBeforeLast(ann, "("));
					}
				}
			}
		}
		// 如果有子表，则需要导入List相关引用
		if (getChildList() != null && getChildList().size() > 0){
			if (!importList.contains("java.util.List")){
				importList.add("java.util.List");
			}
			if (!importList.contains("com.google.common.collect.Lists")){
				importList.add("com.google.common.collect.Lists");
			}
		}
		return importList;
	}
	
	/**
	 * 是否存在父类
	 * @return
	 */
	public Boolean getParentExists(){
		for (TableColumn tableColumn : this.columnList) {
			if("1".equalsIgnoreCase(tableColumn.getIsFk())){
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否存在create_date列
	 * @return
	 */
	public Boolean getCreateDateExists(){
		for (TableColumn c : columnList){
			if ("create_date".equals(c.getName())){
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否存在update_date列
	 * @return
	 */
	public Boolean getUpdateDateExists(){
		for (TableColumn c : columnList){
			if ("update_date".equals(c.getName())){
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否存在del_flag列
	 * @return
	 */
	public Boolean getDictExists(){
		for (TableColumn c : columnList){
			if (StringUtils.isNotBlank(c.getDictType())){
				return true;
			}
		}
		return false;
	}
	/**
	 * 是否存在del_flag列
	 * @return
	 */
	public Boolean getDelFlagExists(){
//		for (TableColumn c : columnList){
//			if ("del_flag".equals(c.getName())){
//				return true;
//			}
//		}
//		return false;
		return true;
	}


//	private String nameLike; 										// 按名称模糊查询
//	public String getNameLike() {
//		return nameLike;
//	}
//	public void setNameLike(String nameLike) {
//		this.nameLike = nameLike;
//	}
}


