/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-24 下午5:41:10
 * @name ModelArrayCommand.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.process;

import java.util.List;

import org.sagacity.generator.parse.Table;

/**
 * @author LIZHITAO
 * modelarray命令
 */
public class ModelArrayCommand implements Command {
	private ModelArrayGenerator generator;
	
	public ModelArrayCommand(ModelArrayGenerator generator){
		this.generator = generator;
	}

	/**
	 * @param 
	 * @name execute
	 * @active
	 * @state
	 * @type ModelArrayCommand
	 * @time 下午5:41:11
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
	 * @type ModelArrayCommand
	 * @time 下午5:41:11
	 * @see org.sagacity.generator.process.Command#undo(java.util.List, java.lang.String)
	 */
	@Override
	public void undo(List<Table> list, String tableName) {
		generator.undoProcess(list, tableName);
	}

}
