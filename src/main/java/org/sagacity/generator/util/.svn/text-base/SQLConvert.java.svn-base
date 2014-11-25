/**
 * 
 */
package org.sagacity.generator.util;

import org.sagacity.generator.parse.Table;

/**
 * @author LIZHITAO SQL转换器
 */
public class SQLConvert {
	public static String convert(Table table) {
		if (null != table && null != table.getColumnList()
				&& table.getColumnList().size() > 0) {
			StringBuffer sb = new StringBuffer();
			sb.append("CREATE TABLE " + table.getName() + "(");
			for (int i = 0; i < table.getColumnList().size(); i++) {
				sb.append(table.getColumnList().get(i).getName() + " ");
				sb.append(table.getColumnList().get(i).getMetaType() + " ");
				if (table.getColumnList().get(i).isRequired()) {
					sb.append(" NOT NULL ");
				}
				if (table.getColumnList().get(i).isPrimaryKey()) {
					sb.append(" PRIMARY KEY AUTO_INCREMENT ");
				}
				if (i != table.getColumnList().size() - 1) {
					sb.append(",");
				}
			}
			sb.append(")ENGINE=InnoDB DEFAULT CHARSET=utf8;");
			return sb.toString();
		}
		return "";
	}
}
