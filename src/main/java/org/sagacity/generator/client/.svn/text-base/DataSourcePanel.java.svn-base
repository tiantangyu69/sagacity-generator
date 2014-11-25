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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.sagacity.generator.util.JDBCFile;
import org.sagacity.generator.util.JDBCPropertyUtils;

/**
 * @author LIZHITAO 数据源配置界面
 */
public class DataSourcePanel extends Panel {

	/**
	 * @type long
	 * @field serialVersionUID
	 * @state
	 */
	private static final long serialVersionUID = 1L;
	private JLabel driverLabel = new JLabel();
	private JTextField driverText = new JTextField();

	private JLabel urlLabel = new JLabel();
	private JTextField urlText = new JTextField();

	private JLabel usernameLabel = new JLabel();
	private JTextField usernameText = new JTextField();

	private JLabel pwdLabel = new JLabel();
	private JTextField pwdText = new JTextField();

	private JButton saveConfig = new JButton("保存配置");

	public DataSourcePanel() {
		final JDBCPropertyUtils util = new JDBCPropertyUtils();

		this.setBackground(Color.WHITE);
		this.setLayout(null);

		driverLabel.setText("数据库驱动：");
		driverLabel.setBounds(10, 10, 140, 25);

		driverText.setBounds(150, 10, 480, 25);
		driverText.setText(util.getJDBCProperty().getDriver());

		urlLabel.setText("数据库URL：");
		urlLabel.setBounds(10, 40, 140, 25);

		urlText.setBounds(150, 40, 480, 25);
		urlText.setText(util.getJDBCProperty().getUrl());

		usernameLabel.setText("数据库用户名：");
		usernameLabel.setBounds(10, 70, 140, 25);

		usernameText.setBounds(150, 70, 480, 25);
		usernameText.setText(util.getJDBCProperty().getUsername());

		pwdLabel.setText("数据库密码：");
		pwdLabel.setBounds(10, 100, 140, 25);

		pwdText.setBounds(150, 100, 480, 25);
		pwdText.setText(util.getJDBCProperty().getPassword());

		saveConfig.setBounds(10, 130, 100, 25);

		saveConfig.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String driver = driverText.getText().trim();
				String url = urlText.getText().trim();
				String username = usernameText.getText().trim();
				String pwd = pwdText.getText().trim();

				util.setJDBCProperty(JDBCFile.DRIVER + "$" + driver + ","
						+ JDBCFile.URL + "$" + url + "," + JDBCFile.USERNAME
						+ "$" + username + "," + JDBCFile.PASSWORD + "$" + pwd);

				JOptionPane.showMessageDialog(null, "数据库配置保存成功！");
			}
		});

		this.add(driverLabel);
		this.add(driverText);
		this.add(urlLabel);
		this.add(urlText);
		this.add(usernameLabel);
		this.add(usernameText);
		this.add(pwdLabel);
		this.add(pwdText);
		this.add(saveConfig);
	}

}
