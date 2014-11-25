/*******************************************************
 * @author LIZHITAO
 * @date 2013-9-22 下午1:30:00
 * @name TabbedPaneTest.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.client;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author LIZHITAO
 * 
 */
public class MainFrame extends JFrame {
	private JTabbedPane tabbedPane;
	public static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width - 100;// 屏幕最大宽度
	public static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height - 50;// 屏幕最大高度
	public static final int DEFAULT_WIDTH = 980;// 屏幕最大宽度
	public static final int DEFAULT_HEIGHT = 720;// 屏幕最大高度

	/**
	 * @type long
	 * @field serialVersionUID
	 * @state
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		this.setTitle("代码、数据表生成器");
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		tabbedPane = new JTabbedPane();

		tabbedPane.addTab("代码生成", new GeneratorPanel());
		tabbedPane.addTab("生成模板", new TemplatePanel());// 代码生成模板
		tabbedPane.addTab("数据库配置", new DataSourcePanel());// 数据源配置面板
		tabbedPane.addTab("生成配置", new ConfigPanel());// 添加生成配置面板
		tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		this.add(tabbedPane, "Center");
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
			}
		});
	}
}
