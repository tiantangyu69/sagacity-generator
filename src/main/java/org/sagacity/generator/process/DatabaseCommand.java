/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-25 上午11:01:28
 * @name DatabaseCommand.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.process;

import java.util.List;

import org.sagacity.generator.parse.Table;

/**
 * @author LIZHITAO
 * 数据库执行命令
 */
public class DatabaseCommand implements Command {

	/**
	 * @param 
	 * @name execute
	 * @active
	 * @state
	 * @type DatabaseCommand
	 * @time 上午11:01:28
	 * @see org.sagacity.generator.process.Command#execute(java.util.List, java.lang.String)
	 */
	@Override
	public void execute(List<Table> list, String tableName) {

	}

	/**
	 * @param 
	 * @name undo
	 * @active
	 * @state
	 * @type DatabaseCommand
	 * @time 上午11:01:28
	 * @see org.sagacity.generator.process.Command#undo(java.util.List, java.lang.String)
	 */
	@Override
	public void undo(List<Table> list, String tableName) {

	}

}
