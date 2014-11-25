/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-24 下午5:23:15
 * @name ServiceCommand.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.process;

import java.util.List;

import org.sagacity.generator.parse.Table;

/**
 * @author LIZHITAO 生成service的命令类
 */
public class ServiceCommand implements Command {
	private ServiceGenerator generator;

	public ServiceCommand(ServiceGenerator generator) {
		this.generator = generator;
	}

	/**
	 * @param
	 * @name execute
	 * @active
	 * @state
	 * @type ServiceCommand
	 * @time 下午5:23:15
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
	 * @type ServiceCommand
	 * @time 下午5:23:15
	 * @see org.sagacity.generator.process.Command#undo(java.util.List,
	 *      java.lang.String)
	 */
	@Override
	public void undo(List<Table> list, String tableName) {
		generator.undoProcess(list, tableName);
	}

}
