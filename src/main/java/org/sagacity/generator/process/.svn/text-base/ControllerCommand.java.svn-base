/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-24 下午5:06:44
 * @name ControllerCommand.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.process;

import java.util.List;

import org.sagacity.generator.parse.Table;


/**
 * @author LIZHITAO 生成控制器命令
 */
public class ControllerCommand implements Command {
	private ControllerGenerator generator;
	
	public ControllerCommand(ControllerGenerator generator){
		this.generator = generator;
	}

	/**
	 * @param
	 * @name execute
	 * @active
	 * @state
	 * @type ControllerCommand
	 * @time 下午5:06:44
	 * @see org.sagacity.generator.process.Command#execute()
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
	 * @type ControllerCommand
	 * @time 下午5:06:44
	 * @see org.sagacity.generator.process.Command#undo()
	 */
	@Override
	public void undo(List<Table> list, String tableName) {
		generator.undoProcess(list, tableName);
	}

}
