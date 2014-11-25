/**
 * 
 */
package org.sagacity.generator.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * @author LIZHITAO 自动生成后台菜单
 */
public class AutoMenu {
	/**
	 * 将js文件引用到公用的js文件中
	 * 
	 * @param jsName
	 */
	public void addMenu(String menuName, String tableName) {
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			Connection conn = dbc.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ManageMenu");
			List<String> list = new ArrayList<String>();
			while (rs.next()) {
				list.add(rs.getString("url"));
			}
			rs.close();
			if (list.size() > 0) {
				if (!list.contains("manage/"
						+ StringUtils.uncapitalize(tableName)
						+ "/manager.action")) {
					String insertSQL = "INSERT INTO ManageMenu(name, type, url, parentId) VALUES('"
							+ menuName
							+ "', 1, 'manage/"
							+ StringUtils.uncapitalize(tableName)
							+ "/manager.action', 67)";
					// 不包含改菜单则添加该菜单
					stmt.execute(insertSQL);
				}
			} else {
				String insertSQL = "INSERT INTO ManageMenu(name, type, url, parentId) VALUES('"
						+ menuName
						+ "', 1, 'manage/"
						+ StringUtils.uncapitalize(tableName)
						+ "/manager.action', 67)";
				// 不包含改菜单则添加该菜单
				stmt.execute(insertSQL);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbc.close();
	}
}
