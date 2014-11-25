package org.sagacity.generator.util;

import java.sql.*;
/**
 * 
 * @author LIZHITAO
 * 数据库连接类
 */
public class DataBaseConnection {
	private Connection conn = null;

	public DataBaseConnection() {
		final JDBCPropertyUtils util = new JDBCPropertyUtils();
		try {
			Class.forName(util.getJDBCProperty().getDriver());
			conn = DriverManager.getConnection(util.getJDBCProperty().getUrl(),
					util.getJDBCProperty().getUsername(), util
							.getJDBCProperty().getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return this.conn;
	}

	public void close() {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (Exception e) {
			}
		}
	}
}
