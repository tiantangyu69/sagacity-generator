/*******************************************************
 * @author LIZHITAO
 * @date 2013-8-22 下午02:39:31
 * @name XMLParseHelper.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;

/**
 * @author LIZHTIAO
 * 
 */
public class PDMParseHelper {
	/**
	 * @name getTables
	 * @active 解析获得pdm中的所有数据表信息
	 * @state
	 * @type List<Table>
	 * @time 下午02:53:08
	 * @exception/throws
	 * @see
	 * @since
	 * @param doc Dom4j Document对象
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List<Table> getTables(Document doc) {
		List tableList = doc.selectNodes("Model/o:RootObject/c:Children/o:Model/c:Tables/o:Table");// 得到所有的表
		List<Table> list = new ArrayList<Table>();
		for (Object table : tableList) {
			Element pdmtable = (Element) table;
			String tableNameCN = pdmtable.element("Name").getTextTrim();// 表的中文注释
			String tableName = pdmtable.element("Code").getTextTrim();// 表名
			Table tab = new Table();
			tab.setName(tableName);// 设置表名
			tab.setNameCN(tableNameCN);// 设置表名中文注释
			// 获得表中的列信息
			

			Element primarykey = pdmtable.element("PrimaryKey");
			String pkField = "";
			if (primarykey != null) {
				Element pkfields = getPrimaryKeyOfId(doc, primarykey.element("Key").attributeValue("Ref"));
				Element fields = pkfields.element("Key.Columns");
				if (fields != null) {
					List cols = fields.elements("Column");
					for (Object c : cols) {
						pkField += getColumnFieldOfId(doc, ((Element) c).attributeValue("Ref")) + ",";
					}
					if (pkField.length() > 0) {
						pkField = pkField.substring(0, pkField.length() - 1);
					}
				} 
			}
			List<Column> columnList = getColumns(pdmtable.element("Columns"), pkField);
			tab.setColumnList(columnList);// 设置列信息
			list.add(tab);
		}
		return list;
	}
	
	/**
	 * @name getColumns
	 * @active 获取表中的所有列信息
	 * @state
	 * @type List<Column>
	 * @time 下午03:21:52
	 * @exception/throws
	 * @see
	 * @since
	 * @param columns Dom4j Element对象
	 * @return
	 */
	private static List<Column> getColumns(Element columns, String primaryKey){
		if (columns == null) {
			throw new RuntimeException("该表没有列信息！");
		}
		List<String> pkList= new ArrayList<String>();
		if(StringUtils.isNotBlank(primaryKey)){
			String[] pks = primaryKey.split(",");
			pkList = Arrays.asList(pks);
		}
		List<Column> list = new ArrayList<Column>();
		for (Object column : columns.elements()) {
			Column colu = new Column();
			Element pdmcolumn = (Element) column;
			if(pkList.contains(pdmcolumn.element("Code").getTextTrim())){
				colu.setPrimaryKey(true);
			}
			colu.setName(pdmcolumn.element("Code").getTextTrim());
			colu.setType(TypeConvert.getTypeString(pdmcolumn.element("DataType").getTextTrim()));
			colu.setMetaType(pdmcolumn.element("DataType").getTextTrim());
			if (pdmcolumn.element("Length") != null) {
				colu.setLength(Integer.parseInt(pdmcolumn.element("Length").getTextTrim()));
			} else{
				if(TypeConvert.getTypeString(pdmcolumn.element("DataType").getTextTrim()) == "Integer"){
					colu.setLength(11);
				} else{
					colu.setLength(0);
				}
			}
			colu.setNameCN(pdmcolumn.element("Name").getTextTrim());
			if (pdmcolumn.element("Mandatory") != null && "1".equals(pdmcolumn.element("Mandatory").getTextTrim())) {
				colu.setRequired(true);
			} else{
				colu.setRequired(false);
			}
			list.add(colu);
		}
		return list;
	}
	@SuppressWarnings("rawtypes")
	private static Element getPrimaryKeyOfId(Document doc, String id) {
		List l = doc.selectNodes("Model/o:RootObject/c:Children/o:Model/c:Tables/o:Table/c:Keys/o:Key");
		for (Object obj : l) {
			Element e = (Element) obj;
			if (id.equals(e.attributeValue("Id"))) {
				return e;
			}
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	private static String getColumnFieldOfId(Document doc, String id) {
		List l = doc.selectNodes("Model/o:RootObject/c:Children/o:Model/c:Tables/o:Table/c:Columns/o:Column");
		for (Object obj : l) {
			Element e = (Element) obj;
			if (id.equals(e.attributeValue("Id"))) {
				return e.element("Code").getTextTrim();
			}
		}
		return null;
	}
}
