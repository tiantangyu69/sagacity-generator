/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-24 下午5:29:30
 * @name ServiceImplCommand.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.process;

import java.util.List;

import org.sagacity.generator.parse.Table;

/**
 * @author LIZHITAO
 * 生成serviceImpl的命令
 */
public class ServiceImplCommand implements Command {
	private ServiceImplGenerator generator;
	
	public ServiceImplCommand(ServiceImplGenerator generator){
		this.generator = generator;
	}

	/**
	 * @param 
	 * @name execute
	 * @active
	 * @state
	 * @type ServiceImplCommand
	 * @time 下午5:29:30
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
	 * @type ServiceImplCommand
	 * @time 下午5:29:30
	 * @see org.sagacity.generator.process.Command#undo(java.util.List, java.lang.String)
	 */
	@Override
	public void undo(List<Table> list, String tableName) {
		generator.undoProcess(list, tableName);
	}

}
