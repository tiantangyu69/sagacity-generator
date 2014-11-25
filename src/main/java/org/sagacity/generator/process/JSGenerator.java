/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-24 下午5:43:36
 * @name JSGenerator.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.process;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author LIZHITAO JS生成器
 */
public class JSGenerator extends Generator {

	/**
	 * @param
	 * @name process
	 * @active
	 * @state
	 * @type JSGenerator
	 * @time 下午5:43:36
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
			String fileName = StringUtils.uncapitalize(t.getName()) + ".js";
			try {
				Template template = getConfiguration().getTemplate("js.ftl");
				buildTemplate(root, fileName, Config.JS_PATH, template);
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
	 * @type JSGenerator
	 * @time 下午5:43:36
	 * @see org.sagacity.generator.process.Generator#undoProcess(java.util.List,
	 *      java.lang.String)
	 */
	@Override
	public void undoProcess(List<Table> list, String tableName) {
		if (null != tableName) {
			try {
				if (new File(Config.JS_PATH + tableName + ".js").exists()) {
					FileUtils.forceDelete(new File(Config.JS_PATH + tableName
							+ ".js"));
				}
				if (new File(Config.JS_PATH).exists()
						&& new File(Config.JS_PATH).listFiles().length == 0) {
					FileUtils.deleteDirectory(new File(Config.JS_PATH));
				}
				if (new File(ProjectProperty.PROJECT_PATH
						+ "/WebRoot/static/manage/").exists()
						&& new File(ProjectProperty.PROJECT_PATH
								+ "/WebRoot/static/manage/").listFiles().length == 0) {
					FileUtils.deleteDirectory(new File(
							ProjectProperty.PROJECT_PATH
									+ "/WebRoot/static/manage/"));
				}
				if (new File(ProjectProperty.PROJECT_PATH + "/WebRoot/static/")
						.exists()
						&& new File(ProjectProperty.PROJECT_PATH
								+ "/WebRoot/static/").listFiles().length == 0) {
					FileUtils.deleteDirectory(new File(
							ProjectProperty.PROJECT_PATH + "/WebRoot/static/"));
				}
				if (new File(ProjectProperty.PROJECT_PATH + "/WebRoot/")
						.exists()
						&& new File(ProjectProperty.PROJECT_PATH + "/WebRoot/")
								.listFiles().length == 0) {
					FileUtils.deleteDirectory(new File(
							ProjectProperty.PROJECT_PATH + "/WebRoot/"));
				}

				if (new File(Config.MANAGE_JSP_PATH + "js.jsp").exists()) {
					File file = new File(Config.MANAGE_JSP_PATH + "js.jsp");
					FileInputStream fis = new FileInputStream(file);
					byte[] b = new byte[(int) file.length()];
					fis.read(b);
					String str = new String(b);
					str = StringUtils.replace(str,
							"\n    <script type=\"text/javascript\" src=\"${basePath}static/manage/js/"
									+ StringUtils.uncapitalize(tableName)
									+ ".js\"></script>", "");
					fis.close();

					PrintWriter writer = new PrintWriter(file);
					writer.print(str);
					writer.flush();
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			for (Table t : list) {
				try {
					if (new File(Config.JS_PATH + t.getName() + ".js").exists()) {
						FileUtils.forceDelete(new File(Config.JS_PATH
								+ t.getName() + ".js"));
					}

					if (new File(Config.MANAGE_JSP_PATH + "js.jsp").exists()) {
						File file = new File(Config.MANAGE_JSP_PATH + "js.jsp");
						FileInputStream fis = new FileInputStream(file);
						byte[] b = new byte[(int) file.length()];
						fis.read(b);
						String str = new String(b);
						str = StringUtils.replace(str,
								"\n    <script type=\"text/javascript\" src=\"${basePath}static/manage/js/"
										+ StringUtils.uncapitalize(tableName)
										+ ".js\"></script>", "");
						fis.close();

						PrintWriter writer = new PrintWriter(file);
						writer.print(str);
						writer.flush();
						writer.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (new File(Config.JS_PATH).exists()
					&& new File(Config.JS_PATH).listFiles().length == 0) {
				try {
					FileUtils.deleteDirectory(new File(Config.JS_PATH));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (new File(ProjectProperty.PROJECT_PATH
					+ "/WebRoot/static/manage/").exists()
					&& new File(ProjectProperty.PROJECT_PATH
							+ "/WebRoot/static/manage/").listFiles().length == 0) {
				try {
					FileUtils.deleteDirectory(new File(
							ProjectProperty.PROJECT_PATH
									+ "/WebRoot/static/manage/"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (new File(ProjectProperty.PROJECT_PATH + "/WebRoot/static/")
					.exists()
					&& new File(ProjectProperty.PROJECT_PATH
							+ "/WebRoot/static/").listFiles().length == 0) {
				try {
					FileUtils.deleteDirectory(new File(
							ProjectProperty.PROJECT_PATH + "/WebRoot/static/"));
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
