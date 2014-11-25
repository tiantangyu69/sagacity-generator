/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-24 下午5:34:37
 * @name DaoImplGenerator.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.process;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.sagacity.generator.config.Config;
import org.sagacity.generator.parse.Table;
import org.sagacity.util.ProjectProperty;

import freemarker.template.Template;

/**
 * @author LIZHITAO
 * daoImpl生成器
 */
public class DaoImplGenerator extends Generator {

	/**
	 * @param 
	 * @name process
	 * @active
	 * @state
	 * @type DaoImplGenerator
	 * @time 下午5:34:37
	 * @see org.sagacity.generator.process.Generator#process(java.util.List, java.lang.String)
	 */
	@Override
	public void process(List<Table> list, String tableName) {
		Map<String, Object> root = new HashMap<String, Object>();
		for(Table t : list){
			if(null != tableName){
				Table t1 = new Table();
				t1.setName(tableName);
				if(!t.equals(t1)){
					continue;
				}
			}
			root.put("package", Config.DEFAULT_DAOIMPL_PACKAGE);
			root.put("entityName", t.getName());
			root.put("entityNameCN", t.getNameCN());
			String fileName = t.getName() + "DaoImpl.java";
			try {
				Template template = getConfiguration().getTemplate("daoImpl.ftl");
				buildTemplate(root, fileName, Config.DAOIMPL_PATH, template);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * @param 
	 * @name undoProcess
	 * @active
	 * @state
	 * @type DaoImplGenerator
	 * @time 下午5:34:37
	 * @see org.sagacity.generator.process.Generator#undoProcess(java.util.List, java.lang.String)
	 */
	@Override
	public void undoProcess(List<Table> list, String tableName) {
		if (null != tableName) {
			try {
				if (new File(Config.DAOIMPL_PATH + tableName
						+ "DaoImpl.java").exists()) {
					FileUtils.forceDelete(new File(Config.DAOIMPL_PATH
							+ tableName + "DaoImpl.java"));
				}
				if (new File(Config.DAOIMPL_PATH).exists()
						&& new File(Config.DAOIMPL_PATH).listFiles().length == 0) {
					FileUtils.deleteDirectory(new File(Config.DAOIMPL_PATH));
				}
				if (new File(ProjectProperty.PROJECT_PATH
						+ "/src/main/java/org/jgenerator/").exists()
						&& new File(ProjectProperty.PROJECT_PATH
								+ "/src/main/java/org/jgenerator/").listFiles().length == 0) {
					FileUtils.deleteDirectory(new File(
							ProjectProperty.PROJECT_PATH
									+ "/src/main/java/org/jgenerator/"));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			for (Table t : list) {
				try {
					if (new File(Config.DAOIMPL_PATH + t.getName()
							+ "DaoImpl.java").exists()) {
						FileUtils.forceDelete(new File(Config.DAOIMPL_PATH
								+ t.getName() + "DaoImpl.java"));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (new File(Config.DAOIMPL_PATH).exists()
					&& new File(Config.DAOIMPL_PATH).listFiles().length == 0) {
				try {
					FileUtils.deleteDirectory(new File(Config.DAOIMPL_PATH));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (new File(ProjectProperty.PROJECT_PATH
					+ "/src/main/java/org/jgenerator/").exists()
					&& new File(ProjectProperty.PROJECT_PATH
							+ "/src/main/java/org/jgenerator/").listFiles().length == 0) {
				try {
					FileUtils.deleteDirectory(new File(
							ProjectProperty.PROJECT_PATH
									+ "/src/main/java/org/jgenerator/"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
