/*******************************************************
 * @author LIZHITAO
 * @date 2013-9-22 下午1:30:00
 * @name TabbedPaneTest.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.client;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.commons.lang.StringUtils;
import org.sagacity.generator.config.Config;
import org.sagacity.util.ClassPath;

/**
 * @author LIZHITAO
 * 
 */
public class TemplatePanel extends JPanel {
	JScrollPane scrollPane = new JScrollPane();// 创建文本框面板
	JScrollPane treePane = new JScrollPane();// 创建树面板
	JTextArea textArea = new JTextArea();// 创建文本域
	private JButton saveButton = new JButton("保存模板");
	/**
	 * @type long
	 * @field serialVersionUID
	 * @state
	 */
	private static final long serialVersionUID = 1L;

	public TemplatePanel() {
		this.setBackground(Color.WHITE);
		this.setLayout(null);

		scrollPane.setBounds(210, 10, MainFrame.DEFAULT_WIDTH - 230, 600);

		textArea.setLineWrap(true); // 设置文本域自动换行
		scrollPane.setViewportView(textArea);// 应用文本域
		this.add(scrollPane);// 应用面板

		// 创建没有父节点和子节点、但允许有子节点的树节点，并使用指定的用户对象对它进行初始化。
		// public DefaultMutableTreeNode(Object userObject)
		File file = new File(Config.TEMPLATE_PATH + Config.TEMPLATE);
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("代码生成模板");
		for (File f : file.listFiles()) {
			if (StringUtils.isNotEmpty(f.getName())
					&& f.getName().endsWith(".ftl")) {
				node1.add(new DefaultMutableTreeNode(f.getName()));
			}
		}
		final JTree tree = new JTree(node1);

		// 添加选择事件
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
						.getLastSelectedPathComponent();

				if (node == null)
					return;
				Object object = node.getUserObject();
				if (node.isLeaf()) {
					File f1 = new File(Config.TEMPLATE_PATH + Config.TEMPLATE
							+ File.separator + object.toString());
					try {
						InputStream is = new FileInputStream(f1);
						byte[] cs = new byte[(int) f1.length()];
						is.read(cs);
						textArea.setText(new String(cs));
						is.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				}

			}
		});

		treePane.setBounds(10, 10, 190, 600);
		this.add(treePane);
		treePane.setViewportView(tree);

		saveButton.setBounds(10, 620, 120, 25);
		this.add(saveButton);

		saveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
						.getLastSelectedPathComponent();

				if (node == null || !node.isLeaf()) {
					JOptionPane.showMessageDialog(null, "未选择需要修改的模板！");
					return;
				}
				Object object = node.getUserObject();
				if (node.isLeaf()) {
					int result = JOptionPane.showConfirmDialog(null,
							"您确定要修改该模板吗？", "提示", JOptionPane.YES_NO_OPTION);
					if (result == 0) {
						String ftlName = String.valueOf(object);// 取得选中的节点的模板名称
						File f1 = new File(Config.TEMPLATE_PATH
								+ Config.TEMPLATE + File.separator + ftlName);
						File f2 = new File(ClassPath.classPath()
								+ File.separator + "/template/"
								+ Config.TEMPLATE + File.separator + ftlName);
						try {
							if (f1.exists()) {
								PrintWriter pw = new PrintWriter(f1);
								pw.print(textArea.getText());
								pw.flush();
								pw.close();
							}
							if (f2.exists()) {
								PrintWriter pw2 = new PrintWriter(f2);
								pw2.print(textArea.getText());

								pw2.flush();
								pw2.close();
							}
							if (!f1.exists() && !f2.exists()) {
								JOptionPane.showMessageDialog(null, "未找到该模板！");
								return;
							}
							JOptionPane.showMessageDialog(null, "模板保存成功！");
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
	}
}