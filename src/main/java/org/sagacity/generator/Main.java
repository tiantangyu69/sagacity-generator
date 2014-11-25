/*******************************************************
 * @author LIZHITAO
 * @date 2013-9-9 上午11:08:34
 * @name Main.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator;

import javax.swing.JFrame;

import org.sagacity.generator.client.MainFrame;

/**
 * @author LIZHITAO
 * 
 */
public class Main {

	/**
	 * @param
	 * @name main
	 * @active
	 * @state
	 * @type void
	 * @time 上午11:08:34
	 * @exception/throws
	 * @see
	 * @since
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new MainFrame();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
