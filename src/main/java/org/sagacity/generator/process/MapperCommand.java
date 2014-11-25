/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-24 下午5:48:16
 * @name MapperCommand.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.process;

import java.util.List;

import org.sagacity.generator.parse.Table;

/**
 * @author LIZHITAO MAPPER 文件生成命令
 * 
 */
public class MapperCommand implements Command {
	private MapperGenerator generator;
	
	public MapperCommand(MapperGenerator generator){
		this.generator = generator;
	}

	/**
	 * @param
	 * @name execute
	 * @active
	 * @state
	 * @type MapperCommand
	 * @time 下午5:48:16
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
	 * @type MapperCommand
	 * @time 下午5:48:16
	 * @see org.sagacity.generator.process.Command#undo(java.util.List,
	 *      java.lang.String)
	 */
	@Override
	public void undo(List<Table> list, String tableName) {
		generator.undoProcess(list, tableName);
	}

}
