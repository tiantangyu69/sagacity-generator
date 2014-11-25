/*******************************************************
 * @author LIZHITAO
 * @date 2013-8-27 上午10:16:43
 * @name PropertyUtil.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.sagacity.util.ProjectProperty;

/**
 * @author LIZHITAO 属性文件读取工具类
 * 
 */
public class JDBCPropertyUtils {
	/**
	 * @name loadProperty
	 * @active 根据文件名称加载属性文件
	 * @state
	 * @type Properties
	 * @time 上午10:39:06
	 * @exception/throws
	 * @see
	 * @since
	 * @param fileName
	 *            文件名称
	 * @return
	 */
	public Properties loadProperty(String fileName) {
		InputStream in;
		try {
			in = new BufferedInputStream(new FileInputStream(fileName));
			Properties p = new Properties();
			p.load(in);
			in.close();
			return p;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return null;
	}

	/**
	 * @name getJDBCProperty
	 * @active 获得jdbc属性文件项目配置信息
	 * @state
	 * @type JDBCProperty
	 * @time 上午10:39:35
	 * @exception/throws
	 * @see
	 * @since
	 * @return
	 */
	public JDBCFile getJDBCProperty() {
		JDBCPropertyUtils u = new JDBCPropertyUtils();
		Properties p = u.loadProperty(ProjectProperty.RESOURCES_PATH
				+ "jdbc.properties");
		JDBCFile jdbc = new JDBCFile();
		if (null != p) {
			jdbc.setDriver(p.getProperty("jdbc.driverClassName"));
			jdbc.setUrl(p.getProperty("jdbc.url"));
			jdbc.setUsername(p.getProperty("jdbc.username"));
			jdbc.setPassword(p.getProperty("jdbc.password"));
		}
		return jdbc;
	}

	/**
	 * 设置数据源
	 * @param 
	 * @name setJDBCProperty
	 * @active
	 * @state
	 * @type void
	 * @time 下午3:26:44
	 * @exception/throws
	 * @see
	 * @since
	 * @param settings 格式为 xxxx$xxxx,yyyy$yyyy,zzzz$zzzz
	 */
	public void setJDBCProperty(String settings) {
		JDBCPropertyUtils u = new JDBCPropertyUtils();
		Properties p = u.loadProperty(ProjectProperty.RESOURCES_PATH
				+ "jdbc.properties");
		String[] setting = settings.split(",");
		for (String s : setting) {
			String[] p2 = s.split("\\$");
			p.setProperty(p2[0], p2[1]);
		}
		FileOutputStream out;
		try {
			out = FileUtils.openOutputStream(new File(ProjectProperty.RESOURCES_PATH + "jdbc.properties"));
			p.store(out, null);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
