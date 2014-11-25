/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-24 下午5:50:50
 * @name JSPCommand.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.process;

import java.util.List;

import org.sagacity.generator.parse.Table;

/**
 * @author LIZHITAO JSP生成文件命令
 *
 */
public class JSPCommand implements Command {
	private JSPGenerator generator;
	
	public JSPCommand(JSPGenerator generator){
		this.generator = generator;
	}

	/**
	 * @param 
	 * @name execute
	 * @active
	 * @state
	 * @type JSPCommand
	 * @time 下午5:50:50
	 * @see org.sagacity.generator.process.Command#execute(java.util.List, java.lang.String)
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
	 * @type JSPCommand
	 * @time 下午5:50:50
	 * @see org.sagacity.generator.process.Command#undo(java.util.List, java.lang.String)
	 */
	@Override
	public void undo(List<Table> list, String tableName) {
		generator.undoProcess(list, tableName);
	}

}
