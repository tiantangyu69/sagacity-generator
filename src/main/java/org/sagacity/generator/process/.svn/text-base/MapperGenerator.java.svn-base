/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-24 下午5:47:12
 * @name MapperGenerator.java
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

import freemarker.template.Template;

/**
 * @author LIZHITAO
 * MAPPER文件生成器
 */
public class MapperGenerator extends Generator {

	/**
	 * @param 
	 * @name process
	 * @active
	 * @state
	 * @type MapperGenerator
	 * @time 下午5:47:12
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
			root.put("className", Config.DEFAULT_MODEL_PACKAGE + "." + t.getName());
			String fileName = t.getName() + "Mapper.xml";
			try {
				Template template = getConfiguration().getTemplate("mapper.ftl");
				buildTemplate(root, fileName, Config.MAPPER_PATH, template);
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
	 * @type MapperGenerator
	 * @time 下午5:47:12
	 * @see org.sagacity.generator.process.Generator#undoProcess(java.util.List, java.lang.String)
	 */
	@Override
	public void undoProcess(List<Table> list, String tableName) {
		if (null != tableName) {
			try {
				if (new File(Config.MAPPER_PATH + tableName + "Mapper.xml").exists()) {
					FileUtils.forceDelete(new File(Config.MAPPER_PATH + tableName
							+ "Mapper.xml"));
				}
				if (new File(Config.MAPPER_PATH).exists()
						&& new File(Config.MAPPER_PATH).listFiles().length == 0) {
					FileUtils.deleteDirectory(new File(Config.MAPPER_PATH));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			for (Table t : list) {
				try {
					if (new File(Config.MAPPER_PATH + t.getName() + "Mapper.xml").exists()) {
						FileUtils.forceDelete(new File(Config.MAPPER_PATH
								+ t.getName() + "Mapper.xml"));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (new File(Config.MAPPER_PATH).exists()
					&& new File(Config.MAPPER_PATH).listFiles().length == 0) {
				try {
					FileUtils.deleteDirectory(new File(Config.MAPPER_PATH));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
