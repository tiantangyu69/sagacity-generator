/**
 * 
 */
package org.sagacity.generator.util;

import java.sql.SQLException;
import java.util.List;

import org.sagacity.generator.parse.Table;

/**
 * @author LIZHITAO
 * 
 */
public class DataBaseHelper {
	/**
	 * 删除并重新创建该表
	 * 
	 * @param table
	 */
	public static void dropAndCreateTable(Table table) {
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			dbc.getConnection()
					.createStatement()
					.executeUpdate(
							"DROP TABLE IF EXISTS " + table.getName() + ";");
			dbc.getConnection().createStatement()
					.executeUpdate(SQLConvert.convert(table));
			System.out.println("=========" + table.getName() + "数据表创建成功！==========");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbc.close();
	}

	/**
	 * 删除并重新创建该表
	 * 
	 * @param table
	 */
	public static void dropAndCreateTable(List<Table> tables) {
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			for (Table table : tables) {
				dbc.getConnection()
						.createStatement()
						.executeUpdate(
								"DROP TABLE IF EXISTS " + table.getName() + ";");
				dbc.getConnection().createStatement()
						.executeUpdate(SQLConvert.convert(table));
				System.out.println("=========" + table.getName() + "数据表创建成功！==========");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbc.close();
	}
	
	/**
	 * 删除数据表
	 * @param 
	 * @name dropTable
	 * @active
	 * @state
	 * @type void
	 * @time 上午10:42:45
	 * @exception/throws
	 * @see
	 * @since
	 * @param table
	 */
	public static void dropTable(Table table){
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			dbc.getConnection()
					.createStatement()
					.executeUpdate(
							"DROP TABLE IF EXISTS " + table.getName() + ";");
			System.out.println("=========" + table.getName() + "数据表删除成功！==========");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbc.close();
	}

	/**
	 * 批量删除数据表
	 * @param 
	 * @name dropTable
	 * @active
	 * @state
	 * @type void
	 * @time 上午10:44:10
	 * @exception/throws
	 * @see
	 * @since
	 * @param tables
	 */
	public static void dropTable(List<Table> tables){
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			for (Table table : tables) {
				dbc.getConnection()
						.createStatement()
						.executeUpdate(
								"DROP TABLE IF EXISTS " + table.getName() + ";");
				System.out.println("=========" + table.getName() + "数据表删除成功！==========");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbc.close();
	}
	
	/**
	 * 执行sql语句
	 * @param 
	 * @name execute
	 * @active
	 * @state
	 * @type void
	 * @time 上午10:46:45
	 * @exception/throws
	 * @see
	 * @since
	 * @param sql
	 */
	public static void execute(String sql){
		DataBaseConnection dbc = new DataBaseConnection();
		try {
			dbc.getConnection()
					.createStatement()
					.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbc.close();
	}
}
