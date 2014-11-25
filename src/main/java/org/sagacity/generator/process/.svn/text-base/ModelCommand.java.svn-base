/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-24 下午5:38:40
 * @name ModelCommand.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.process;

import java.util.List;

import org.sagacity.generator.parse.Table;

/**
 * @author LIZHITAO
 * MODEL生成命令
 */
public class ModelCommand implements Command {
	private ModelGenerator generator;
	
	public ModelCommand(ModelGenerator generator){
		this.generator = generator;
	}

	/**
	 * @param 
	 * @name execute
	 * @active
	 * @state
	 * @type ModelCommand
	 * @time 下午5:38:40
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
	 * @type ModelCommand
	 * @time 下午5:38:40
	 * @see org.sagacity.generator.process.Command#undo(java.util.List, java.lang.String)
	 */
	@Override
	public void undo(List<Table> list, String tableName) {
		generator.undoProcess(list, tableName);
	}

}
