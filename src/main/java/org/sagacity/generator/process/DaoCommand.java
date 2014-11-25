/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-24 下午5:33:10
 * @name DaoCommand.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.process;

import java.util.List;

import org.sagacity.generator.parse.Table;

/**
 * @author LIZHITAO
 *
 */
public class DaoCommand implements Command {
	private DaoGenerator generator;
	
	public DaoCommand(DaoGenerator generator){
		this.generator = generator;
	}

	/**
	 * @param 
	 * @name execute
	 * @active
	 * @state
	 * @type DaoCommand
	 * @time 下午5:33:10
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
	 * @type DaoCommand
	 * @time 下午5:33:10
	 * @see org.sagacity.generator.process.Command#undo(java.util.List, java.lang.String)
	 */
	@Override
	public void undo(List<Table> list, String tableName) {
		generator.undoProcess(list, tableName);
	}

}
