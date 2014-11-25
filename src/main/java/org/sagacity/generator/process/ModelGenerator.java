/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-24 下午5:37:19
 * @name ModelGenerator.java
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
 * model生成器
 */
public class ModelGenerator extends Generator {

	/**
	 * @param 
	 * @name process
	 * @active
	 * @state
	 * @type ModelGenerator
	 * @time 下午5:37:19
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
			root.put("package", Config.DEFAULT_MODEL_PACKAGE);
			root.put("entityName", t.getName());
			root.put("entityNameCN", t.getNameCN());
			root.put("columnList", t.getColumnList());
			String fileName = t.getName() + ".java";
			try {
				Template template = getConfiguration().getTemplate("model.ftl");
				buildTemplate(root, fileName, Config.MODEL_PATH, template);
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
	 * @type ModelGenerator
	 * @time 下午5:37:19
	 * @see org.sagacity.generator.process.Generator#undoProcess(java.util.List, java.lang.String)
	 */
	@Override
	public void undoProcess(List<Table> list, String tableName) {
		if (null != tableName) {
			try {
				if (new File(Config.MODEL_PATH + tableName
						+ ".java").exists()) {
					FileUtils.forceDelete(new File(Config.MODEL_PATH
							+ tableName + ".java"));
				}
				if (new File(Config.MODEL_PATH).exists()
						&& new File(Config.MODEL_PATH).listFiles().length == 0) {
					FileUtils.deleteDirectory(new File(Config.MODEL_PATH));
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
					if (new File(Config.MODEL_PATH + t.getName()
							+ ".java").exists()) {
						FileUtils.forceDelete(new File(Config.MODEL_PATH
								+ t.getName() + ".java"));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (new File(Config.MODEL_PATH).exists()
					&& new File(Config.MODEL_PATH).listFiles().length == 0) {
				try {
					FileUtils.deleteDirectory(new File(Config.MODEL_PATH));
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
