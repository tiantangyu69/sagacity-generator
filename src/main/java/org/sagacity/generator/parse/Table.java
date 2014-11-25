/*******************************************************
 * @author LIZHITAO
 * @date 2013-8-22 下午02:30:20
 * @name Table.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.parse;

import java.util.List;

/**
 * @author LIZHITAO
 * 
 */
public class Table {
	// 表名
	private String name;
	// 表名中文
	private String nameCN;

	// 表中的列信息
	private List<Column> columnList;

	public List<Column> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<Column> columnList) {
		this.columnList = columnList;
	}

	public String getNameCN() {
		return nameCN;
	}

	public void setNameCN(String nameCN) {
		this.nameCN = nameCN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Table other = (Table) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
