/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-24 下午5:49:44
 * @name JSPGenerator.java
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
import org.apache.commons.lang.StringUtils;
import org.sagacity.generator.config.Config;
import org.sagacity.generator.parse.Table;
import org.sagacity.util.ProjectProperty;

import freemarker.template.Template;

/**
 * @author LIZHITAO JSP生成器
 */
public class JSPGenerator extends Generator {

	/**
	 * @param
	 * @name process
	 * @active
	 * @state
	 * @type JSPGenerator
	 * @time 下午5:49:44
	 * @see org.sagacity.generator.process.Generator#process(java.util.List,
	 *      java.lang.String)
	 */
	@Override
	public void process(List<Table> list, String tableName) {
		Map<String, Object> root = new HashMap<String, Object>();
		for (Table t : list) {
			if (null != tableName) {
				Table t1 = new Table();
				t1.setName(tableName);
				if (!t.equals(t1)) {
					continue;
				}
			}
			root.put("entityName", t.getName());
			root.put("entityNameCN", t.getNameCN());
			root.put("columnList", t.getColumnList());
			try {
				/* 生成管理页面 */
				String fileName = "manager.jsp";
				Template template = getConfiguration().getTemplate(
						"jsp_manager.ftl");
				buildTemplate(root, fileName, Config.MANAGE_JSP_PATH
						+ StringUtils.uncapitalize(t.getName()) + "/", template);
				/* 生成添加页面 */
				fileName = "add.jsp";
				template = getConfiguration().getTemplate("jsp_add.ftl");
				buildTemplate(root, fileName, Config.MANAGE_JSP_PATH
						+ StringUtils.uncapitalize(t.getName()) + "/", template);
				/* 生成修改页面 */
				fileName = "edit.jsp";
				template = getConfiguration().getTemplate("jsp_edit.ftl");
				buildTemplate(root, fileName, Config.MANAGE_JSP_PATH
						+ StringUtils.uncapitalize(t.getName()) + "/", template);
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
	 * @type JSPGenerator
	 * @time 下午5:49:44
	 * @see org.sagacity.generator.process.Generator#undoProcess(java.util.List,
	 *      java.lang.String)
	 */
	@Override
	public void undoProcess(List<Table> list, String tableName) {
		if (null != tableName) {
			try {
				if (new File(Config.MANAGE_JSP_PATH
						+ StringUtils.uncapitalize(tableName) + "/").exists()) {
					if (new File(Config.MANAGE_JSP_PATH
							+ StringUtils.uncapitalize(tableName)
							+ "/add.jsp").exists()) {
						FileUtils.forceDelete(new File(
								Config.MANAGE_JSP_PATH
										+ StringUtils.uncapitalize(tableName) + "/add.jsp"));
					}
					if (new File(Config.MANAGE_JSP_PATH
							+ StringUtils.uncapitalize(tableName)
							+ "/edit.jsp").exists()) {
						FileUtils.forceDelete(new File(
								Config.MANAGE_JSP_PATH
										+ StringUtils.uncapitalize(tableName) + "/edit.jsp"));
					}
					if (new File(Config.MANAGE_JSP_PATH
							+ StringUtils.uncapitalize(tableName)
							+ "/manager.jsp").exists()) {
						FileUtils.forceDelete(new File(
								Config.MANAGE_JSP_PATH
										+ StringUtils.uncapitalize(tableName)
										+ "/manager.jsp"));
					}
					FileUtils.deleteDirectory(new File(Config.MANAGE_JSP_PATH
							+ StringUtils.uncapitalize(tableName) + "/"));
				}
				if (new File(Config.MANAGE_JSP_PATH).exists()
						&& new File(Config.MANAGE_JSP_PATH).listFiles().length == 0) {
					FileUtils.deleteDirectory(new File(Config.MANAGE_JSP_PATH));
				}
				if (new File(ProjectProperty.PROJECT_PATH
						+ "/WebRoot/WEB-INF/jsp/").exists()
						&& new File(ProjectProperty.PROJECT_PATH
								+ "/WebRoot/WEB-INF/jsp/").listFiles().length == 0) {
					FileUtils.deleteDirectory(new File(
							ProjectProperty.PROJECT_PATH
									+ "/WebRoot/WEB-INF/jsp/"));
				}
				if (new File(ProjectProperty.PROJECT_PATH + "/WebRoot/WEB-INF/")
						.exists()
						&& new File(ProjectProperty.PROJECT_PATH
								+ "/WebRoot/WEB-INF/").listFiles().length == 0) {
					FileUtils
							.deleteDirectory(new File(
									ProjectProperty.PROJECT_PATH
											+ "/WebRoot/WEB-INF/"));
				}
				if (new File(ProjectProperty.PROJECT_PATH + "/WebRoot/")
						.exists()
						&& new File(ProjectProperty.PROJECT_PATH + "/WebRoot/")
								.listFiles().length == 0) {
					FileUtils.deleteDirectory(new File(
							ProjectProperty.PROJECT_PATH + "/WebRoot/"));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			for (Table t : list) {
				try {
					if (new File(Config.MANAGE_JSP_PATH
							+ StringUtils.uncapitalize(t.getName()) + "/")
							.exists()) {
						if (new File(Config.MANAGE_JSP_PATH
								+ StringUtils.uncapitalize(t.getName())
								+ "/add.jsp").exists()) {
							FileUtils.forceDelete(new File(
									Config.MANAGE_JSP_PATH
											+ StringUtils.uncapitalize(t
													.getName()) + "/add.jsp"));
						}
						if (new File(Config.MANAGE_JSP_PATH
								+ StringUtils.uncapitalize(t.getName())
								+ "/edit.jsp").exists()) {
							FileUtils.forceDelete(new File(
									Config.MANAGE_JSP_PATH
											+ StringUtils.uncapitalize(t
													.getName()) + "/edit.jsp"));
						}
						if (new File(Config.MANAGE_JSP_PATH
								+ StringUtils.uncapitalize(t.getName())
								+ "/manager.jsp").exists()) {
							FileUtils.forceDelete(new File(
									Config.MANAGE_JSP_PATH
											+ StringUtils.uncapitalize(t
													.getName())
											+ "/manager.jsp"));
						}
						FileUtils.deleteDirectory(new File(Config.MANAGE_JSP_PATH
								+ StringUtils.uncapitalize(t.getName()) + "/"));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (new File(Config.MANAGE_JSP_PATH).exists()
					&& new File(Config.MANAGE_JSP_PATH).listFiles().length == 0) {
				try {
					FileUtils.deleteDirectory(new File(Config.MANAGE_JSP_PATH));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (new File(ProjectProperty.PROJECT_PATH + "/WebRoot/WEB-INF/jsp/")
					.exists()
					&& new File(ProjectProperty.PROJECT_PATH
							+ "/WebRoot/WEB-INF/jsp/").listFiles().length == 0) {
				try {
					FileUtils.deleteDirectory(new File(
							ProjectProperty.PROJECT_PATH
									+ "/WebRoot/WEB-INF/jsp/"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (new File(ProjectProperty.PROJECT_PATH + "/WebRoot/WEB-INF/")
					.exists()
					&& new File(ProjectProperty.PROJECT_PATH
							+ "/WebRoot/WEB-INF/").listFiles().length == 0) {
				try {
					FileUtils
							.deleteDirectory(new File(
									ProjectProperty.PROJECT_PATH
											+ "/WebRoot/WEB-INF/"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (new File(ProjectProperty.PROJECT_PATH + "/WebRoot/").exists()
					&& new File(ProjectProperty.PROJECT_PATH + "/WebRoot/")
							.listFiles().length == 0) {
				try {
					FileUtils.deleteDirectory(new File(
							ProjectProperty.PROJECT_PATH + "/WebRoot/"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
