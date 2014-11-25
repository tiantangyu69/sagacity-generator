/*******************************************************
 * @author LIZHITAO
 * @date 2013-8-22 上午09:06:46
 * @name Generator.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.process;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import org.sagacity.generator.config.Config;
import org.sagacity.generator.parse.Table;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author LIZHITAO
 * 
 */
public abstract class Generator {
	private Configuration cfg;
	
	public Generator() {
		cfg = new Configuration();
		try {
			cfg.setDirectoryForTemplateLoading(new File(Config.TEMPLATE_PATH + File.separator
					+ Config.TEMPLATE + File.separator));// 加载freemarker模板
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Configuration getConfiguration(){
		return cfg;
	}

	/**
	 * 根据模板生成文件
	 * @param 
	 * @name buildTemplate
	 * @active
	 * @state
	 * @type void
	 * @time 下午5:42:43
	 * @exception/throws
	 * @see
	 * @since
	 * @param root
	 * @param fileName
	 * @param realSavePath
	 * @param template
	 */
	public void buildTemplate(Map<String, Object> root, String fileName, String realSavePath,Template template) {
		String realFileName = realSavePath + fileName;

		File newsDir = new File(realSavePath);
		if (!newsDir.exists()) {
			newsDir.mkdirs();
		}
		try {
			Writer out = new OutputStreamWriter(new FileOutputStream(
					realFileName), "UTF-8");
			template.process(root, out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成代码
	 * @param 
	 * @name process
	 * @active
	 * @state
	 * @type void
	 * @time 下午5:17:23
	 * @exception/throws
	 * @see
	 * @since
	 * @param list
	 * @param tableName
	 */
	public abstract void process(List<Table> list, String tableName);
	
	/**
	 * 撤销生成代码
	 * @param 
	 * @name undoProcess
	 * @active
	 * @state
	 * @type void
	 * @time 下午5:17:32
	 * @exception/throws
	 * @see
	 * @since
	 * @param list
	 * @param tableName
	 */
	public abstract void undoProcess(List<Table> list, String tableName);
}
