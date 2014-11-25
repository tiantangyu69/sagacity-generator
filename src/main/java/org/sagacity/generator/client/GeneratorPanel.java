/*******************************************************
 * @author LIZHITAO
 * @date 2013-9-6 下午3:22:50
 * @name Generator.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.client;

import java.awt.Color;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang.StringUtils;
import org.sagacity.generator.parse.Column;
import org.sagacity.generator.parse.PDMParse;
import org.sagacity.generator.parse.Table;
import org.sagacity.generator.process.GeneratorType;
import org.sagacity.generator.process.Run;
import org.sagacity.generator.util.AutoMenu;
import org.sagacity.generator.util.DataBaseHelper;
import org.sagacity.generator.util.RefJS;
import org.sagacity.util.ProjectProperty;

/**
 * @author LIZHITAO 代码生成器界面
 */
public class GeneratorPanel extends Panel {
	/**
	 * @type long
	 * @field serialVersionUID
	 * @state
	 */
	private static final long serialVersionUID = 1L;
	private JRadioButton radio = new JRadioButton("生成全部表");
	private JRadioButton radio2 = new JRadioButton("生成指定表");
	private JTextField tableName = new JTextField();
	private JButton reset = new JButton("清空");
	private JLabel tips = new JLabel("（可以在下列表格中选择需要生成的数据表）");

	private JRadioButton radio3 = new JRadioButton("生成全部文件");
	private JRadioButton radio4 = new JRadioButton("生成指定文件");
	private JRadioButton nojg = new JRadioButton("不生成文件");

	private JCheckBox controllerCheck = new JCheckBox("生成控制器");
	private JCheckBox serviceCheck = new JCheckBox("生成service类");
	private JCheckBox daoCheck = new JCheckBox("生成dao类");
	private JCheckBox modelCheck = new JCheckBox("生成实体类");
	private JCheckBox modelArrayCheck = new JCheckBox("生成实体Array");
	private JCheckBox jsCheck = new JCheckBox("生成js文件");
	private JCheckBox jspCheck = new JCheckBox("生成jsp文件");
	private JCheckBox mapperCheck = new JCheckBox("生成mapper文件");

	private JRadioButton defaultTemplate = new JRadioButton(
			"使用默认生成模板（默认生成模板在 src/main/resources : template --> defaultTemplate下）");

	private JRadioButton createTableRadio = new JRadioButton("创建数据表");
	private JRadioButton notCreateTableRadio = new JRadioButton("不创建数据表");

	private JRadioButton aotuJSRadio = new JRadioButton("将js自动引用到项目");
	private JRadioButton notAutoJSRadio = new JRadioButton("不将js自动引用到项目");

	private JRadioButton autoMenu = new JRadioButton("自动生成后台菜单");
	private JRadioButton notAutoMenu = new JRadioButton("不自动生成后台菜单");

	ButtonGroup bg = new ButtonGroup();
	ButtonGroup bg2 = new ButtonGroup();
	ButtonGroup bg3 = new ButtonGroup();
	ButtonGroup bg4 = new ButtonGroup();
	ButtonGroup bg5 = new ButtonGroup();
	private JTable table = new JTable();
	private JTable column = new JTable();

	private JButton button = new JButton("生成代码");
	private JButton undo = new JButton("删除代码");

	public GeneratorPanel() {
		this.setBackground(Color.WHITE);
		this.setLayout(null);

		tableName.setBounds(130, 10, 240, 25);
		this.add(tableName);

		reset.setBounds(380, 10, 80, 25);
		this.add(reset);
		reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableName.setText("");
			}
		});

		tips.setBounds(470, 10, 290, 25);
		this.add(tips);

		bg.add(radio);
		bg.add(radio2);
		radio.setBounds(10, 40, 100, 25);
		radio.setBackground(Color.WHITE);

		radio2.setBounds(10, 10, 100, 25);
		radio2.setSelected(true);
		radio2.setBackground(Color.WHITE);
		this.add(radio);
		this.add(radio2);

		radio.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tableName.setEnabled(false);
				tableName.setText("");
				tableName.setBackground(Color.LIGHT_GRAY);
			}
		});

		radio2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tableName.setEnabled(true);
				tableName.setBackground(Color.WHITE);
			}
		});

		bg2.add(radio3);
		bg2.add(radio4);
		bg2.add(nojg);
		radio3.setBounds(10, 390, 130, 25);
		radio3.setSelected(true);
		radio3.setBackground(Color.WHITE);

		radio4.setBounds(140, 390, 130, 25);
		radio4.setBackground(Color.WHITE);

		nojg.setBounds(270, 390, 130, 25);
		nojg.setBackground(Color.WHITE);
		this.add(radio3);
		this.add(radio4);
		this.add(nojg);

		// 添加复习框
		controllerCheck.setBounds(10, 420, 125, 25);
		controllerCheck.setBackground(Color.WHITE);
		controllerCheck.setSelected(true);
		this.add(controllerCheck);

		serviceCheck.setBounds(140, 420, 125, 25);
		serviceCheck.setBackground(Color.WHITE);
		serviceCheck.setSelected(true);
		this.add(serviceCheck);

		daoCheck.setBounds(270, 420, 125, 25);
		daoCheck.setBackground(Color.WHITE);
		daoCheck.setSelected(true);
		this.add(daoCheck);

		modelCheck.setBounds(400, 420, 125, 25);
		modelCheck.setBackground(Color.WHITE);
		modelCheck.setSelected(true);
		this.add(modelCheck);

		modelArrayCheck.setBounds(10, 450, 125, 25);
		modelArrayCheck.setBackground(Color.WHITE);
		modelArrayCheck.setSelected(true);
		this.add(modelArrayCheck);

		jsCheck.setBounds(140, 450, 125, 25);
		jsCheck.setBackground(Color.WHITE);
		jsCheck.setSelected(true);
		this.add(jsCheck);

		jspCheck.setBounds(270, 450, 125, 25);
		jspCheck.setBackground(Color.WHITE);
		jspCheck.setSelected(true);
		this.add(jspCheck);

		mapperCheck.setBounds(400, 450, 125, 25);
		mapperCheck.setBackground(Color.WHITE);
		mapperCheck.setSelected(true);
		this.add(mapperCheck);

		controllerCheck.setEnabled(false);
		serviceCheck.setEnabled(false);
		daoCheck.setEnabled(false);
		modelCheck.setEnabled(false);
		modelArrayCheck.setEnabled(false);
		jsCheck.setEnabled(false);
		jspCheck.setEnabled(false);
		mapperCheck.setEnabled(false);

		defaultTemplate.setBounds(10, 480, 580, 25);
		defaultTemplate.setBackground(Color.WHITE);
		defaultTemplate.setSelected(true);
		this.add(defaultTemplate);

		createTableRadio.setBounds(10, 510, 110, 25);
		createTableRadio.setBackground(Color.WHITE);
		createTableRadio.setSelected(true);
		this.add(createTableRadio);

		bg3.add(notCreateTableRadio);
		bg3.add(createTableRadio);
		notCreateTableRadio.setBounds(130, 510, 110, 25);
		notCreateTableRadio.setBackground(Color.WHITE);
		this.add(notCreateTableRadio);

		bg4.add(aotuJSRadio);
		bg4.add(notAutoJSRadio);
		aotuJSRadio.setBounds(10, 540, 160, 25);
		aotuJSRadio.setBackground(Color.WHITE);
		aotuJSRadio.setSelected(true);
		this.add(aotuJSRadio);

		notAutoJSRadio.setBounds(180, 540, 160, 25);
		notAutoJSRadio.setBackground(Color.WHITE);
		this.add(notAutoJSRadio);

		bg5.add(autoMenu);
		bg5.add(notAutoMenu);
		autoMenu.setBounds(10, 570, 160, 25);
		autoMenu.setBackground(Color.WHITE);
		autoMenu.setSelected(true);
		this.add(autoMenu);

		notAutoMenu.setBounds(180, 570, 160, 25);
		notAutoMenu.setBackground(Color.WHITE);
		this.add(notAutoMenu);

		radio3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controllerCheck.setSelected(true);
				serviceCheck.setSelected(true);
				daoCheck.setSelected(true);
				modelCheck.setSelected(true);
				modelArrayCheck.setSelected(true);
				jsCheck.setSelected(true);
				jspCheck.setSelected(true);
				mapperCheck.setSelected(true);

				controllerCheck.setEnabled(false);
				serviceCheck.setEnabled(false);
				daoCheck.setEnabled(false);
				modelCheck.setEnabled(false);
				modelArrayCheck.setEnabled(false);
				jsCheck.setEnabled(false);
				jspCheck.setEnabled(false);
				mapperCheck.setEnabled(false);
			}
		});

		radio4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controllerCheck.setSelected(false);
				serviceCheck.setSelected(false);
				daoCheck.setSelected(false);
				modelCheck.setSelected(false);
				modelArrayCheck.setSelected(false);
				jsCheck.setSelected(false);
				jspCheck.setSelected(false);
				mapperCheck.setSelected(false);

				controllerCheck.setEnabled(true);
				serviceCheck.setEnabled(true);
				daoCheck.setEnabled(true);
				modelCheck.setEnabled(true);
				modelArrayCheck.setEnabled(true);
				jsCheck.setEnabled(true);
				jspCheck.setEnabled(true);
				mapperCheck.setEnabled(true);
			}
		});

		nojg.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controllerCheck.setSelected(false);
				serviceCheck.setSelected(false);
				daoCheck.setSelected(false);
				modelCheck.setSelected(false);
				modelArrayCheck.setSelected(false);
				jsCheck.setSelected(false);
				jspCheck.setSelected(false);
				mapperCheck.setSelected(false);

				controllerCheck.setEnabled(false);
				serviceCheck.setEnabled(false);
				daoCheck.setEnabled(false);
				modelCheck.setEnabled(false);
				modelArrayCheck.setEnabled(false);
				jsCheck.setEnabled(false);
				jspCheck.setEnabled(false);
				mapperCheck.setEnabled(false);
			}
		});

		// 添加生成按钮
		button.setBounds(10, 620, 110, 25);
		button.setBackground(Color.GREEN);
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (StringUtils.isBlank(tableName.getText())
						&& radio2.isSelected()) {
					JOptionPane.showMessageDialog(null, "指定表名为空，未进行代码生成操作！");
					return;
				}
				int result = JOptionPane.showConfirmDialog(null, "您确定要生成代码吗？",
						"提示", JOptionPane.YES_NO_OPTION);
				if (result == 0) {
					Run r = new Run();
					if (radio2.isSelected()) {// 选择生成制定表
						if (radio3.isSelected()) {// 选择生成全部文件
							r.processSingleTable(tableName.getText().trim());
							JOptionPane
									.showMessageDialog(null, "代码生成成功，请刷新项目！");
						} else if (radio4.isSelected()) {// 选择生成制定文件
							if (controllerCheck.isSelected()) {
								r.processSingleTable(GeneratorType.CONTROLLER,
										tableName.getText().trim());
							}
							if (serviceCheck.isSelected()) {
								r.processSingleTable(GeneratorType.SERVICE,
										tableName.getText().trim());
								r.processSingleTable(GeneratorType.SERVICEIMPL,
										tableName.getText().trim());
							}
							if (daoCheck.isSelected()) {
								r.processSingleTable(GeneratorType.DAO,
										tableName.getText().trim());
								r.processSingleTable(GeneratorType.DAOIMPL,
										tableName.getText().trim());
							}
							if (modelCheck.isSelected()) {
								r.processSingleTable(GeneratorType.MODEL,
										tableName.getText().trim());
							}
							if (modelArrayCheck.isSelected()) {
								r.processSingleTable(GeneratorType.MODELARRAY,
										tableName.getText().trim());
							}
							if (jsCheck.isSelected()) {
								r.processSingleTable(GeneratorType.JS,
										tableName.getText().trim());
							}
							if (jspCheck.isSelected()) {
								r.processSingleTable(GeneratorType.JSP,
										tableName.getText().trim());
							}
							if (mapperCheck.isSelected()) {
								r.processSingleTable(GeneratorType.MAPPER,
										tableName.getText().trim());
							}
							JOptionPane
									.showMessageDialog(null, "代码生成成功，请刷新项目！");
						} else {
							JOptionPane.showMessageDialog(null, "未生成如何代码！");
						}

						if (createTableRadio.isSelected()) {// 创建数据库表
							DataBaseHelper.dropAndCreateTable(PDMParse
									.getTableInfo(
											ProjectProperty.RESOURCES_PATH
													+ "project.pdm", tableName
													.getText().trim()));
						}
						if (aotuJSRadio.isSelected()) {
							RefJS rj = new RefJS();
							rj.refManageJS(tableName.getText().trim());

						}
						if (autoMenu.isSelected()) {
							AutoMenu menu = new AutoMenu();
							menu.addMenu(
									PDMParse.getTableInfo(
											ProjectProperty.RESOURCES_PATH
													+ "project.pdm",
											tableName.getText().trim())
											.getNameCN(),
									PDMParse.getTableInfo(
											ProjectProperty.RESOURCES_PATH
													+ "project.pdm",
											tableName.getText().trim())
											.getName());
						}
					} else {// 选择生成全部表
						if (radio3.isSelected()) {// 选择生成全部文件
							r.processAllTables();
							JOptionPane
									.showMessageDialog(null, "代码生成成功，请刷新项目！");
						} else if (radio4.isSelected()) {// 选择生成制定文件
							if (controllerCheck.isSelected()) {
								r.processAllTables(GeneratorType.CONTROLLER);
							}
							if (serviceCheck.isSelected()) {
								r.processAllTables(GeneratorType.SERVICE);
								r.processAllTables(GeneratorType.SERVICEIMPL);
							}
							if (daoCheck.isSelected()) {
								r.processAllTables(GeneratorType.DAO);
								r.processAllTables(GeneratorType.DAOIMPL);
							}
							if (modelCheck.isSelected()) {
								r.processAllTables(GeneratorType.MODEL);
							}
							if (modelArrayCheck.isSelected()) {
								r.processAllTables(GeneratorType.MODELARRAY);
							}
							if (jsCheck.isSelected()) {
								r.processAllTables(GeneratorType.JS);
							}
							if (jspCheck.isSelected()) {
								r.processAllTables(GeneratorType.JSP);
							}
							if (mapperCheck.isSelected()) {
								r.processAllTables(GeneratorType.MAPPER);
							}
							JOptionPane
									.showMessageDialog(null, "代码生成成功，请刷新项目！");
						} else {
							JOptionPane.showMessageDialog(null, "未生成如何代码！");
						}

						if (createTableRadio.isSelected()) {// 创建数据库表
							DataBaseHelper.dropAndCreateTable(PDMParse
									.getTableInfo(ProjectProperty.RESOURCES_PATH
											+ "project.pdm"));
						}

						if (aotuJSRadio.isSelected()) {
							RefJS rj = new RefJS();
							List<Table> list = PDMParse
									.getTableInfo(ProjectProperty.RESOURCES_PATH
											+ "project.pdm");
							for (Table t : list) {
								rj.refManageJS(t.getName());
							}

						}
						if (autoMenu.isSelected()) {
							AutoMenu menu = new AutoMenu();
							List<Table> list = PDMParse
									.getTableInfo(ProjectProperty.RESOURCES_PATH
											+ "project.pdm");
							for (Table t : list) {
								menu.addMenu(t.getNameCN(), t.getName());
							}
						}
					}
				}
			}
		});
		this.add(button);

		// 添加撤销按钮
		undo.setBounds(130, 620, 110, 25);
		undo.setBackground(Color.PINK);
		this.add(undo);
		undo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null,
						"请谨慎操作，您确定要删除代码吗？", "提示", JOptionPane.YES_NO_OPTION);
				if (result == 0) {
					Run run = new Run();
					if (radio.isSelected()) {
						run.undo(null);
						JOptionPane.showMessageDialog(null, "代码删除成功，请刷新项目！");
					} else if (radio2.isSelected()) {
						run.undo(tableName.getText().trim());
						JOptionPane.showMessageDialog(null, "代码删除成功，请刷新项目！");
					}
				}
			}
		});

		// 添加数据表表格
		final List<Table> list = PDMParse
				.getTableInfo(ProjectProperty.RESOURCES_PATH + "project.pdm");
		String[] headers = { "表名", "注释" };
		String[][] cellData = new String[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			cellData[i][0] = list.get(i).getName();
			cellData[i][1] = list.get(i).getNameCN();
		}
		DefaultTableModel model = new DefaultTableModel(cellData, headers);
		table.setModel(model);
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(10, 80, 400, 300);
		this.add(pane);

		String[] headers2 = { "列名", "注释", "字段类型", "是否必填", "是否主键" };
		String[][] cellData2 = null;
		final DefaultTableModel model2 = new DefaultTableModel(cellData2,
				headers2);
		column.setModel(model2);
		JScrollPane pane2 = new JScrollPane(column);
		pane2.setBounds(420, 80, MainFrame.DEFAULT_WIDTH - 440, 300);
		this.add(pane2);

		// 添加数据列的表格

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String tableName2 = table.getValueAt(row, 0).toString();
				if (tableName.isEnabled()) {
					tableName.setText(tableName2);
				}

				for (int i = column.getRowCount(); i > 0; i--) {
					model2.removeRow(i - 1);
				}

				for (Table t : list) {
					if (t.getName().equals(tableName2)) {
						List<Column> cols = t.getColumnList();
						for (Column c : cols) {
							model2.addRow(new String[] { c.getName(),
									c.getNameCN(), c.getMetaType(),
									String.valueOf(c.isRequired()),
									String.valueOf(c.isPrimaryKey()) });
						}
						break;
					}
				}
			}
		});

	}

}
