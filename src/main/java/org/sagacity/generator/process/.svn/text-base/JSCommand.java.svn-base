/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-24 下午5:44:34
 * @name JSCommand.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.process;

import java.util.List;

import org.sagacity.generator.parse.Table;

/**
 * @author LIZHITAO JS生成命令
 */
public class JSCommand implements Command {
	private JSGenerator generator;
	
	public JSCommand(JSGenerator generator){
		this.generator = generator;
	}

	/**
	 * @param
	 * @name execute
	 * @active
	 * @state
	 * @type JSCommand
	 * @time 下午5:44:34
	 * @see org.sagacity.generator.process.Command#execute(java.util.List,
	 *      java.lang.String)
	 */
	@Override
	public void execute(List<Table> list, String tableName) {
		generator.process(list, tableName);
	}

	/**
	 * @param
	 * @name undo
	 * @active
	 * @state
	 * @type JSCommand
	 * @time 下午5:44:34
	 * @see org.sagacity.generator.process.Command#undo(java.util.List,
	 *      java.lang.String)
	 */
	@Override
	public void undo(List<Table> list, String tableName) {
		generator.undoProcess(list, tableName);
	}

}
