/**
 * 
 */
package org.sagacity.generator.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.StringUtils;
import org.sagacity.util.ProjectProperty;

/**
 * @author LIZHITAO 将js自动引用到项目中
 */
public class RefJS {
	/**
	 * 将js文件引用到公用的js文件中
	 * 
	 * @param jsName
	 */
	public void refManageJS(String jsName) {
		String jsPath = ProjectProperty.PROJECT_PATH
				+ "/WebRoot/WEB-INF/jsp/manage/js.jsp";
		File file = new File(jsPath);
		if (file.exists()) {// 文件存在则在文件中追加js的引用
			try {
				InputStream is = new FileInputStream(file);
				byte[] cs = new byte[(int) file.length()];
				is.read(cs);
				is.close();
				if (!StringUtils.contains(new String(cs), "/manage/js/"
						+ StringUtils.uncapitalize(jsName) + ".js")) {
					FileWriter fw = new FileWriter(jsPath, true);
					fw.write("\n    <script type=\"text/javascript\" src=\"${basePath}static/manage/js/"
							+ StringUtils.uncapitalize(jsName)
							+ ".js\"></script>");
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out
					.println("====================js 文件不存在=========================");
		}
	}
}
